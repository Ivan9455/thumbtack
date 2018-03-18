// интерфейсы
package net.thumbtack.lessons;

interface Colored {
	void setColor(int color);
	int getColor();
}

class Car implements Colored {

	private String model;
	private int color;

	public Car(String model, int color) {
		super();
		this.model = model;
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}

}

class Cat implements Colored {

	private int color;
	private String name;

	public Cat(String name, int color) {
		super();
		this.color = color;
		this.name = name;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public void setColor(int color) {
		this.color = color;
	}

	@Override
	public int getColor() {
		return color;
	}
}


public class InterfaceDemo {

	public static void main(String[] args) {
		
		Car car = new Car("Volvo", 1);
		Cat cat = new Cat("Мурка", 2);
		
		Colored coloredCar = car;
		coloredCar.setColor(3);
		
		Colored coloredCat = cat;
		coloredCat.setColor(4);
		
		System.out.println(car.getColor());
		System.out.println(coloredCar.getColor());

		System.out.println(cat.getColor());
		System.out.println(coloredCat.getColor());
		
		Colored coloredAnonymous = new Colored() {
			int color;
			
			@Override
			public void setColor(int color) {
				this.color = color;
			}

			@Override
			public int getColor() {
				return color;
			}
		};
		
		coloredAnonymous.setColor(5);
		System.out.println(coloredAnonymous.getColor());
	}

}
