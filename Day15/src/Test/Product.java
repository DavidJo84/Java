package Test;

public class Product {
	String id;
	int cnt=10;
	int price;

	public void priceInput(int a) {
		price=a;
	}
	
	public int proCnt() {
		return cnt;
	}
	
	public void proShow() {
		System.out.println("���̵�: "+id+", ����: "+cnt+", ����: "+price);
	}
	
	public void proInput(String b, int c, int d) {
		id=b;
		cnt=c;
		price=d;
	}

}
