package chapter3.compare.fpij;

public class IterateString {

	/**
	 * 메서드 레퍼런스
	 *   - 클래스의 이름(String) 을 기반으로 하기 때문에 String::toUppercase 형태로 사용 가능하다.
	 *   - String::toUppercase == parameter.toUppercase();
	 *   - 인스턴스 메서드에 대한 메서드 레퍼런스는 서술형이며 Print 스트림의 인스턴스는 정적 레퍼런스인 System.out을 통해 액세스된다.
	 *   
	 * chars() 메서드를 리턴하는 스트림에 대해 내부 이터레이터를 사용했지만, 이 메서드에 대한 제약이 있는 것은 아니다.
	 * 한번 스트림을 얻으면, 스트림에서 제공하는 메서드를 이용하여 String에 있는 문자들을 처리할 수 있다. 
	 * ex) map(), filter(), reduce(), 스트링에서 숫자(digit)로 필터링
	 *   
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "w00t"; 
//		str.chars()
//			.forEach(ch -> System.out.println(ch));
//		str.chars()
//			.forEach(System.out::println);
		
		// 편의함수(컨비니언스 메서드(convenience method))
//		str.chars()
//			.forEach(IterateString::printChar);
		
		// 처음부터 int 가 아닌 문자로 처리하고 싶으면 chars()를 호출한 다음, int -> 문자로 변환
//		str.chars()
//			.mapToObj(ch -> Character.valueOf((char)ch))
//			.forEach(System.out::println);
		
		// filter() 메서드와 forEach() 메서드에 전달하는 람다 표현식 대신 각 메서드에 대한 레퍼런스를 사용할 수 있다. 
		str.chars()
			.filter(Character::isDigit)
			.forEach(IterateString::printChar);
		
	}
	
	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}
	
	
	

}
