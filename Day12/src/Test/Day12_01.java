package Test;

import java.util.Scanner;

public class Day12_01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// 문제 5
		System.out.println("스네이크 배열 만들기 ");
		System.out.println("행의 갯수 입력: ");
		int f = in.nextInt();
		in.nextLine();
		System.out.println("열의 갯수 입력: ");
		int g = in.nextInt();
		in.nextLine();
		int[][] a = new int[f][g];
		int cnt = 1;
		for (int i = 0; i < a.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < g; j++) {
					a[i][j] = cnt;
					cnt++;
				}
			} else {
				for (int j = g - 1; j >= 0; j--) {
					a[i][j] = cnt;
					cnt++;
				}
			}
		}

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < g; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");

		// 문제 6
		// 인덱스의 합을 이용하여
		System.out.println("대각선 배열 만들기 ");
		System.out.println("행의 갯수 입력: ");
		int dd = in.nextInt();
		in.nextLine();
		System.out.println("열의 갯수 입력: ");
		int ee = in.nextInt();
		in.nextLine();
		int[][] b = new int[dd][ee];
		int cnt2 = 1;
		for (int i = 0; i <= (dd - 1) + (ee - 1); i++) {
			for (int j = 0; j < b.length; j++) {
				for (int k = ee - 1; k >= 0; k--) {
					if (j + k == i) {
						b[j][k] = cnt2;
						cnt2++;
					}
				}
			}
		}

		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < ee; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");
		
		// 두부분으로 나누어
		int[][] q = new int[dd][ee];
		int cnt4 = 1;
		for (int i = 0; i < ee; i++) {
			int row = 0;
			for (int j = i; j >= 0; j--) {
				if(row==dd) {
					break;
				}
				q[row][j] = cnt4;
				cnt4++;
				row++;
			}
		}
		for(int i=1; i<dd; i++) {
			int row=i;
			for(int j=ee-1;j>i;j--) {
				q[row][j]=cnt4;
				cnt4++;
				row++;
			}
			
		}
		
		for (int i = 0; i < q.length; i++) {
			for (int j = 0; j < ee; j++) {
				System.out.print(q[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");

		// 문제 7
		int[][] h = new int[4][5];
		int cnt3 = 1;
		for (int i = 0; i < h.length; i++) {
			if (i % 2 == 0) {
				for (int j = 0; j < 5; j++) {
					h[i][j] = cnt3;
					cnt3++;
				}
			} else {
				for (int j = 5 - 1; j >= 0; j--) {
					h[i][j] = cnt3;
					cnt3++;
				}
			}
		}
		int[][] c = { { 54, 23, 23, 53, 23 }, { 3, 21, 22, 32, 2 }, { 2, 32, 22, 12, 23 }, { 32, 32, 12, 33, 32 } };

		int[][] d = new int[4][5];

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < 5; j++) {
				d[i][j] = h[i][j] + c[i][j];
			}
		}
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("-------------------------------");

		// 문제 8

		System.out.println("달팽이 배열 만들기 ");
		System.out.println("행의 갯수 입력: ");
		int k = in.nextInt();
		in.nextLine();
		System.out.println("열의 갯수 입력: ");
		int z = in.nextInt();
		in.nextLine();
		int[][] e = new int[k][z];
		int x = k;
		int y = z;
		int num = 1;
		int bb = 0;
		int cc = 0;
		in.close();
		for (; cc <= x;) {
			for (int i = bb; i < x; i++) {
				for (int j = cc; j <= y - 1; j++) {
					if (i == bb) {
						e[i][j] = num;
						num++;
					} else if (j == y - 1) {
						e[i][j] = num;
						num++;
					}
				}
			}
			bb++;
			y--;
			x--;
			for (int i = x; i >= bb; i--) {
				for (int j = y - 1; j >= cc; j--) {
					if (i == x) {
						e[i][j] = num;
						num++;
					} else if (j == cc) {
						e[i][j] = num;
						num++;
					}
				}
			}
			cc++;
		}

		for (int i = 0; i < e.length; i++) {
			for (int j = 0; j < z; j++) {
				System.out.print(e[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
