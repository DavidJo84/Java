package Tetris;

public class tetris {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = { { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } };
		int[][] b = { { 2, 2, 0 }, { 0, 2, 0 }, { 0, 2, 2 } };

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");

		rRotation(a);
		rRotation(a);
		rRotation(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("------------------");
	}

	private static void rRotation(int[][] k) {
		int start = 0;
		int end = k.length - 1;
		if (k[end][start] == 0) {
			for (int j = 0; j < k.length; j++) {
				for (int i = 0; i < k.length; i++) {
					k[i][end] = 1;
					k[end][i] = 1;
					if (j < end) {
						k[i][j] = 0;
					}
				}
			}
		}
		if (k[start][start] == 0) {
			for (int j = 0; j < k.length; j++) {
				for (int i = 0; i < k.length; i++) {
					k[end][i] = 1;
					if (j < end) {
						k[start][j] = 0;
					}
				}
			}
		}

	}

}
