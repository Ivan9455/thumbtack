//  дженерики
package net.thumbtack.lessons;

class Gen2<T, V> {
	private T objT;
	private V objV;

	public Gen2(T objT, V objV) {
		super();
		this.objT = objT;
		this.objV = objV;
	}

	public T getObjT() {
		return objT;
	}

	public void setObjT(T objT) {
		this.objT = objT;
	}
	
	public V getObjV() {
		return objV;
	}

	public void setObjV(V objV) {
		this.objV = objV;
	}
	void showType() {
		System.out.println(objT.getClass().getName());
		System.out.println(objV.getClass().getName());
	}
}

public class GenDemo {

	public static void main(String[] args) {
		
		Gen2<Integer, Integer>  genIntegerInteger = new Gen2<Integer, Integer>(100, 200);
		genIntegerInteger.showType();

		Gen2<Double, String>  genDoubleString = new Gen2<Double,String>(100.6, "test");
		genDoubleString.showType();
		
	}

}
