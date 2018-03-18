// exception
package net.thumbtack.lessons;

class MyException extends Exception {

	public MyException() {
		super();
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyException(String message) {
		super(message);
	}

	public MyException(Throwable cause) {
		super(cause);
	}
}

public class ExceptionDemo {

	public static String getFirstTwoLetters(String userName) throws MyException {
		try {
			return userName.substring(0, 2);
		}
		catch(StringIndexOutOfBoundsException ex) {
			throw new MyException(ex);
		}
	}

	public static void main(String[] args) {
		try {
			String twoLetters = getFirstTwoLetters("I");
			System.out.println(twoLetters);
		} catch (MyException e) {
			e.printStackTrace();
		}

	}

}
