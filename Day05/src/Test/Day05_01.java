package Test;

public class Day05_01 {

	public static void main(String[] args) {
		// 오후 실
//		1. 1단에서 5단까지 구구단을 출력하시오.
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		2. 1단에서 5단까지 구구단을 출력하시오. 단, 짝수단은 출력하지 마시오.
		for (int i = 1; i <= 5; i++) {
			if (i % 2 == 1) {
				for (int j = 1; j <= 9; j++) {
					System.out.println(i + "*" + j + "=" + i * j);
				}
			} else {
				System.out.println();
			}
		}
		System.out.println("---------------------");
//
//		3.
//		00000
//		00000
//		00000
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 5; j++) {
				System.out.print("0");
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		4.
//		00000
//		*****
//		00000
//		*****
		for (int i = 1; i <= 4; i++) {
			if (i % 2 == 1) {
				for (int j = 1; j <= 5; j++) {
					System.out.print("0");
				}
			} else {
				for (int j = 1; j <= 5; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		5.
//		0*0*0*0*
//		0*0*0*0*
//		0*0*0*0*
//		0*0*0*0*
		for (int i = 1; i <= 4; i++) {

			for (int j = 1; j <= 8; j++) {
				if (j % 2 == 1) {
					System.out.print("0");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		6.  
//		00000*
//		0000***
//		000*****
//		00*******
//		0*********
//		***********
		for (int i = 1; i <= 6; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("0");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		7.
//		***********
//		0*********
//		00*******
//		000*****
//		0000***
//		00000*
		for (int i = 6; i >= 1; i--) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print("0");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//
//		8.
//		0000000*
//		000000*
//		00000*
//		0000*
//		000*
//		00*
//		0*
		for (int i = 8; i > 1; i--) {
			for (int j = 1; j <= i; j++) {
				if (j == i) {
					System.out.print("*");
				} else {
					System.out.print("0");
				}
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//
//		9. 
//		00000*
//		0000***
//		000*****
//		00*******
//		0*********
//		***********
//		0*********
//		00*******
//		000*****
//		0000***
//		00000*
		for (int i = 1; i <= 6; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("0");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = 5; i >= 1; i--) {
			for (int j = 1; j <= 6 - i; j++) {
				System.out.print("0");
			}
			for (int j = 1; j <= i * 2 - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("---------------------");
//
//		10. 이중 for문
//		1팩토리얼+2팩토리얼+3팩토리얼의 합을구하시오.
//		3팩토리얼은 1*2*3 이다. 
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			int facto = 1;
			for (int j = 1; j <= i; j++) {
				facto *= j;
			}
			if (i == 3) {
				System.out.print(facto + "=");
			} else {
				System.out.print(facto + "+");
			}
			sum += facto;
		}
		System.out.println(sum);
		System.out.println("---------------------");
//
//		11. 9번을  for문 2개, if는 상관없음 <어려움>

		for (int i = 5; i >= -5; i--) {
			for (int j = Math.abs(i); j >= 1; j--) {
				System.out.print("0");
			}
			for (int j = Math.abs(i); j + Math.abs(i) <= 10; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
