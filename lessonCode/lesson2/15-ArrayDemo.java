// array
package net.thumbtack.lessons;


public class ArrayDemo {
	
	public static void main(String[] args) {
		int[] a = new int[10];
		int lenA = a.length;
		System.out.println(lenA);
		int[] b = {1, 2, 10, 15};
		int lenB = b.length;
		System.out.println(lenB);

		for(int i = 0; i < lenB; i++)
			System.out.println(b[i]);
		
		for(int elem : b)
			System.out.println(elem);
	}

}
