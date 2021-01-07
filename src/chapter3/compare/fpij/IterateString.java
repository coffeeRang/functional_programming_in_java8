package chapter3.compare.fpij;

public class IterateString {

	/**
	 * �޼��� ���۷���
	 *   - Ŭ������ �̸�(String) �� ������� �ϱ� ������ String::toUppercase ���·� ��� �����ϴ�.
	 *   - String::toUppercase == parameter.toUppercase();
	 *   - �ν��Ͻ� �޼��忡 ���� �޼��� ���۷����� �������̸� Print ��Ʈ���� �ν��Ͻ��� ���� ���۷����� System.out�� ���� �׼����ȴ�.
	 *   
	 * chars() �޼��带 �����ϴ� ��Ʈ���� ���� ���� ���ͷ����͸� ���������, �� �޼��忡 ���� ������ �ִ� ���� �ƴϴ�.
	 * �ѹ� ��Ʈ���� ������, ��Ʈ������ �����ϴ� �޼��带 �̿��Ͽ� String�� �ִ� ���ڵ��� ó���� �� �ִ�. 
	 * ex) map(), filter(), reduce(), ��Ʈ������ ����(digit)�� ���͸�
	 *   
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "w00t"; 
//		str.chars()
//			.forEach(ch -> System.out.println(ch));
//		str.chars()
//			.forEach(System.out::println);
		
		// �����Լ�(����Ͼ� �޼���(convenience method))
//		str.chars()
//			.forEach(IterateString::printChar);
		
		// ó������ int �� �ƴ� ���ڷ� ó���ϰ� ������ chars()�� ȣ���� ����, int -> ���ڷ� ��ȯ
//		str.chars()
//			.mapToObj(ch -> Character.valueOf((char)ch))
//			.forEach(System.out::println);
		
		// filter() �޼���� forEach() �޼��忡 �����ϴ� ���� ǥ���� ��� �� �޼��忡 ���� ���۷����� ����� �� �ִ�. 
		str.chars()
			.filter(Character::isDigit)
			.forEach(IterateString::printChar);
		
	}
	
	private static void printChar(int aChar) {
		System.out.println((char)(aChar));
	}
	
	
	

}
