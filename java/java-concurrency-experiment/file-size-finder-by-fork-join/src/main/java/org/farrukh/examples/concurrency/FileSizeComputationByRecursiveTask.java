/*
 * Copyright (C) F.D. Sattorov Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by F.D. Sattorov <farrukhjon.sattorov@gmail.com>, May 2016.
 */

package org.farrukh.examples.concurrency;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileSizeComputationByRecursiveTask {

    public static void main(String[] args) {

        ForkJoinPool joinPool = new ForkJoinPool();

        long start = System.nanoTime();
        FileSizeFinderTask finderTask = new FileSizeFinderTask(new File("/home/vagrant/Documentations/"));
        Long totalFilesSize = joinPool.invoke(finderTask);
        long end = System.nanoTime();

        System.out.printf("%s %s", "Total files size in bytes:", totalFilesSize);
        System.out.println();
        System.out.printf("%s %s", "Time taken in seconds:", (end - start) / 1.0e9);

    }

    private static class FileSizeFinderTask extends RecursiveTask<Long> {

        private final File file;

        FileSizeFinderTask(File file) {
            this.file = file;
        }

        @Override
        protected Long compute() {
            long size = 0;
            if (file.isFile()) {
                size = file.length();
            } else {
                File[] children = file.listFiles();
                if (children != null) {
                    List<ForkJoinTask<Long>> tasks = new ArrayList<>();
                    for (File child : children) {
                        if (child.isFile()) {
                            size += child.length();
                        } else {
                            tasks.add(new FileSizeFinderTask(child));
                        }
                    }
                    for (final ForkJoinTask<Long> task : invokeAll(tasks)) {
                        size += task.join();
                    }
                }
            }
            return size;
        }
    }
}
