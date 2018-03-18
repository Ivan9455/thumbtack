// set
package net.thumbtack.lessons;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class LinkedHashSetDemo {
	
	private static void printSet(String name, Set<Integer> set) {
		System.out.println("Printing " + name);
		for(Integer i : set)
			System.out.println(i);
		
	}
	
	
	public static void main(String[] args) {
		
		Set<Integer> setHash = new HashSet<Integer>();
		setHash.add(44);
		setHash.add(332);
		setHash.add(1);
		setHash.add(123);
		setHash.add(1);
		
		printSet("HashSet",setHash);
		
		Set<Integer> setLinkedHash = new LinkedHashSet<Integer>();
		setLinkedHash.add(44);
		setLinkedHash.add(332);
		setLinkedHash.add(1);
		setLinkedHash.add(123);
		setLinkedHash.add(1);
		
		printSet("LinkedHashSet", setLinkedHash);
	
	}
}
