//  enum
package net.thumbtack.lessons;

enum ErrorCode {
	WRONG_FIRSTNAME("Wrong first name"),
	WRONG_LASTNAME("Wrong last name"),
	WRONG_LOGIN("Wrong login"),
	WRONG_PASSWORD("Wrong password");
	
	private String message;

	private ErrorCode(String message) {
		this.message = message;
	}

	public String getErrorString() {
		return message;
	}
}

public class EnumDemo {

	public static void main(String[] args) {
		ErrorCode code = ErrorCode.WRONG_FIRSTNAME;
		System.out.println(code);
		System.out.println(code.ordinal());
		System.out.println(code.getErrorString());
	}

}
