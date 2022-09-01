package Tr;

public class Day06_01 {

	public static void main(String[] args) {
		// 개발자는 코딩을 잘하는 사람이 아닌 문제를 해결하는 사람이다.
		for (int i = 0; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("-----------------");

		for (int i = 0; i < 4; i++) {
			System.out.print(i + " : ");
			for (int j = i; j <= 4; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("-----------------");

		// 문제1.
//		0 : 1234
//		1 : 123
//		2 : 12
//		3 : 1
		for (int i = 0; i < 4; i++) {
			System.out.print(i + " : ");
			for (int j = 1; j <= 4 - i; j++) {
				System.out.print(j);
			}
			System.out.println();
		}
		System.out.println("-----------------");

		// 랜덤함수
		int a = (int) (Math.random() * 45); // (0~44까지) 랜덤으로 나오는 수는 뒤애 곱하는 수보다 작
		System.out.println(a);
		System.out.println("-----------------");

		// 로또번호 7자리 숫자 뽑는 프로그램을 만들고 로또번호를 출력.
		int[] rotto = new int[7];
		for (int i = 0; i < rotto.length; i++) {
			rotto[i] = (int) (Math.random() * 45 + 1);// 1~45까지
		}
		for (int i = 0; i < rotto.length; i++) {
			System.out.print(rotto[i] + " ");
		}
		System.out.println();
		System.out.println("-----------------");

		// 위 로또게임을 3번 반복하시오.
		for (int k = 0; k < 3; k++) {
			int[] rotto1 = new int[7];
			for (int i = 0; i < rotto1.length; i++) {
				rotto1[i] = (int) (Math.random() * 45 + 1);// 1~45까지
			}
			for (int i = 0; i < rotto1.length; i++) {
				System.out.print(rotto1[i] + "\t");
			}
			System.out.println();
		}
		System.out.println("-----------------");

		int[] a1 = { 10, 23, 23, 25, 10, 4 };

		// 문제1. 위 배열의 값을 모두 더하시오.
		int sum1 = 0;
		for (int i = 0; i < a1.length; i++) {
			sum1 += a1[i];
		}
		System.out.println(sum1);
		System.out.println("-----------------");
		
		// 문제 2. 배열의 값중 10이 몇개인가?
		int cnt = 0;
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == 10) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println("-----------------");
	}
}
