package pack01;

public class _02 {

	public static void main(String[] args) {
		// �迭
		// �ε����� ����
		// index �� 0���� ����

		int[] point = new int[5]; // new�� �ϱ�, �տ� int[]: int�� �����ϴ� �ڷ����� ����
									// point �� ������
									// �ڿ� int[5]: 5���� int�� ������ �� �ִ� ����(�迭�� ũ��)
									// index �� 0~4���� ����
		point[0] = 80; // point �迭 (index) 0�� value�� 80�� ����
		point[1] = 90; // point �迭 (index) 1�� value�� 90�� ����
		point[2] = 92;
		point[3] = 88;
		point[4] = 98;

		String[] partName = { "java", "mysql", "oracle", "html", "css" };

		System.out.println(partName[0] + ":" + point[0]);
		System.out.println(partName[1] + ":" + point[1]);
		System.out.println(partName[2] + ":" + point[2]);
		System.out.println(partName[3] + ":" + point[3]);
		System.out.println(partName[4] + ":" + point[4]);

		String[] fruit = new String[4];

		fruit[0] = "������";
		fruit[3] = "����";

		System.out.println(fruit[0]); // ������
		System.out.println(fruit[1]); // NULL String�� �ʱⰪ�� NULL, int�� �ʱⰪ�� 0
		System.out.println(fruit[2]); // NULL
		System.out.println(fruit[3]); // ����

	}

}
