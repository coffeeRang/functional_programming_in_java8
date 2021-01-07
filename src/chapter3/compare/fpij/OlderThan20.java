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
		 * ��� ������ �����Ѵ�.
		 * 1. Ÿ�� �÷��ǿ� ������Ʈ�� �߰��ϴ� ���۷��̼��� �ʹ� �ο� ����
		 * 		�� ���۷��̼��� ������(declarative)���� �ʰ�, �����(imperative)��� �ǹ̴�.
		 * 		���ͷ��̼��� ���ÿ� �����Ϸ���, ������ ������Ƽ ���� ��� �ʿ�
		 * 		(�������� ����ȭ�� ��ư� �����)
		 * 	-> collect() �޼��带 ����ϸ� �� ������ ���� �ذ��� �� �ִ�.
		 * 
		 * 2. ���� ���۷��̼ǿ����� �ʿ����� ���� ���� �ִ�. 
		 * 		�ڵ�� ��������� ���� ���� ��ο��� �����ϵ��� ����ƴ�.
		 */
		people.stream()
			.filter(person -> person.getAge() > 20)
			.forEach(person -> olderThan20v1.add(person));
		System.out.println("People older than 20: " + olderThan20v1);
		
		/**
		 * collect() �޼���� ������Ʈ�鿡 ���� ��Ʈ���� ������. - ��� �����̳ʷ� �ش� ��Ʈ���� ������.
		 * - ��� �����̳ʸ� ����� ���(ex: ArrayList::new �޼��带 ���)
		 * - �ϳ��� ������Ʈ�� ��� �����̳ʿ� �߰��ϴ� ���(ex: ArrayList::add �޼��带 ���)
		 * - �ϳ��� ��� �����̳ʸ� �ٸ� �Ͱ� ��ġ�� ���(ex: ArrayList::addAll �޼��带 ���)
		 */
		List<Person> olderThan20v2 = people.stream()
				.filter(person -> person.getAge() > 20)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println("People older than 20v2: " + olderThan20v2);
		
		/**
		 * olderThan20v2 ����� ���� ������ ������, �� ������ �� ���� ������ ���� �ִ�. 
		 * 1. �������� �ǵ���� �� ���������� ���α׷����� ����
		 * 		����� ��Ƽ�(collect), ArrayList�� �ִ´ٴ� ������ ��Ȯ�� ���
		 * 		collect() �޼���� ù ��° �Ķ���ͷ� ���丮(factory)�� ���ö��̾�(supplier)�� ���´�.
		 * 		�� ���� �Ķ���͵��� ������Ʈ�� �÷������� ������ ���۷��̼ǵ��̴�.
		 * 
		 * 2.  ���ͷ��̼� ������ ����ȭ�ϱ� ���� - �ڵ忡�� ����� ������ �Ͼ�� �ʴ´�.
		 * 		���濡 ���� �κ��� ���̺귯������ ����
		 * 			- ���̺귯���� ����� ������ �����ϰ� ������ ������Ƽ�� ����
		 * 			- ArrayList ��ü�� ����Ʈ ������Ƽ�� �ƴϴ��� �����ϴ�.
		 * 
		 * 3. collect() �޼���� �ٸ� ���� ����Ʈ ���� ���� ������ ������ �� ���(���� ����)�� ������ �������ϰ� �� �� ū �Ը��� ����Ʈ�� ��ĥ �� �ִ�. 
		 * 		������ �Ķ���ʹ� ����Ʈ�� ��ġ�µ� ������ �ش�.
		 */

		/**
		 * ���ݱ��� ArrayList�� ������Ʈ�� �߰��ϸ鼭 collect() �޼����� ������ ���� �˾ƺô�.
		 * �� �޼��带 ���� �����ϰ� ���ϰ� ����� ���� �ٸ� ������ ���� �˾ƺ��� ���� Collector�� �Ķ���ͷ� ����Ѵ�.
		 * 
		 * Collector�� supplier, accumulator, combiner�� ���۷��̼ǿ� ���� �������̽� ������ �Ѵ�.
		 * Collectors ��ƿ��Ƽ Ŭ������ toList() ����Ͼ�(convenience: ����,��) �޼��带 �����Ѵ�.
		 * 		�� �޼���� Collect �������̽��� ������ �����ؼ� ������Ʈ���� ArrayList�� ������ ������ �Ѵ�.
		 */
		List<Person> olderThan20v3 = people.stream()
			.filter(person -> person.getAge() > 20)
			.collect(Collectors.toList());
		System.out.println("People older than 20v3: " + olderThan20v3);
		
		/**
		 * Collectors���� �پ��� collect�� ��ť�·�����(accumulator) ���۷��̼��� �����Ѵ� �� ���� �ٸ� �޼��尡 ����
		 * 
		 */
		
		
		
		
	}
	
	
	
	

}
