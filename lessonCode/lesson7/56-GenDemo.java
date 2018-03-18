//  дженерики
package net.thumbtack.lessons;

interface MinMax<T extends Comparable<T>> {
	T min();
	T max();
}

class Stats<T extends Comparable<T>> implements MinMax<T> {
	private T[] nums;
	public Stats(T[] nums) {
		super();
		this.nums = nums;
	}
	
	@Override
	public T min() {
		T v = nums[0];
		for(int i = 1; i < nums.length; i++)
			if(v.compareTo(nums[i]) > 0)
					v = nums[i];
		return v;
	}

	@Override
	public T max() {
		T v = nums[0];
		for(int i = 1; i < nums.length; i++)
			if(v.compareTo(nums[i]) < 0)
					v = nums[i];
		return v;
	}

}

public class GenDemo {

	public static void main(String[] args) {
		
		Integer[] ints = {1,2,3,4,5};
		Stats<Integer> statsInteger = new Stats<Integer>(ints);
		System.out.println("Min = " + statsInteger.min());
		System.out.println("Max = " + statsInteger.max());

		String[] strs = {"1","2","3","4","5"};
		Stats<String> statsString = new Stats<String>(strs);
		System.out.println("Min = " + statsString.min());
		System.out.println("Max = " + statsString.max());
	}

}
