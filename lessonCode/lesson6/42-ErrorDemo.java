// OutOfMemoryError
package net.thumbtack.lessons;

public class ErrorDemo {

	public static void main(String[] args) {
		final int SIZE = 1 << 30;
		double[] arr = new double[SIZE];
	}
}
