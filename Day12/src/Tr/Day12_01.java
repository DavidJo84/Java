package Tr;

public class Day12_01 {

	public static void main(String[] args) {
		// 2차원 배열
		int cnt = 1;
		int[][] c = new int[4][8];
		// 선언과 동시에 값 입력
//		int c[][]= {
//				{1,2,3,4,5,6,7,8},
//				{1,2,3,4,5,6,7,8},
//				{1,2,3,4,5,6,7,8},
//				{1,2,3,4,5,6,7,8}
//		};

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < 8; j++) {
				c[i][j] = cnt;
				cnt++;
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 8; j++) {
				System.out.print(c[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("---------------------");
		
		int[][] d = new int[4][5];
		int cnt2 = 1;
		for (int i = 0; i < d.length; i++) {
			for (int j = 4; j >= 0; j--) {
				d[i][j] = cnt2;
				cnt2++;
			}
		}
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
