package Tr;

public class Day03_03 {

	public static void main(String[] args) {
		// ���� ������� �����϶�.
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
			i++;
		} // 1,3,5,7,9

		for (int i = 1; i <= 10; i++) {
			++i;
			System.out.println(i);
		} // 2,4,6,8,10

		// ���� �迭�� ����ϴ� for��

		String[] word = { "��", "��", "��", "��" };

		for (int i = 0; i <= 3; i++) {
			System.out.println(word[i]);
		}

		// ���� ����� �����Ͻÿ�
		for (int i = 0; i <= 3; i++) {
			System.out.println(word[i++]);
		} // ��,��

		// ��� ����Ʈ�� ����ϼ���, ��������� 23/45/22/34/67/
		int[] point = { 23, 45, 22, 34, 67 };

		for (int i = 0; i <= 4; i++) {
			System.out.print(point[i] + "/");
		}
		System.out.println();

		// �迭�� ���� ¦���ΰ͸� ���
		for (int i = 0; i <= 4; i++) {
			if (point[i] % 2 == 0) {
				System.out.print(point[i] + ",");
			}
		}
		System.out.println();
		
	}

}
