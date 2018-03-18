// рекурсия
package net.thumbtack.lessons;


public class FactDemo {
	
	public int fact(int n) {
		return  n < 1 ? 1 : n * fact(n - 1);
		
	}

	public static void main(String[] args) {
		System.out.println(new FactDemo().fact(10));
	}

}
