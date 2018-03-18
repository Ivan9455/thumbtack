// dequeue
package net.thumbtack.lessons;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;


public class DequeueDemo {
	
	public static void main(String[] args) {
		Deque<Integer> deqArray = new ArrayDeque<Integer>();
		deqArray.addFirst(10);
		deqArray.addLast(20);
		deqArray.addFirst(30);
		System.out.println(deqArray.pollFirst());
		System.out.println(deqArray.pollLast());
		System.out.println(deqArray.pollFirst());

		Deque<Integer> deqList = new LinkedList<Integer>();
		deqList.addFirst(10);
		deqList.addLast(20);
		deqList.addFirst(30);
		System.out.println(deqList.pollFirst());
		System.out.println(deqList.pollLast());
		System.out.println(deqList.pollFirst());
	
	
	}
}
