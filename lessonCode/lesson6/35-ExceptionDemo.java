// exception
package net.thumbtack.lessons;

public class ExceptionDemo {

	public static void main(String[] args) {
		int num = 100, denom = 0, result;
		try {
			result = num / denom;
		}
		catch (ArithmeticException ex) {
			ex.printStackTrace();
			return;
		}
		System.out.println("result = " + result);
	}

}
