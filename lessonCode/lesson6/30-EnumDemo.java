//  enum
package net.thumbtack.lessons;

enum Color {
	RED, GREEN, BLUE
}

public class EnumDemo {

	public static void main(String[] args) {
		Color c = Color.RED;
		if(c == Color.GREEN)
			System.out.println("Red is Green");
		switch(c) {
		case RED :
			System.out.println("Red");
			break;
		case GREEN :
			System.out.println("Green");
			break;
		case BLUE :
			System.out.println("Blue");
			break;
		}
		
		Color[] values = Color.values();
		for(Color color : values) {
			System.out.println(color);
		}
		
		Color cG = Color.valueOf("GREEN");
		System.out.println(cG);

		Color cR = Color.valueOf("RED");
		System.out.println(cR);
		
		System.out.println(cR.ordinal());
		
		int res = cG.compareTo(cR);
		
		System.out.println(res);

        // закомментированный код вызовет исключение
		// java.lang.IllegalArgumentException: No enum constant net.thumbtack.lessons.Color.BROWN
		// Color cB = Color.valueOf("BROWN");
	
	}

}
