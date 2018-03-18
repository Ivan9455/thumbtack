// iterator
package net.thumbtack.lessons;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class IteratorDemo {
	
	public static void main(String[] args) {
		Vector<Integer> a = new Vector<Integer>();
		a.add(10);
		a.add(20);
		a.add(30);

		Iterator<Integer> iter = a.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}


		ListIterator<Integer> listIterForward = a.listIterator();
		while(listIterForward.hasNext()) {
			System.out.println(listIterForward.next());
		}
		
		
		ListIterator<Integer> listIterReverse = a.listIterator(3);
		while(listIterReverse.hasPrevious()) {
			System.out.println(listIterReverse.previous());
		}
		
	}

}
