// iterator
package net.thumbtack.lessons;

import java.util.Iterator;
import java.util.Vector;

public class IterableDemo {
	
	public static void main(String[] args) {
		Vector<Integer> a = new Vector<Integer>();
		a.add(10);
		a.add(20);
		Iterator<Integer> iter = a.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
	}

}
