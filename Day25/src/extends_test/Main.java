package extends_test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamsongPhone sm1 = new SamsongPhone();
		sm1.setName("�ַ��� S22");
		sm1.setCnt(23);
		sm1.setPrice(120);
		System.out.println(sm1.getName());
		System.out.println("��� "+ sm1.getCnt()+"��");
		System.out.println("���� "+sm1.getPrice()+"��");
		sm1.call();
		
		SamsongPhone sm2 = new SamsongPhone();
		sm2.setName("�ַ��� ����2");
		sm2.setCnt(40);
		sm2.setPrice(150);
		sm2.answer();
		
		IcooPhone ic1= new IcooPhone();
		ic1.setName("������ 13");
		ic1.setCnt(44);
		ic1.setPrice(135);
		ic1.block();
		
		IcooPhone ic2= new IcooPhone();
		ic2.setName("������ 14");
		ic2.setCnt(54);
		ic2.setPrice(176);
		ic2.call();
		
	}

}
