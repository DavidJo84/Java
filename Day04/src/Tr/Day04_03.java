package Tr;

public class Day04_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[5];
		int[] b = { 44, 54, 23, 12, 45, 76 };
		// ����1. a�迭 ��� ���� ���� 10�� ����.

		for (int i = 0; i < a.length; i++) {
			a[i] = 10;
		}

		// ����2. b�迭�� ��� ���� 1�� ����.
		for (int i = 0; i < b.length; i++) {
			b[i]++;

		}

		// ����3. b�迭�� ��� ���� ���簪���� 10�� ���� �� ���(�� �迭�� ���� ������� ����)
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i] + 10);
		}

		// ����4. b�迭�� ��� ���� ���� ������ 20�� ���� �� ���(�迭�� ���ŵ� ���� ����)
		for (int i = 0; i < b.length; i++) {
			b[i] += 20;
			System.out.println(b[i]);
		}

		// ����5. b�迭�� ��� ���� ����ϵ�, ¦���� ¦��, Ȧ���� Ȧ����� ���
		for (int i = 0; i < b.length; i++) {
			if (b[i] % 2 == 0) {
				System.out.println(b[i] + " ¦��");
			} else {
				System.out.println(b[i] + " Ȧ��");
			}
		}

	}

}
