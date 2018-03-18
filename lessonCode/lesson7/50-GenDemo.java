//  ���������
package net.thumbtack.lessons;

class NonGen {

    private Object obj;

    public NonGen(Object obj) {
        super();
        this.obj = obj;
    }


    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    void showType() {
        System.out.println(obj.getClass().getName());
    }
}

class Gen<T> {

    private T obj;

    public Gen(T obj) {
        super();
        this.obj = obj;
    }


    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    void showType() {
        System.out.println(obj.getClass().getName());
    }

    void notAllowed() {
    	//	T t = new T;
    	//	T[] arr = new T[10];
    	//	Gen<Integer>[] gens = new Gen<Integer>[10];
    	//	static T obj;
    	// 	� ��� �����
        Gen<?>[] gens1 = new Gen<?>[10];
        Gen[] gens2 = new Gen[10];
    }
}


public class GenDemo {

    public static void main(String[] args) {

	// NonGen

        NonGen nongenObject = new NonGen(new Object());
        nongenObject.showType();

        NonGen nongenInteger = new NonGen(100); //  NonGen nongenInteger = new NonGen(new Integer(100));

        nongenInteger.showType();
        Integer intValueFromNonGenInteger = (Integer) nongenInteger.getObj();
        System.out.println(intValueFromNonGenInteger);

        NonGen nongenDouble = new NonGen(100.6);
        nongenDouble.showType();
        Double doubleValueFromNonGetDouble = (Double) nongenDouble.getObj();
        System.out.println(doubleValueFromNonGetDouble);

        NonGen nongenString = new NonGen("test");
        nongenString.showType();
        String stringValuFromNonGenString = (String) nongenString.getObj();
        System.out.println(stringValuFromNonGenString);

        // ������������������ ��� ������� ����������
        // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
	// NonGen nongenWrongInteger = new NonGen("test");
	// Integer intValueFromNonGenString = (Integer)nongenString.getObj();

	// Gen

	// ��� ������ ������ , ���������� �� ����� ���� ����������� ���
 	// Gen<int> genInteger = new Gen<int>(100);

        Gen<Integer> genInteger = new Gen<Integer>(100);
        genInteger.showType();
        Integer intValueFromGenInteger = genInteger.getObj();
        System.out.println(intValueFromGenInteger);

        Gen<Double> genDouble = new Gen<Double>(100.6);
        genDouble.showType();
        Double doubleValueFromGenDouble = genDouble.getObj();
        System.out.println(doubleValueFromGenDouble);

        Gen<String> genString = new Gen<String>("test");
        genString.showType();
        String stringValueFromGenString = genString.getObj();

        
        // ������������������ ��� �� �������������
        // Gen<Integer> genWrongInteger = new Gen<String>("test");

        // ��� ������ �����, �� �� �����
        Gen genStringRaw = new Gen("test");
        Gen genIntegerRaw = genStringRaw;
        // ������ ��� ������������������ ��� ������� ����������
        // java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        // Integer intValueFromRawGen = (int) genIntegerRaw.getObj(); 


    }

}
