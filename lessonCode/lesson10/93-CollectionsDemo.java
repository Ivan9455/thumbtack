// Collections
package net.thumbtack.lessons;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class Person implements Comparable<Person>{
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
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	@Override
	public int compareTo(Person p) {
		return firstName.compareTo(p.firstName);
	}
}

public class CollectionsDemo {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		Collections.addAll(list1, 1, 2, 3, 4, 5);

		List<Integer> list2 = new ArrayList<Integer>();
		Collections.addAll(list2, 6, 7, 8, 9, 10);
		
		Collections.reverse(list2);
		
		Collections.rotate(list2, 1);
		
		Collections.shuffle(list2);
		
		Collections.sort(list2);
		
		Collections.swap(list2, 1, 3);
		
		int max = Collections.max(list2);
		int min = Collections.min(list2);
		
		int frequency = Collections.frequency(list2, 7);
		
		boolean dj = Collections.disjoint(list1,  list2);

		Collections.copy(list2, list1);

		int index3 = Collections.binarySearch(list1, 3);
		
		List<Person> listPerson = new ArrayList<Person>();
		
		Person person1 = new Person("Vasya", "Pupkin"); //2
		Person person2 = new Person("Vova", "Petrov");  //3
		Person person3 = new Person("Misha", "Sidorov");//1
		Person person4 = new Person("Yura", "Ivanov");  //4
		
		listPerson.add(person1);
		listPerson.add(person2);
		listPerson.add(person3);
		listPerson.add(person4);
		
		Collections.shuffle(listPerson);
		Collections.sort(listPerson);
		printList(listPerson);
		
		
		Collections.shuffle(listPerson);
		Collections.sort(listPerson, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}
		});
		printList(listPerson);
		
		Collections.shuffle(listPerson);
		Collections.sort(listPerson, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		printListUsingLambda(listPerson);
		
	}


	private static void printList(List<Person> listPerson) {
		System.out.println("Printing List");
		for(Person p : listPerson) {
			System.out.println(p);
		}
	}

	private static void printListUsingLambda(List<Person> listPerson) {
		System.out.println("Printing List Using forEach");
		listPerson.forEach(p->System.out.println(p));
		
	}

}