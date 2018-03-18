package net.thumbtack.lessons;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

class Person implements Serializable {
	private static final long serialVersionUID = 803745049486954915L;

	private String firstName;
	private int age;


	@Override
	public String toString() {
		return "Person [name=" + firstName + ", age=" + age + "]";
	}

	public Person(String name, int age) {
		super();
		this.firstName = name;
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}



public class SerializeDemo {

	public static void main(String[] args) {
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("1.dat")))) {
			Person p = (Person)ois.readObject();
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
