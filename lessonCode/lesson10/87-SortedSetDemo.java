// sorted set
package net.thumbtack.lessons;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {

	
	private static void printSet(Set<Integer> set) {
		System.out.println("Printing set");
		for(Integer i : set)
			System.out.println(i);
		
	}
	
	public static void main(String[] args) {
	
		SortedSet<Integer> setInt = new TreeSet<Integer>();
		setInt.add(44);
		setInt.add(332);
		setInt.add(1);
		setInt.add(123);
		setInt.add(1);
		
		printSet(setInt);
		
	}
}
