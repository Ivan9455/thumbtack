// exception
package net.thumbtack.lessons;

public class ExceptionDemo {

    static void f(int denom) {
        int[] a = { 1, 2, 3 };
        int num = 100;
        int x = num / denom;
        System.out.println(x);
        System.out.println(a[3]);
    }

    public static void main(String[] args) {
        try {
            f(20);
            f(0);
        }
		catch(ArithmeticException | ArrayIndexOutOfBoundsException ex) {
		ex.printStackTrace();
	}
    }

}