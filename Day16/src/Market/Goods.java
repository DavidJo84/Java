package Market;

public class Goods {
	String name = null;
	String id = null;
	int cnt = 0;
	int price = 0;

	public void setting(String name, String id, int cnt, int price) {
		this.name = name;
		this.id = id;
		this.cnt = cnt;
		this.price = price;
	}

	public void prt() {
		System.out.println("�̸�: " + this.name);
		System.out.println("���̵�: " + this.id);
		System.out.println("����: " + this.cnt);
		System.out.println("����: " + this.price);
	}
}
