package Tr;

public class Day12_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = new int[4][5];
		int cnt = 1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < a.length; j++) {
				a[j][i] = cnt;
				cnt++;
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("---------------------------");
		int[][] b = new int[4][5];
		int cnt2 = 1;
		for (int i = 4; i >= 0; i--) {
			for (int j = 0; j < 4; j++) {
				b[j][i] = cnt2;
				cnt2++;
			}
		}
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("---------------------------");
		int[][] c = { { 5, 32, 23, 34, 2 }, { 4, 12, 13, 36, 6 }, { 87, 62, 21, 43, 97 }, { 65, 32, 12, 32, 22 } };

		for (int i = 0; i < c.length; i++) {
			int sum = 0;
			for (int j = 0; j < 5; j++) {
				sum += c[i][j];
			}
			System.out.println(i + "행의 합= " + sum);
		}
		System.out.println("---------------------------");
		for (int i = 0; i < 5; i++) {
			int sum = 0;
			for (int j = 0; j < c.length; j++) {
				sum += c[j][i];
			}
			System.out.println(i + "열의 합= " + sum);
		}
	}

}
