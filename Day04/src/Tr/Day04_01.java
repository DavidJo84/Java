package Tr;

public class Day04_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����1. 1���� 100���� ���Ѱ��� ����ϼ���.
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println(sum);

		// ����2. 1���� 100���� Ȧ���� ��� ī�����ϼ���.
		int cnt = 0;
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 1) {
				cnt++;
			}
		}
		System.out.println(cnt);

		// ����3.1���� 100���� �� Ȧ���� ����Ͻÿ�.
		for (int i = 0; i <= 100; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
		// ����4. 1���� 100���� �� Ȧ���� ���ϰ� ¦���� ���� ����� ����Ͻÿ�.
		int sum1 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum1 -= i;
			} else {
				sum1 += i;
			}

		}
		System.out.println(sum1);

		// ����5. 1���� 100���� ���� �� 3�� ����� ��� ���Ͻÿ�.
		int sum3 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum3 += i;
			}
		}
		System.out.println("3�� ����� ��:" + sum3);
		// ����6. 1���� 100���� ������ 4�� ����� ���հ� ������ ���� ���Ͻÿ�.
		int sum4 = 0;
		int cnt4 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				sum4 += i;
				cnt4++;
			}
		}
		System.out.println("4�� ����� ��:" + sum4);
		System.out.println("4�� ����� ����:" + cnt4);

		// ����7. 1���� 100���� ������ 3�� ����� �հ� 2�� ����� ������ ���� ���Ͻÿ�.
		int sum5 = 0;
		int cnt5 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				cnt5++;

			}
			if (i % 3 == 0) {
				sum5 += i;
			}
		}
		System.out.println("3�� ����� ��:" + sum5);
		System.out.println("2�� ����� ����:" + cnt5);
	}
}
