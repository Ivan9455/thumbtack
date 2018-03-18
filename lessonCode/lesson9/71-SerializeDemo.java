package net.thumbtack.lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Person implements Serializable {
	private static final long serialVersionUID = 803745049486954915L;

	private String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Person1 extends Person {

	private static final long serialVersionUID = -1563124421284428873L;

	public Person1(String name, int age) {
		super(name, age);
	}
	
}


public class SerializeDemo {

	public static void main(String[] args) {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("1.dat")))) {
			Person1 p = (Person1)ois.readObject();
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(ClassCastException e) {
			e.printStackTrace();
		}
		
		
	}
}
