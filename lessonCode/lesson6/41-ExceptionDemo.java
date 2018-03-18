// nested exception
package net.thumbtack.lessons;

public class ExceptionDemo {

    static void f(int denom) {
        int[] a = { 1, 2, 3 };
        int num = 100, result;
        result = num / denom;
        System.out.println(result);
        try {
            System.out.println(a[3]);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            f(20);
            f(0);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();

        }
    }
}
