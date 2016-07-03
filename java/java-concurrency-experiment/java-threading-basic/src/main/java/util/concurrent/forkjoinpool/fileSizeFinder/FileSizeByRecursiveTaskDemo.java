package util.concurrent.forkjoinpool.fileSizeFinder;

import java.io.File;
import java.util.concurrent.ForkJoinPool;

public class FileSizeByRecursiveTaskDemo {

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
}
