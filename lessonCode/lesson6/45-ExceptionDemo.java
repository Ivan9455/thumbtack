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

	private static final String MESSAGE = "Bad User name";

	public static void checkUserName(String userName) throws MyException {
		if (userName == null || userName.length() == 0)
			throw new MyException(MESSAGE);
	}

	public static void main(String[] args) {
		try {
			checkUserName(null);
		} catch (MyException ex) {
			ex.printStackTrace();
		}

	}

}
