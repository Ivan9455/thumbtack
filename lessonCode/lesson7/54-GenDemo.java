//  дженерики. пример компилируется после замены isSameAverage на закомментированный вариант
package net.thumbtack.lessons;

class Stats<T extends Number> {
	private static final double EPS = 1E-6;
	private T[] nums;

	public Stats(T[] nums) {
		super();
		this.nums = nums;
	}

	public double average() {
		double sum = 0;
		for (T elem : nums)
			sum += elem.doubleValue();
		return sum / nums.length;
	}

	public boolean isSameAverage(Stats<T> another) {
		return Math.abs(average() - another.average()) < EPS;
	}

/*	public boolean isSameAverage(Stats<? extends Number> another) {
		return Math.abs(average() - another.average()) < EPS;
	}
*/
}

public class GenDemo {

	public static void main(String[] args) {

		Integer[] ints = { 1, 2, 3, 4, 5 };
		Stats<Integer> statsInteger = new Stats<Integer>(ints);
		System.out.println(statsInteger.average());

		Double[] dbls = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		Stats<Double> statsDouble = new Stats<Double>(dbls);
		System.out.println(statsDouble.average());

		boolean isSameAverage = statsDouble.isSameAverage(statsInteger);

		System.out.println(isSameAverage);

	}

}
