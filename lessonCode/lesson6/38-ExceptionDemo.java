// exception
package net.thumbtack.lessons;

public class ExceptionDemo {

    static void f(int denom) {
        int[] a = {1, 2, 3};
        int num = 100, result;
        result = num / denom;
        System.out.println("result = " + result);
        System.out.println(a[3]);
    }

    public static void main(String[] args) {
        try {
            f(20);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        try {
            f(0);
        } catch (ArithmeticException ex) {
            ex.printStackTrace();
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

}