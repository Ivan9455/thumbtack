//  интерфейс как результат метода
package net.thumbtack.lessons;

interface Colored {
	void setColor(int color);
	int getColor();
}

interface Named {
	void setName(String name);
	String getName();
}

interface NamedColored extends Colored, Named {
}

class Cat implements NamedColored {

	private int color;
	private String name;

	public Cat(String name, int color) {
		super();
		this.color = color;
		this.name = name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}
	
	public static Colored createCat(String name, int color) {
		return new Cat(name, color);
	}
}

public class InterfaceDemo {

	public static void main(String[] args) {
		
		Colored colored = Cat.createCat("Мурка", 3);
		colored.setColor(4);
		System.out.println(colored.getColor());
	}

}
