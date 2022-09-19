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
		System.out.println("아이디: "+id+", 수량: "+cnt+", 가격: "+price);
	}
	
	public void proInput(String b, int c, int d) {
		id=b;
		cnt=c;
		price=d;
	}

}
