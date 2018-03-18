// изменение экземпляра класса
package net.thumbtack.lessons;

class Test {
    public int a, b;

    public Test(int a, int b) {
        this.a = a;
        this.b = b;
    }

}

public class CallDemo {

    public void f(Test test) {
        test.a *= 2;
        test.b /= 2;
    }

    public static void main(String[] args) {
        Test test = new Test(5, 20);
        CallDemo demo = new CallDemo();
        demo.f(test);
        System.out.println("test.a = " + test.a + " test.b =" + test.b);
    }

}
