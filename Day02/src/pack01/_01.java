package pack01;

public class _01 {

	public static void main(String[] args) {
		// ������: ���, ��,��ȣ, ��, ����, ����, ����
		System.out.println(10 + 20); // ���������
		System.out.println(true); // ��������

		boolean b1 = false;
		boolean b2 = true;

		System.out.println(b2);
		System.out.println(!b1); // ��������(not)
		System.out.println(b1 && b2); // ��������(and)
		System.out.println(b1 || b2); // ��������(or)

		int a = 10;
		a += 20; // ���Կ�����
		int b = 30;

		System.out.println(a);
		System.out.println(-a); // ��ȣ������
		System.out.println(b1 == b2); // �񱳿�����
		System.out.println(a >= b); // �񱳿�����
		System.out.println((a > b) ? "ok" : "sk"); // ���ǿ����� (if) ? true : false

		// ����������
		// ++a = a+1 ���� - ���� �� ����
		// a++ = a+1 ���� - ���� �� ����

		int a1 = 40;
		System.out.println(a1); // 40
		System.out.println(a1++); // 40 ���� �����ڿ��� 40 ����� 40+1 ���
		System.out.println(a1); // 41 a1�� 40+1�� ����Ǿ����Ƿ� 41 ���
		System.out.println(++a1); // 42 ���������ڿ��� 41+1 ���� ����� ���
		System.out.println(a1); // 42
		System.out.println(a1 + 1); // 43 ����Ҷ��� �����Ͽ� ���� a1���� ����ȵ�
		System.out.println(a1); // 42
	}

}
