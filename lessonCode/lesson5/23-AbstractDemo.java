// абстрактные классы
package net.thumbtack.lessons;

abstract class Fruit {
	private int weight;
	private int volume;

	public Fruit(int weight, int volume) {
		super();
		this.weight = weight;
		this.volume = volume;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	abstract public int getTaste();
	
}

class Apple extends Fruit {

	public Apple(int weight, int volume) {
		super(weight, volume);
	}

	@Override
	public int getTaste() {
		return 1;
	}

}

class Orange extends Fruit {

	public Orange(int weight, int volume) {
		super(weight, volume);
	}

	@Override
	public int getTaste() {
		return 2;
	}

}

public class AbstractDemo {

	public static void main(String[] args) {
		// Fruit fruit = new Fruit(10, 20);
		Orange orange = new Orange(200, 200);
		Apple apple = new Apple(200, 300);
		Fruit fruitApple = apple;
		System.out.println(fruitApple.getVolume());
		Fruit fruitOrange = orange;
		System.out.println(fruitOrange.getVolume());
		System.out.println(fruitApple.getTaste());
		System.out.println(fruitOrange.getTaste());

	}

}
