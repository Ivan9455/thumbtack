// метод, возвращающий экземпл€р
package net.thumbtack.lessons;

class Test {
    private int a;

    public Test(int a) {
        this.a = a;
    }

    public Test incr(int delta) {
        Test tmp = new Test(a + delta);
        return tmp;
    }

    public int getA() {
        return a;
    }
}

public class CallDemo {

    public static void main(String[] args) {
        Test test = new Test(5);
        Test test1 = test.incr(100);
        System.out.println("test.a= " + test1.getA());
    }

}
