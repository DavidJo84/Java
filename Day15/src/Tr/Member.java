package Tr;

public class Member {
	// 생성자는 생략되어 있음. 지금은 가독성의 위해 입력
	// 생성자는 클래스가 객체로 만들어질때 제일 먼저 실행되는 메서드
	// 생성자는 클래스의 이름과 동일한 메서드
	int point = 80;
	String id;
	String name;
	String pwd = "1234";

	Member() {
		System.out.println("member 생성자");
	}

	public void a() {
		System.out.println(point);
	}

	public int aa(String id) {
		System.out.println(id);
		return 1;
	}

	public String aaa() {
		return name;
	}
}
