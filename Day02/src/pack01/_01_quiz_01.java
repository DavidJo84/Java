package pack01;

public class _01_quiz_01 {

	public static void main(String[] args) {
		// ����
		// 1. �ΰ��� ���ڰ� ������ ���Ͽ� ���
		int a1 = 20;
		int b1 = 30;

		System.out.println(a1 == b1);

		// 2. a�� ���ϱ� -1�� ����� �ٽ� a�� ���� �� ���
		int a2 = 40;

		a2 = a2 * -1;

		System.out.println(a2);

		// 3. a�� ���
		boolean a3 = false;

		System.out.println(a3);

		// 4. �Ʒ� ������ ������ �հݿ��� �Ѱ��� ���踸 �հ��ϸ� �����հ�
		// �̸� �Ǻ��Ͽ� ���
		boolean aTest4 = true; // aTest�� �հ�
		boolean bTest4 = false; // bTest�� ���հ�

		System.out.println(aTest4 || bTest4);

		// 5. a�� b���� ũ�� aa�� bb���� ������ ����
		// �̸� �Ǻ��Ͽ� ���
		int a5 = 10;
		int b5 = 20;
		int aa5 = 30;
		int bb5 = 40;

		System.out.println(a5 > b5 && aa5 < bb5);

		// 6. c�������� a �������� b������ ���̿� ������ true ���(�� a<b)
		int a6 = 10;
		int b6 = 20;
		int c6 = 30;

		System.out.println(a6 < c6 && c6 < b6);

		// 7. ������ a�� �������� ũ�� true ���
		int a7 = 30;
		System.out.println(a7 < (2 + 3) * 2 - 4);

		// 8. ���� ������ ����� ����غ��ÿ�
		int aa8 = 40;
		int bb8 = 30;
		int cc8 = 20;
		int dd8 = 2;
		int ee8 = 4;

		System.out.println(++aa8); // 41
		System.out.println(aa8); // 41
		System.out.println(++aa8 + bb8++); // 42+30=72
		System.out.println(--cc8 + (-aa8)); // 19+(-42) = -23
		System.out.println(cc8 + 2); // 19+2 = 21
		System.out.println(cc8); // 19
		System.out.println(--cc8 * (ee8 - dd8) + dd8++); // 18*(4-2)+2=38
	}

}
