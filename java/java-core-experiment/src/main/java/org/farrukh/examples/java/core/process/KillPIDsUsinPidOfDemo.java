package org.farrukh.examples.java.core.process;

import java.io.IOException;
import java.util.List;

public class KillPIDsUsinPidOfDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        List<String> chromeTabs = PidsToList.readPIDsToList("chrome");
        killAll(chromeTabs);
    }

    private static void killAll(final List<String> chromeTabs) {
        ProcessBuilder processBuilder = new ProcessBuilder();
        chromeTabs.parallelStream().forEach(pid -> {
            processBuilder.command("kill", pid);
            try {
                processBuilder.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
