// exception
package net.thumbtack.lessons;

class CheckedException extends Exception {

    public CheckedException() {
        super();
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }
}

class UncheckedException extends RuntimeException {

    public UncheckedException() {
        super();
    }

    public UncheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UncheckedException(String message) {
        super(message);
    }

    public UncheckedException(Throwable cause) {
        super(cause);
    }
}


public class ExceptionDemo {

    public static void testChecked() throws CheckedException {
        throw new CheckedException();        
    }

    public static void testUnchecked() {
        throw new UncheckedException();
    }

    public static void main(String[] args) {
        try {
            testChecked();
        } catch (CheckedException e) {
            e.printStackTrace();
        }
        testUnchecked();
    }

}
