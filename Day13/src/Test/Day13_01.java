package Test;

public class Day13_01 {

	public static void main(String[] args) {
		int[][] a = { { 54, 23, 23, 53, 87 }, { 3, 21, 55, 90, 27 }, { 2, 32, 22, 18, 65 }, { 32, 39, 12, 33, 94 } };

		// 문제 9
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-----------------------------------");

		int x = 4;
		int y = 5;
		int bb = 0;
		int c = 0;
		// int[][] b = new int[x][y];
		int temp = 0;
		int temp2 = 0;
		for (; c < x;) {
			for (int i = bb; i < x; i++) {
				for (int j = c; j <= y - 1; j++) {
					if (i == bb && j < y - 1) {// i= 0 이고 j<4
						temp2 = a[i][j];
						a[i][j] = temp;
						temp = temp2;
					} else if (i < x && j == y - 1) {// i <4 , j=4
						temp2 = a[i][j];
						a[i][j] = temp;
						temp = temp2;
					}
				}
			}
			y--; // y=4
			x--; // x=3
			for (int i = x; i >= bb; i--) {// i=3 , i>=0
				for (int j = y - 1; j >= c; j--) {// j=3,j>=0
					if (i == x) { // i=3
						temp2 = a[i][j];
						a[i][j] = temp; //(3,3) (3,2) (3,1) (3,0)
						temp = temp2;
					} else if (i <= x && j == c) {// i<=3 , j=0
						temp2 = a[i][j]; //(3,0)(2,0)(1,0)(0,0)
						a[i][j] = temp;
						temp = temp2;
					}
				}
			}
			bb++; //bb=1
			c++;// c=1
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
