package Tr;

public class Day15_01 {

	public static void main(String[] args) {
		// �޼��带 �����ϴ� ��
		//1. �޼����� ��� 2. �޼��带 ȣ���� �� �Ѱ��ִ� �Ű�����
		//3.�޼����� ����� ����� �� ȣ��η� �����ϴ� ���� Ÿ��
		System.out.println("���α׷��� ����");
		Member m = new Member();
		System.out.println(m.point);
		System.out.println(m.pwd);
		m.a();
		m.aa("kkk");
		m.aaa();
		int aaa=m.aa("adfa");
		System.out.println(aaa);
		System.out.println("���α׷��� ����");
	}
}
