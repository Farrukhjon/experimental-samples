package org.farrukh.experiments.java.thread;

public class PrintThreadObject {

	public static void main(String[] args) {
		
		Thread thread_0 = new Thread();
		Thread thread_1 = new Thread();
		Thread thread_2 = new Thread();

		System.out.println("Detail thread info" + thread_0);
		System.out.println("Detail thread info" + thread_1);
		System.out.println("Detail thread info" + thread_2);
		
		System.out.println("Thread priorety: " + thread_0.getPriority());
		System.out.println("Thread priorety: " + thread_1.getPriority());
		System.out.println("Thread priorety: " + thread_2.getPriority());

		System.out.println("Thread group name: " + thread_0.getThreadGroup().getName());
		System.out.println("Thread group name: " + thread_1.getThreadGroup().getName());
		System.out.println("Thread group name: " + thread_2.getThreadGroup().getName());
		
	}

}
