package pack01;

public class _01_quiz_01 {

	public static void main(String[] args) {
		// 문제
		// 1. 두개의 숫자가 같은지 비교하여 출력
		int a1 = 20;
		int b1 = 30;

		System.out.println(a1 == b1);

		// 2. a에 곱하기 -1한 결과를 다시 a에 저장 후 출력
		int a2 = 40;

		a2 = a2 * -1;

		System.out.println(a2);

		// 3. a값 출력
		boolean a3 = false;

		System.out.println(a3);

		// 4. 아래 변수는 시험의 합격여부 한가지 시험만 합격하면 최종합격
		// 이를 판별하여 출력
		boolean aTest4 = true; // aTest는 합격
		boolean bTest4 = false; // bTest는 불합격

		System.out.println(aTest4 || bTest4);

		// 5. a가 b보다 크고 aa가 bb보다 작으면 성공
		// 이를 판별하여 출력
		int a5 = 10;
		int b5 = 20;
		int aa5 = 30;
		int bb5 = 40;

		System.out.println(a5 > b5 && aa5 < bb5);

		// 6. c변수값이 a 변수값과 b변수값 사이에 있으면 true 출력(단 a<b)
		int a6 = 10;
		int b6 = 20;
		int c6 = 30;

		System.out.println(a6 < c6 && c6 < b6);

		// 7. 수식이 a값 변수보다 크면 true 출력
		int a7 = 30;
		System.out.println(a7 < (2 + 3) * 2 - 4);

		// 8. 다음 연산의 결과를 계산해보시오
		int aa8 = 40;
		int bb8 = 30;
		int cc8 = 20;
		int dd8 = 2;
		int ee8 = 4;

		System.out.println(++aa8); // 41
		System.out.println(aa8); // 41
		System.out.println(++aa8 + bb8++); // 42+30=72
		System.out.println(--cc8 + (-aa8)); // 19+(-42) = -23
		System.out.println(cc8 + 2); // 19+2 = 21
		System.out.println(cc8); // 19
		System.out.println(--cc8 * (ee8 - dd8) + dd8++); // 18*(4-2)+2=38
	}

}
