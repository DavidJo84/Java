package Tr;

public class Day04_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 문제1. 1부터 100까지 합한값을 출력하세요.
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		// 문제2. 1부터 100까지 홀수를 모두 카운팅하세요.
		int cnt = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);

		// 문제3.1부터 100까지 중 홀수만 출력하시오.
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		// 문제4. 1부터 100까지 중 홀수는 더하고 짝수는 빼는 결과를 출력하시오.
		int sum1 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum1 -= i;
			} else {
				sum1 += i;
			}

		}
		System.out.println(sum1);

		// 문제5. 1부터 100까지 숫자 중 3의 배수를 모두 더하시오.
		int sum3 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum3 += i;
			}
		}
		System.out.println("3의 배수의 합:" + sum3);
		// 문제6. 1부터 100까지 숫자중 4의 배수의 총합과 갯수를 각각 구하시오.
		int sum4 = 0;
		int cnt4 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				sum4 += i;
				cnt4++;
			}
		}
		System.out.println("4의 배수의 합:" + sum4);
		System.out.println("4의 배수의 갯수:" + cnt4);

		// 문제7. 1부터 100까지 숫자중 3의 배수의 합과 2의 배수의 갯수를 각각 구하시오.
		int sum5 = 0;
		int cnt5 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				cnt5++;

			}
			if (i % 3 == 0) {
				sum5 += i;
			}
		}
		System.out.println("3의 배수의 합:" + sum5);
		System.out.println("2의 배수의 갯수:" + cnt5);
	}
}
