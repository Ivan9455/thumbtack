// static
package net.thumbtack.lessons;

public class StaticDemo {
	
	private static int x = 10;
	
	static {
		x = 100;
	}
	
	static int getX() {
		return x;
	}
	
	public static void main(String[] args) {
		
		StaticDemo.x = 20;
		x = 120;
		System.out.println(StaticDemo.getX());
	}

}
