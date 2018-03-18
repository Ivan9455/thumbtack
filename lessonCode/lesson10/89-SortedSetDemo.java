// set
package net.thumbtack.lessons;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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

public class SortedSetDemo {
	
	private static void printSet(String name, Set<Person> set) {
		System.out.println("Printing " + name);
		for(Person p : set)
			System.out.println(p);
		
	}
	
	public static void main(String[] args) {
		
/*		SortedSet<Person> setPerson = new TreeSet<Person>(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getFirstName().compareTo(p2.getFirstName());
			}
		});
*/		
		SortedSet<Person> setPersonByFirstName = new TreeSet<Person>((p1,p2) -> p1.getFirstName().compareTo(p2.getFirstName()));

		Person personVasya = new Person("Vasya", "Pupkin"); //2
		Person personVova = new Person("Vova", "Petrov");  //3
		Person personMisha = new Person("Misha", "Sidorov");//1
		Person personYura = new Person("Yura", "Ivanov");  //4
		
		setPersonByFirstName.add(personVasya);
		setPersonByFirstName.add(personVova);
		setPersonByFirstName.add(personMisha);
		setPersonByFirstName.add(personYura);
		
		// Следующее верно  - Vasya Pupkin в множестве есть
		System.out.println("Vasya Pupkin " + setPersonByFirstName.contains(personVasya));

		// Почему следующее верно ? В множестве же нет Vasya Mishkin
		System.out.println("Vasya Mishkin " + setPersonByFirstName.contains(new Person("Vasya", "Mishkin")));
		
		// Попробуем иначе

		SortedSet<Person> setPersonByBothNames = new TreeSet<Person>((p1,p2) -> {
					int firstNameCompareResult = p1.getFirstName().compareTo(p2.getFirstName());	
					return firstNameCompareResult != 0 ? firstNameCompareResult : p1.getLastName().compareTo(p2.getLastName());
				});

		setPersonByBothNames.add(personVasya);
		setPersonByBothNames.add(personVova);
		setPersonByBothNames.add(personMisha);
		setPersonByBothNames.add(personYura);
		
		// Следующее верно  - Vasya Pupkin в множестве есть
		System.out.println("Vasya Pupkin " + setPersonByBothNames.contains(personVasya));

		// Следующее неверно - в множестве нет Vasya Mishkin
		System.out.println("Vasya Mishkin " + setPersonByBothNames.contains(new Person("Vasya", "Mishkin")));
		
		
		printSet("Full set" ,setPersonByFirstName);
		
		SortedSet<Person> headSet = setPersonByFirstName.headSet(personVova);
		printSet("Head set" , headSet);

		SortedSet<Person> tailSet = setPersonByFirstName.tailSet(personVova);
		printSet("Tail set" ,tailSet);
		
		SortedSet<Person> subSet = setPersonByFirstName.subSet(personMisha, personVova);
		printSet("Subset", subSet);
	}
}
