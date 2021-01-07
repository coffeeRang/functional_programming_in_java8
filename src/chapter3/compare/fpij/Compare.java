package chapter3.compare.fpij;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Compare {
	
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35)
				);
		
//		List<Person> ascendingAge = 
//				people.stream()
//					.sorted((person1, person2) -> person1.ageDifference(person2))
//					.collect(Collectors.toList());

		// �� sorted() �� ���� ȣ�� �κ��� ����ų �� �ְ� ����
//		List<Person> ascendingAge = 
//				people.stream()
//				.sorted(Person::ageDifference)
//				.collect(Collectors.toList());
//		
//		printPeople("Sorted in ascending order by age: ", ascendingAge);
		
		// ������������ ����
//		printPeople("Sorted in descending order by age: ", 
//				people.stream()
//					.sorted((person1, person2) -> person2.ageDifference(person1))
//					.collect(Collectors.toList())
//				);
		
		
//		Comparator<Person> compareAscending = 
//				(person1, person2) -> person1.ageDifference(person2);
//		Comparator<Person> compareDescending = compareAscending.reversed();
//		
//		printPeople("Sorted in ascending order by age: ", 
//				people.stream()
//					.sorted(compareAscending)
//					.collect(Collectors.toList())
//				);
//		
//		printPeople("Sorted in descending order by age: ",
//				people.stream()
//					.sorted(compareDescending)
//					.collect(Collectors.toList())
//				);
//		
//		// �̸��� ���ĺ��� ������������ ����
//		printPeople("Sorted in ascending order by name: ",
//				people.stream()
//					.sorted((person1, person2) -> person1.getname().compareTo(person2.getname()))
//					.collect(Collectors.toList())
//				);
//		
//		// ����Ʈ���� ���� ���� ����� ����
//		// ifPresnet() �޼��带 ����ؼ� Optional�κ��� �׼��� �� �� �ִ� ���� � ����� ���� ������ ���
//		people.stream()
//			.min(Person::ageDifference)
//			.ifPresent(youngest -> System.out.println("Youngest: " + youngest));
//		
//		// ����Ʈ���� ���� ���̰� ���� ����� ����
//		// max() �޼��带 ���
//		people.stream()
//			.max(Person::ageDifference)
//			.ifPresent(eldest -> System.out.println("Eldest: " + eldest));
		
		people.stream()
			.sorted((person1, person2) -> 
				person1.getName().compareTo(person2.getName()));
		
		// comparing() �޼���� Comparator�� �����ϱ� ���� ������ ���� ǥ������ ������ ��� == �����Լ�
		// ���� �Լ���? 
		// �ϳ� �̻��� �Լ��� �μ��� ���Ѵ� or �Լ��� ����� ��ȯ�Ѵ�.
		final Function<Person, String> byName = person -> person.getName();
		people.stream()
			.sorted(Comparator.comparing(byName));
		
		
		final Function<Person, Integer> byAge = person -> person.getAge();
		
		final Function<Person, String> byTheirName = person -> person.getName();
		
		printPeople("Sorted in ascending order by age and name: ", 
				people.stream()
					.sorted(Comparator.comparing(byAge).thenComparing(byTheirName))
					.collect(Collectors.toList())
				);
		
		
		
	}
	
//	final Function<Person, String> byName = person -> person.getName();
	
	
	
	
	
	

	public static void printPeople(final String message, final List<Person> people) {
		System.out.println(message);
		people.forEach(System.out::println);
	}

}
