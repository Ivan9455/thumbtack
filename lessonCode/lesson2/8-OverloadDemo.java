// overload методов
package net.thumbtack.lessons;

public class OverloadDemo {
	
	public void test() {
		System.out.println("No params");
	}

	public void test(int a) {
		System.out.println("a= " + a);
	}

	public void test(int a, int b) {
		System.out.println("a= " + a + " b=" + b);
	}

	public static void main(String[] args) {
		OverloadDemo t = new OverloadDemo();
		t.test();
		t.test(1);
		t.test(1,2);
	}

}
