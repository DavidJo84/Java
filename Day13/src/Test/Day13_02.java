package Test;

public class Day13_02 {

	public static void main(String[] args) {
		int[][] a = { { 54, 23, 23, 53, 87 }, { 3, 21, 55, 90, 27 }, { 2, 32, 22, 18, 65 }, { 32, 39, 12, 33, 94 } };

		// ¹®Á¦ 9
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
		int[][] b = new int[x][y];

		for (; c < x;) {
			for (int i = bb; i < x; i++) {//i=0, i<4
				for (int j = c; j <= y - 1; j++) { //j=0,j<=4
					if (i == bb && j < y - 1) {//i=0,j<4
						b[i][j + 1] = a[i][j];//b[0][1]=a[0][0]
					} else if (i < x - 1 && j == y - 1) {
						b[i + 1][j] = a[i][j];
					}
				}
			}
			b[bb][c] = a[bb+1][c];//1. b[0][0]=a[1][0] 2. b[1][1]=a[2][1] 3. b[2][2]=a[3][2]
			bb++; // bb=1
			y--; // y=4
			x--; // x=3
			for (int i = x; i >= bb; i--) {//i=3,2,1
				for (int j = y - 1; j >= c; j--) {//j=3,2,1,0
					if (i == x) {//i=3
						b[i][j] = a[i][j + 1];//b(3,3)=a(3,4)
					} else if (i < x && j == c) {//i=2,1 j=0
						b[i][j] = a[i + 1][j];//b(2,0)=a(3,0)
					}
				}
			}
			c++;// c=1
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
