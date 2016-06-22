package org.farrukh.examples.gradle.docker

/**
 * Created by Farrukhjon on 6/11/15.
 */
class Application {

    public static void main(String[] args) {
        def serverSocket = new ServerSocket(2020)
        while (true) {
            println 'processing server...'
            serverSocket.accept { socket ->
                socket.withStreams { input, output ->
                    def reader = input.newReader()
                    def buffer = reader.readLine()
                    println "server received: $buffer"
                    def now = new Date()
                    output << "server response($now)" + buffer + "\n"
                }
            }
        }
    }

}
