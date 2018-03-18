// exception
package net.thumbtack.lessons;

public class ExceptionDemo {

    static void f(int denom) {
        int num = 100, result;
        result = num / denom;
        System.out.println(result);
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
