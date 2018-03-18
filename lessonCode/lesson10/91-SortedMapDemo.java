// map
package net.thumbtack.lessons;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class SortedMapDemo {
	
	private static void printMap(SortedMap<String,Integer> map) {
		System.out.println("Printing map");
		for(String key : map.keySet())
			System.out.println(key + " " + map.get(key));
		
	}
	
	private static <T> void printSet(Set<T>set) {
		System.out.println("Printing set");
		for(T key : set)
			System.out.println(key);
	}
	
	private static void printValues(Collection<Integer> values) {
		System.out.println("Printing values");
		for(Integer i : values)
			System.out.println(i);  
			
	}

	public static void main(String[] args) {
		
		SortedMap<String,Integer> map = new TreeMap<String,Integer>();
		map.put("Ivanov", 2);
		map.put("Petrov", 4);
		map.put("Sidorov", 5);
		map.put("Pupkin", 1);
		
		printMap(map);
		printSet(map.keySet());
		printSet(map.entrySet());
		printValues(map.values());
		
		System.out.println("Ivanov's value " +  map.get("Ivanov"));
		System.out.println("Smirnov's value " +  map.get("Smirnov"));
		
	
	}



}
