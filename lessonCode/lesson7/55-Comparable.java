// Comparable
package net.thumbtack.lessons;

abstract class Fruit implements Comparable<Fruit> {
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

	@Override
	public int compareTo(Fruit another) {
		return weight - another.weight;
	}

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

public class ComparableDemo {

	public static void main(String[] args) {
		Orange orange = new Orange(300, 200);
		Apple apple = new Apple(200, 300);
		int compareResult = orange.compareTo(apple);
		if (compareResult > 0)
			System.out.println("Orange is greater");
		else if (compareResult < 0)
			System.out.println("Apple is greater");
		else
			System.out.println("Weights are equal");

	}

}
