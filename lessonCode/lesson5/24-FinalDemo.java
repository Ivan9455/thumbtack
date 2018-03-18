// final. пример не компилируется, демонстрация того. что нельзя сделать с final
package net.thumbtack.lessons;


class Base  {
	public final int FILE_NEW = 1;
	public final int getFileNew() {
		return FILE_NEW;
	}
	public void setFileNew() {
		FILE_NEW = 0;
	}
}

final class Derived  extends Base {
	public final int getFileNew() {
		return 0;
	}
}

class Derived1 extends Derived {
}

public class FinalDemo {

	public static void main(String[] args) {
	}

}
