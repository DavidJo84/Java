package Tr;

public class Day05_01 {

	public static void main(String[] args) {
		// 1. 반복문

		// 문제 1. 1부터 10까지 숫자를 출력하시오.
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		System.out.println("--------------------");

		// 문제2. 9부터 0까지 숫자를 출력하시오.
		for (int i = 9; i >= 0; i--) {
			System.out.println(i);
		}
		System.out.println("--------------------");

		// 2. 이중 for문
		for (int i = 1; i < 10; i++) {
			System.out.println(i + "단입니다. ");
			for (int j = 1; j < 4; j++) {
				System.out.println(i + "x" + j + "=" + i * j);
			}
			System.out.println("--------------------");
		}
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 5; j++) {
				System.out.print(j + "x" + i + "=" + i * j + "\t");// "\t"=자동 tab
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제1. 별 다섯개씩 4줄 출력
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제2. 아래의 별모양 찍기
//				*
//				**
//				***
//				****
//				*****
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제3. 아래의 별모양 찍기
//		*****
//		****
//		***
//		**
//		*
		for (int i = 1; i < 6; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제4. 아래의 별모양 찍기
//		00000*
//		0000**
//		000***
//		00****
//		0*****
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("0");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제5. 아래의 별모양 찍기
//		0
//		*0
//		**0
//		***0
//		****0
		// 내가 푼 답
		for (int i = 1; i <= 5; i++) {
			for (int j = 2; j <= i; j++) {
				System.out.print("*");
			}
			for (int k = 1; k <= 1; k++) {
				System.out.print("0");
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 선생님이 푼 답
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					System.out.print("0");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("--------------------");

		// 문제 6. 1!+2!+3!+4!+5!+6!을 구하라.
		int sum = 0;
		for (int i = 1; i <= 6; i++) {
			int a = 1;
			for (int j = 1; j <= i; j++) {
				a *= j;
			}
			if(i==6) {
				System.out.print(a+"=");
			}else {
				System.out.print(a+"+");
			}
			sum += a;
		}
		System.out.println(sum);

	}
}
