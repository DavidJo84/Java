package Tr;

import java.util.Scanner;

public class Day14_01 {

	public static void main(String[] args) {
		// ������ ��� ������ �迭
		int[][] a = new int[4][5];
		int cnt = 1;
		int rowMin = 0; // ù��° ��
		int rowMax = 3; // ������ ��
		int colMin = 0; // ù��° ��
		int colMax = 4; // ������ ��
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

		// ��. Ű����� ���ڸ� 5���� �Է� �޾� �̸� �迭�� �����ϰ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�
		// ��, �Էºο� ��ºθ� ������ �ۼ��Ѵ�.
		Scanner in = new Scanner(System.in);

		int[] b = new int[5];
		for (int i = 0; i < b.length; i++) {
			System.out.println(i + 1 + "��° ���ڸ� �Է��ϼ���: ");
			b[i] = in.nextInt();
			in.nextLine();
		}
		in.close();
		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + "\t");
		}
		System.out.println();
		System.out.println("--------------------------------------");

//		��. �Ʒ� �迭���� ¦���� ���̷����̴� ���̷����� ��� 0���� �ٲٽÿ�.
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
		
		//��. �Ʒ� �迭���� 20���� ū�� ��� ��ΰ�?
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
		System.out.println("20���� ū ���� "+cnt2+"�� ");
		
//		��. 
//		1���� 9999���� ���ڸ� ��� ���Ͻÿ�.
//		���ϴ� �����  99�� ��� 9+9�� ���ϰ�,   875�� ���� 8+7+5�� ���Ѵ�
//		�̿� ���� ������� 1���� 9999���� ��� �ڸ����� ���� ����� ����Ͻÿ�.
//
//		int sum=0; �� �����ϰ� for�� 2���� �ذ��Ѵ�. 
		
		
		

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
