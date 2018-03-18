// изменение примитивных аргументов метода невозможно
package net.thumbtack.lessons;


public class CallDemo {

    public void f(int x, int y) {
        x *= 2;
        y /= 2;
    }


    public static void main(String[] args) {
        int a = 5, b = 20;
        CallDemo demo = new CallDemo();
        demo.f(a, b);
        System.out.println("a = " + a + " b = " + b);
    }

}
