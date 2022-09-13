package pack01;

public class _02_quiz {

	public static void main(String[] args) {
		// 다음문제를 해결하시오..

		// 1 <손코딩>
		int a = 10;
		int b = 30;
		int c = 40;

		System.out.println(a++); // 10
		System.out.println(--b + c++); // 69
		System.out.println(c++); // 41

		// 답: 10,69,41

		// 2. <손코딩>a와 b 중 둘다 90점 이상이면 true의 식을 작성
		int a2 = 60;
		int b2 = 90;

		// 답: System.out.println(a>=90 && b>=90);

		// 3. <손코딩> 2번의 a와 b 중 둘 중 하나면 90점 이상이면 false의 식을 작성

		// 답:
		System.out.println(a2 >= 90 && b2 >= 90);

		// 4. <손코딩>숫자 10개를 저장하는 배열을 선언하시오 배열명은 intPoint

		int[] intPoint = new int[10];

		// 5. <손코딩>숫자 3개를 저장하는 배열을 선언할 때 초기값 10 20 30을 입력하시오 배열명은 intNumber

		int[] intNumber = { 10, 20, 30 };

		// 6.<손코딩> a 배열의 모든 값을 0번 인덱스 부터 차례대로 출력하시오.

		int[] a6 = new int[4];
		a6[1] = 50;
		a6[3] = 40;

		// 답
		System.out.println(a6[0]);
		System.out.println(a6[1]);
		System.out.println(a6[2]);
		System.out.println(a6[3]);

		// 배열의 사이즈?4
		// 배열의 인덱스의 범위?0~3

		// 7. <손코딩>
		int[] a7 = { 10, 20, 30, 40 };
		// 다음 결과값을 적으시오.
		System.out.println(a7[0]); // 10
		System.out.println(a7[1]++); // 20
		System.out.println(a7[1]); // 21
		System.out.println(a7[2]); // 30

		// 답: 10 , 20 , 21 , 30

		// ---------------- 8번 부터는 응용입니다.

		// 8. pay는 금액이다. 금액을 단위별로 잘라서 배열에 저장하려고 한다 (원, 십원, 백원, 천원, 만원)
		// 배열을 선언한 후 금액의 알맞게 배열에 저장하시오.
		int pay = 12345;

		// 답
		int[] money = new int[5];

		money[4] = pay / 10000;
		money[3] = pay % 10000 / 1000;
		money[2] = pay % 1000 / 100;
		money[1] = pay % 100 / 10;
		money[0] = pay % 10;

		// 9. 철수는 1-6까지 숫자가 적힌 주사위를 굴려서 나온 숫자 만큼 전진하고, 그 곳에 미션을 해결하는
		// 게임을 만들고자 한다.
		// 다음 조언에 맞게 설계하시오
		// 가. 주사위를 굴려서 나오는 숫자가 있어야 한다.
		// 나. 게임은 총 10개의 칸이 있다. (첫번째 칸의 번호는 0번이다)
		// 다. 3번째 칸은 가위바위보 미션이 있고, 6번째 칸은 2칸뒤로라는 미션이 있다.
		// (제시하지 않은 곳은 추후에 정할 예정이다, 현재는 기본값으로 한다)
		// 라. 설정한 게임판을 출력하시오.
		// 출력은 0번째 칸의 내용 :
		// 1번째 칸의 내용:

		// 답
		int[] marble = { 1, 2, 3, 4, 5, 6 };

		String[] game = new String[10];

		game[2] = "가위바위보";
		game[5] = "2칸 뒤로";

		System.out.println(game[0]);
		System.out.println(game[1]);

		// 10. 배열의 값을 다음과 같이 바꾸세요
		// 앞에 2개의 값을 자신의 위치에 저장한다.
		// 예를들어 2번 인덱스위치는
		// 2번 인덱스위치 = 1번인덱스 + 0번인덱스
		// 단 인덱스가 위 배열에서 벗어나면 0으로 한다.
		// 조건, 값을 더할 때는 갱신된 값이 아닌 10, 20, 30, 40, 50을 기준으로 갱신한다.

		// 결과배열 = {10,30,60,90,120}
		int[] p = { 10, 20, 30, 40, 50 };
		// 답
		p[1] = 0 + p[0];
		p[2] = p[0] + p[1];
		p[3] = p[1] + p[2];
		p[4] = p[2] + p[3];
		p[0] = 0 + 0;

		System.out.println(p[0]);
		System.out.println(p[1]);
		System.out.println(p[2]);
		System.out.println(p[3]);
		System.out.println(p[4]);

		// 11.1번 인덱스 values값 뒤에 korea라는 글자를 추가하시오.
		// 조건, sonata라는 글자가 변하더라도 같은 결과가 나와야 합니다.
		String[] car = { "k5", "sonata" };
		// 답:
		car[1] = car[1] + "korea";

		// 12. 철수는 골프 게임을 만들고 있다.
		// 함정의 위치의 좌표는 다음과 같다.
		int x = 30;
		int y = 40;
		// 함정의 크기는 가로와 세로 각 20이다.(단 함정 모든 좌표는 x=30 y=40이상이다)

		int nowx = 35; // 골프공의 x좌표
		int nowy = 35; // 골프공의 y좌표

		// 골프공이 함정에 빠졌는지를 판단하는 식을 작성하시고 이를 출력하시오.

		// 답:
		boolean result = ((x - 10 <= nowx & nowx <= x + 10) && (y - 10 <= nowy & nowy <= y + 10));
		System.out.println(result ? "함정에 빠졌습니다" : "함정에 빠지지 않았습니다");

		// 13.다음조건에 맞게 출력하시오.
		// 출력 문자열은 a인덱스 위치의 2번째 뒤 문자열이다. 만약 a가 배열의 인덱스 범위를 벗어나면
		// 앞으로 이동한다. 예들들어 a=3 경우, 두번째 뒤인 4 -> 0 출력은 a가 된다.

		String[] word = { "a", "b", "c", "d", "e" };
		int a13 = 3; // a는 인덱스 위치이다.

		System.out.println(word[(a13 + 2) % 5]);

	}
}
