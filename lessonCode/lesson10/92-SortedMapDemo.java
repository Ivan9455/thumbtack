// SortedMap
package net.thumbtack.lessons;

import java.util.SortedMap;
import java.util.TreeMap;

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
}

public class SortedMapDemo {
	
	private static void printMap(SortedMap<Person,Integer> map) {
		System.out.println("Printing map");
		for(Person p : map.keySet())
			System.out.println(p + " " + map.get(p));
		
	}
	
	public static void main(String[] args) {
		
		SortedMap<Person, Integer> mapPersonByBothNames = new TreeMap<Person, Integer>((p1,p2) -> {
			int firstNameCompareResult = p1.getFirstName().compareTo(p2.getFirstName());	
			return firstNameCompareResult != 0 ? firstNameCompareResult : p1.getLastName().compareTo(p2.getLastName());
		});

		Person personVasya = new Person("Vasya", "Pupkin"); //2
		Person personVova = new Person("Vova", "Petrov");  //3
		Person personMisha = new Person("Misha", "Sidorov");//1
		Person personYura = new Person("Yura", "Ivanov");  //4
		
		mapPersonByBothNames.put(personVasya, 1);
		mapPersonByBothNames.put(personVova, 4);
		mapPersonByBothNames.put(personMisha, 3);
		mapPersonByBothNames.put(personYura, 5);
		
		// получить оценку Vasya Pupkin
		System.out.println("Vasya Pupkin " + mapPersonByBothNames.get(personVasya));

		// получить оценку Vasya Mishkin
		System.out.println("Vasya Mishkin " + mapPersonByBothNames.get(new Person("Vasya", "Mishkin")));
		
		
		printMap(mapPersonByBothNames);
		
	}
}
