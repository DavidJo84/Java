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
		System.out.println("이름: " + this.name);
		System.out.println("아이디: " + this.id);
		System.out.println("수량: " + this.cnt);
		System.out.println("가격: " + this.price);
	}
}
