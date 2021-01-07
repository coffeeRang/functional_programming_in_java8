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

		// 위 sorted() 에 대한 호출 부분을 향상시킬 수 있게 수정
//		List<Person> ascendingAge = 
//				people.stream()
//				.sorted(Person::ageDifference)
//				.collect(Collectors.toList());
//		
//		printPeople("Sorted in ascending order by age: ", ascendingAge);
		
		// 내림차순으로 정렬
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
//		// 이름을 알파벳의 오름차순으로 정렬
//		printPeople("Sorted in ascending order by name: ",
//				people.stream()
//					.sorted((person1, person2) -> person1.getname().compareTo(person2.getname()))
//					.collect(Collectors.toList())
//				);
//		
//		// 리스트에서 가장 젊은 사람을 선택
//		// ifPresnet() 메서드를 사용해서 Optional로부터 액세스 할 수 있는 가장 어린 사람에 대한 정보를 출력
//		people.stream()
//			.min(Person::ageDifference)
//			.ifPresent(youngest -> System.out.println("Youngest: " + youngest));
//		
//		// 리스트에서 가장 나이가 많은 사람을 선택
//		// max() 메서드를 사용
//		people.stream()
//			.max(Person::ageDifference)
//			.ifPresent(eldest -> System.out.println("Eldest: " + eldest));
		
		people.stream()
			.sorted((person1, person2) -> 
				person1.getName().compareTo(person2.getName()));
		
		// comparing() 메서드는 Comparator를 생성하기 위해 제공된 람다 표현식의 로직을 사용 == 고차함수
		// 고차 함수란? 
		// 하나 이상의 함수를 인수로 취한다 or 함수를 결과로 반환한다.
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