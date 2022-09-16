package Tr;

import java.util.Scanner;

public class Day14_01 {

	public static void main(String[] args) {
		// 선생님 방법 달팽이 배열
		int[][] a = new int[4][5];
		int cnt = 1;
		int rowMin = 0; // 첫번째 행
		int rowMax = 3; // 마지막 행
		int colMin = 0; // 첫번째 열
		int colMax = 4; // 마지막 열
		for (int j = 0; j < 2; j++) {
			for (int i = colMin; i <= colMax; i++) {// i=0,1,2,3,4
				a[rowMin][i] = cnt++; // rowMin=0
			}
			rowMin++;// 1
			for (int i = rowMin; i <= rowMax; i++) {// i=1,2,3
				a[i][colMax] = cnt++; // 4
			}
			colMax--;// 3
			for (int i = colMax; i >= colMin; i--) {// 3,2,1,0
				a[rowMax][i] = cnt++;// 3
			}
			rowMax--;// 2
			for (int i = rowMax; i >= rowMin; i--) {
				a[i][colMin] = cnt++;
			}
			colMin++;
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");

		// 가. 키보드로 숫자를 5개를 입력 받아 이를 배열에 저장하고 출력하는 프로그램을 작성하시오
		// 단, 입력부와 출력부를 나눠서 작성한다.
		Scanner in = new Scanner(System.in);

		int[] b = new int[5];
		for (int i = 0; i < b.length; i++) {
			System.out.println(i + 1 + "번째 숫자를 입력하세요: ");
			b[i] = in.nextInt();
			in.nextLine();
		}
		in.close();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}
		System.out.println();
		System.out.println("--------------------------------------");

//		나. 아래 배열에서 짝수는 바이러스이다 바이러스를 모두 0으로 바꾸시오.
		int[][] c = { { 32, 23, 12, 23, 23 }, { 31, 32, 1, 23, 24 }, { 35, 22, 12, 21, 21 }, { 32, 22, 11, 22, 22 },
				{ 22, 22, 145, 22, 23 } };

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (c[i][j] % 2 == 0) {
					c[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(c[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("--------------------------------------");
		
		//다. 아래 배열에서 20보다 큰수 모두 몇개인가?
		int[][] d = { { 32, 23, 12, 23, 23 }, { 31, 32, 1, 23, 24 }, { 35, 22, 12, 21, 21 }, { 32, 22, 11, 22, 22 },
				{ 22, 22, 145, 22, 23 } };
		int cnt2=0;
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (d[i][j] > 20) {
					cnt2++;
				}
			}
		}
		System.out.println("20보다 큰 수는 "+cnt2+"개 ");
		
//		라. 
//		1부터 9999까지 숫자를 모두 더하시오.
//		더하는 방법은  99인 경우 9+9를 더하고,   875일 경우는 8+7+5를 더한다
//		이와 같은 방식으로 1부터 9999까지 모든 자릿수를 더한 결과를 출력하시오.
//
//		int sum=0; 를 선언하고 for문 2개만 해결한다. 
		
		
		

		int sum =0;
		for(int i=1; i<=9999;i++ ) {
			for(int j=10;j<=10000;) {
				sum += (i%j)/(j/10);
				j=j*10;
			}
		}
		System.out.println(sum);
		
	}
}
