// Arrays
package net.thumbtack.lessons;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

	public static void main(String[] args) {

		int[] intArray1 = { 1, 3, 2, 5, 4 };
		int[] intArray2 = { 1, 3, 2, 5, 4 };

		boolean equal = Arrays.equals(intArray1, intArray2);
		System.out.println(equal);

		Arrays.sort(intArray1);
		printArray(intArray1);

		equal = Arrays.equals(intArray1, intArray2);
		System.out.println(equal);

		Arrays.fill(intArray2, 5);

		int pos = Arrays.binarySearch(intArray1, 2);
		System.out.println(pos);

		int[] subIntArray = Arrays.copyOfRange(intArray1, 1, 4);
		printArray(subIntArray);

		Integer[] integerArray = { 1, 2, 3, 4, 5 };
		List<Integer> list = Arrays.asList(integerArray);

	}

	private static void printArray(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}