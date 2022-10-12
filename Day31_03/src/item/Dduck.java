package item;


public class Dduck implements Item_INF {
	String kind = "떡볶이";
	String comment = "맛에 빠져서 하나 더먹으려니 없어졌네~~";
	String name;
	int price;
	int cnt;
	
	@Override
	public void insert(Item_DTO m) {
		this.name = m.getName();
		this.price = m.getPrice();
		this.cnt = m.getCnt();
		
	}

	@Override
	public void pay() {
		System.out.println("지불하실 금액은 "+ price * cnt + "원 입니다.");
		
	}

	@Override
	public void showInfo() {
		System.out.println("------------");
		System.out.println(kind);
		System.out.println(name);
		System.out.println("가격: "+ price);
		System.out.println("수량: "+ cnt);
		
	}

	@Override
	public void showcomment() {
		System.out.println(comment);
		
	}

}
