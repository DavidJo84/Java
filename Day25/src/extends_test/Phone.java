package extends_test;

public class Phone {
	private String name;
	private int cnt;
	private int price;
	
	public void call() {
		System.out.println("�ѷ����");
	}
	
	public void answer() {
		System.out.println("��������");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
