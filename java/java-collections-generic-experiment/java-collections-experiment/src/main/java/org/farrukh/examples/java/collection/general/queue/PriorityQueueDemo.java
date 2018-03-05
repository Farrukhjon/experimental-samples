package org.farrukh.examples.java.collection.general.queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

//Queues typically, but do not necessarily, order elements in a FIFO (first-in-first-out) manner
public class PriorityQueueDemo {

	public static void main(String[] args) {

		PriorityQueue<String> pq = new PriorityQueue<>();

		pq.offer("A"); //The offer() method inserts an element if possible, otherwise returning false
		pq.offer("B");
		pq.offer("C");
		pq.offer("D");
		pq.offer("E");
		pq.offer("F");
		pq.offer("G");
		
		pq.add("H");// If adding fail method throws exception
		

		System.out.println(pq);

		final Iterator<String> iterator = pq.iterator();
		while (iterator.hasNext()) {
			//Retrieves and removes the head of this queue, or returns null if this queue is empty.
			final String el = pq.poll();
			System.out.printf("%-3s", el);
		}
		System.out.println();
		
		try{
			//Retrieves and removes the head of this queue. 
			//This method differs from poll only in that it throws an exception if this queue is empty.
			String removalResult = pq.remove();
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}
		
		String peekResult = pq.peek(); // Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		System.out.println(peekResult); //null
		
		try{
			//Retrieves, but does not remove, the head of this queue. 
			//This method differs from peek only in that it throws an exception if this queue is empty.
			pq.element(); 
		}catch(NoSuchElementException e){
			e.printStackTrace();
		}

		System.out.println(pq);
		
		try{
			pq.add(null); // add() method throws NullPointerException
		}catch(NullPointerException e){
			e.printStackTrace();
		}

		try{
			pq.offer(null); // offer too do not allow insertion of null elements and method throws NullPointerException
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
