// StackOverflowError
package net.thumbtack.lessons;

public class ErrorDemo {

	public static void recurse() {
		recurse();
	}

	public static void main(String[] args) {
		recurse();
	}
}
