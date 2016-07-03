package util.concurrent.forkjoinpool.fileSizeFinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class FileSizeFinderTask extends RecursiveTask<Long> {

    private final File file;

    public FileSizeFinderTask(File file) {
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
