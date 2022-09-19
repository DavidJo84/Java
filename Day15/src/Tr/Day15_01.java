package Tr;

public class Day15_01 {

	public static void main(String[] args) {
		// 메서드를 공부하는 팁
		//1. 메서드의 기능 2. 메서드를 호출할 때 넘겨주는 매개변수
		//3.메서드의 기능이 수행된 후 호출부로 리턴하는 값과 타입
		System.out.println("프로그램의 시작");
		Member m = new Member();
		System.out.println(m.point);
		System.out.println(m.pwd);
		m.a();
		m.aa("kkk");
		m.aaa();
		int aaa=m.aa("adfa");
		System.out.println(aaa);
		System.out.println("프로그램의 종료");
	}
}
