// set without equals and hashCode - wrong results. Fix!!!
package net.thumbtack.lessons;

import java.util.HashSet;
import java.util.Set;

class Person {
	private String firstName;
	private String lastName;
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
}

public class SetDemo {
	
	private static void printSet(Set<Person> set) {
		System.out.println("Printing set");
		for(Person p : set)
			System.out.println(p);
		
	}
	
	public static void main(String[] args) {
		
		Set<Person> setPerson1 = new HashSet<Person>();
		Person person = new Person("Vasya", "Pupkin");
		setPerson1.add(person);
		setPerson1.add(person);
		
		printSet(setPerson1);

		Set<Person> setPerson2 = new HashSet<Person>();
		Person person1 = new Person("Vasya", "Pupkin");
		Person person2 = new Person("Vasya", "Pupkin");
		setPerson2.add(person1);
		setPerson2.add(person2);

		printSet(setPerson2);
		
	}
}
