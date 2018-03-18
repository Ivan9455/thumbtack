// list
package net.thumbtack.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListDemo {
	
	static void printList(List<Integer> list) {
		System.out.println("Printing list");
		if(list.size() > 0)
		for(Integer i : list) {
			System.out.println(i);
		}
		else 
			System.out.println("Empty list");
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
//		List<Integer> list = new LinkedList<Integer>();

		list.add(10);
		list.add(10);
		list.add(20);
		list.add(0,30);
		
		printList(list);
		
		int el1 = list.get(1);
		
		System.out.println(el1);
		
		try {
			int el4 = list.get(4);
		}
		catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	
		ListIterator<Integer> listIterForward = list.listIterator();
		while(listIterForward.hasNext()) {
			System.out.println(listIterForward.next());
		}
		
		ListIterator<Integer> listIterReverse = list.listIterator(3);
		while(listIterReverse.hasPrevious()) {
			System.out.println(listIterReverse.previous());
		}
		
		List<Integer> list2 = new ArrayList<Integer>(list);
		
		printList(list2);
		
		list2.addAll(list);
		
		printList(list2);
		
		System.out.println(list2.contains(10));
		System.out.println(list2.containsAll(list));
		
		list.set(0, 5);
		list.remove(1);
		list.remove(1);
		
		list2.retainAll(list);
		printList(list2);

		Integer[] array = list.toArray(new Integer[0]);
		
		
		list.clear();
		printList(list);
	}
}
