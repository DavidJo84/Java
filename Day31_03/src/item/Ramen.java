package item;


public class Ramen implements Item_INF{
	String kind = "���";
	String comment = "���� ���� ������ ��, ������ ����� �ϼ�";
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
		System.out.println("�����Ͻ� �ݾ��� "+ price * cnt + "�� �Դϴ�.");
		
	}

	@Override
	public void showInfo() {
		System.out.println("------------");
		System.out.println(kind);
		System.out.println(name);
		System.out.println("����: "+ price);
		System.out.println("����: "+ cnt);
		
	}

	@Override
	public void showcomment() {
		System.out.println(comment);
		
	}

}
