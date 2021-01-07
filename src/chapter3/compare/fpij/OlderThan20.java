package chapter3.compare.fpij;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OlderThan20 {
	public static void main(String[] args) {
		final List<Person> people = Arrays.asList(
				new Person("John", 20),
				new Person("Sara", 21),
				new Person("Jane", 21),
				new Person("Greg", 35)
				);
		List<Person> olderThan20v1 = new ArrayList();
		
		/** 
		 * 몇가지 문제가 존재한다.
		 * 1. 타깃 컬렉션에 엘리먼트를 추가하는 오퍼레이션이 너무 로우 레벨
		 * 		이 오퍼레이션이 서술적(declarative)이지 않고, 명령적(imperative)라는 의미다.
		 * 		이터레이션을 동시에 실행하려면, 스레드 세이프티 문제 고려 필요
		 * 		(가변성은 병렬화를 어렵게 만든다)
		 * 	-> collect() 메서드를 사용하면 이 문제를 쉽게 해결할 수 있다.
		 * 
		 * 2. 순차 오퍼레이션에서는 필요하지 않을 수도 있다. 
		 * 		코드는 순차실행과 병렬 실행 모두에서 동작하도록 설계됐다.
		 */
		people.stream()
			.filter(person -> person.getAge() > 20)
			.forEach(person -> olderThan20v1.add(person));
		System.out.println("People older than 20: " + olderThan20v1);
		
		/**
		 * collect() 메서드는 엘리먼트들에 대한 스트림을 가진다. - 결과 컨테이너로 해당 스트림을 모은다.
		 * - 결과 컨테이너를 만드는 방법(ex: ArrayList::new 메서드를 사용)
		 * - 하나의 엘리먼트를 결과 컨테이너에 추가하는 방법(ex: ArrayList::add 메서드를 사용)
		 * - 하나의 결과 컨테이너를 다른 것과 합치는 방법(ex: ArrayList::addAll 메서드를 사용)
		 */
		List<Person> olderThan20v2 = people.stream()
				.filter(person -> person.getAge() > 20)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("People older than 20v2: " + olderThan20v2);
		
		/**
		 * olderThan20v2 결과는 이전 버전과 같으나, 이 버전은 더 많은 장점을 갖고 있다. 
		 * 1. 개발자의 의도대로 더 서술적으로 프로그래밍이 가능
		 * 		결과를 모아서(collect), ArrayList에 넣는다는 목적을 명확히 명시
		 * 		collect() 메서드는 첫 번째 파라미터로 팩토리(factory)나 서플라이어(supplier)를 갖는다.
		 * 		그 다음 파라미터들은 엘리먼트를 컬렉션으로 모으는 오퍼레이션들이다.
		 * 
		 * 2.  이터레이션 실행을 병렬화하기 쉽다 - 코드에서 명시적 변경이 일어나지 않는다.
		 * 		변경에 대한 부분은 라이브러리에서 제어
		 * 			- 라이브러리를 사용한 조율이 간단하고 스레드 세이프티를 보장
		 * 			- ArrayList 자체는 스레트 세이프티가 아니더라도 가능하다.
		 * 
		 * 3. collect() 메서드는 다른 서브 리스트 간의 병렬 덧셈을 수행해 그 결과(병렬 덧셈)를 스레드 세이프하게 좀 더 큰 규모의 리스트로 합칠 수 있다. 
		 * 		마지막 파라미터는 리스트를 합치는데 도움을 준다.
		 */

		/**
		 * 지금까지 ArrayList에 엘리먼트를 추가하면서 collect() 메서드의 장점에 대해 알아봤다.
		 * 이 메서드를 좀더 간단하고 편리하게 만들기 위해 다른 버전에 대해 알아보기 위해 Collector를 파라미터로 사용한다.
		 * 
		 * Collector는 supplier, accumulator, combiner의 오퍼레이션에 대한 인터페이스 역할을 한다.
		 * Collectors 유틸리티 클래스는 toList() 컨비니언스(convenience: 편의,편리) 메서드를 제공한다.
		 * 		이 메서드는 Collect 인터페이스의 구현을 생성해서 엘리먼트들을 ArrayList에 모으는 역할을 한다.
		 */
		List<Person> olderThan20v3 = people.stream()
			.filter(person -> person.getAge() > 20)
			.collect(Collectors.toList());
		System.out.println("People older than 20v3: " + olderThan20v3);
		
		/**
		 * Collectors에는 다양한 collect나 어큐뮤레이터(accumulator) 오퍼레이션을 수행한느 몇 가지 다른 메서드가 존재
		 * 
		 */
		
		
		
		
	}
	
	
	
	

}