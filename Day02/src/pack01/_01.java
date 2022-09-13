package pack01;

public class _01 {

	public static void main(String[] args) {
		// 연산자: 산술, 논리,부호, 비교, 대입, 증감, 조건
		System.out.println(10 + 20); // 산술연산자
		System.out.println(true); // 논리연산자

		boolean b1 = false;
		boolean b2 = true;

		System.out.println(b2);
		System.out.println(!b1); // 논리연산자(not)
		System.out.println(b1 && b2); // 논리연산자(and)
		System.out.println(b1 || b2); // 논리연산자(or)

		int a = 10;
		a += 20; // 대입연산자
		int b = 30;

		System.out.println(a);
		System.out.println(-a); // 부호연산자
		System.out.println(b1 == b2); // 비교연산자
		System.out.println(a >= b); // 비교연산자
		System.out.println((a > b) ? "ok" : "sk"); // 조건연산자 (if) ? true : false

		// 증감연산자
		// ++a = a+1 전위 - 연산 후 실행
		// a++ = a+1 후위 - 실행 후 연산

		int a1 = 40;
		System.out.println(a1); // 40
		System.out.println(a1++); // 40 후위 연산자여서 40 출력후 40+1 계산
		System.out.println(a1); // 41 a1은 40+1로 변경되었으므로 41 출력
		System.out.println(++a1); // 42 전위연산자여서 41+1 먼저 계산후 출력
		System.out.println(a1); // 42
		System.out.println(a1 + 1); // 43 출력할때만 연산하여 실제 a1값은 변경안됨
		System.out.println(a1); // 42
	}

}
