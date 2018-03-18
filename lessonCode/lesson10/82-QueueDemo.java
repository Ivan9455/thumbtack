// queue
package net.thumbtack.lessons;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo {
	
	public static void main(String[] args) {
		
		Queue<String> queueNatural = new PriorityQueue<String>();
		queueNatural.add("Abc"); //1
		queueNatural.add("abc"); //3
		queueNatural.add("aBC"); //2
		
		System.out.println("Peek = " + queueNatural.peek());
	
		System.out.println("Natural");
		while(!queueNatural.isEmpty()) {
			System.out.println(queueNatural.poll());
		}
		
		
		
		Queue<String> queueComparator = new PriorityQueue<String>(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				return -str1.compareTo(str2);
			}
		});
		queueComparator.add("abc"); //2
		queueComparator.add("Abc"); //3
		queueComparator.add("aBC"); //1
		
		
		System.out.println("Comparator");
		while(!queueComparator.isEmpty()) {
			System.out.println(queueComparator.poll());
		}

		Queue<String> queueComparatorLambda = new PriorityQueue<String>((str1, str2) -> -str1.compareTo(str2));
		queueComparatorLambda.add("abc"); //2
		queueComparatorLambda.add("Abc"); //3
		queueComparatorLambda.add("aBC"); //1
		
		
		System.out.println("Comparator Lambda");
		while(!queueComparatorLambda.isEmpty()) {
			System.out.println(queueComparatorLambda.poll());
		}

	
	
	}

}
