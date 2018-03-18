// set
package net.thumbtack.lessons;

import java.util.HashSet;
import java.util.Set;


public class SetDemo {
	
	public static void main(String[] args) {
		
		Set<Integer> setInt = new HashSet<Integer>();
		setInt.add(44);
		setInt.add(332);
		setInt.add(1);
		setInt.add(123);
		setInt.add(1);
		
		for(Integer i : setInt)
			System.out.println(i);
		
		System.out.println(setInt.contains(1));
		System.out.println(setInt.contains(3));

		Set<String> setString = new HashSet<String>();
		setString.add("1");
		setString.add("2");
		setString.add("1");
		setString.add("1");
		
		for(String s : setString)
			System.out.println(s);
	
	
	}
}
