package Tr;

public class Member {
	// �����ڴ� �����Ǿ� ����. ������ �������� ���� �Է�
	// �����ڴ� Ŭ������ ��ü�� ��������� ���� ���� ����Ǵ� �޼���
	// �����ڴ� Ŭ������ �̸��� ������ �޼���
	int point = 80;
	String id;
	String name;
	String pwd = "1234";

	Member() {
		System.out.println("member ������");
	}

	public void a() {
		System.out.println(point);
	}

	public int aa(String id) {
		System.out.println(id);
		return 1;
	}

	public String aaa() {
		return name;
	}
}
