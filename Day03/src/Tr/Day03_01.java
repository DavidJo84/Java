package Tr;

public class Day03_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����1. ������ 90�̻��� ����� ����, 90�̸��� ������ ���
		int score = 76;

		if (score >= 90) {
			System.out.println("����");
		} else {
			System.out.println("����");
		}
		// ����2. ������ 60�̻� 80������ ����� ���߾���� ���

		if (60 <= score && score <= 80) {
			System.out.println("���߾��");
		}

		// ����2-1. ������ 60�̻� 80������ ����� ���߾���� ���(&&������ ���� �ʰ�)
		if (60 <= score) {
			if (score <= 80) {
				System.out.println("���߾��");
			}

		}
		// ����3. ���� ������ 30�� ���� ���� 100�� ������ �� ������ 100���� �����ϰ�
		// �׷��� ������ �� ������ 30�� ���Ͽ� �����Ѵ�.

		if (score + 30 > 100) {
			score = 100;
		} else {
			score += 30;
		}

	}

}
