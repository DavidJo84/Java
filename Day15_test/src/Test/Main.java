package Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car c = new Car();
		c.carPrt();
		c.inName("K5");
		c.carPrt();
		c.inFuel("���ָ�");
		c.inYearColor(2020, "black");
		c.carPrt();
		System.out.println(c.chkFuel());
		System.out.println(c.chkMileage(20));
		System.out.println(c.chkColor("black"));
		System.out.println(c.inFuel("����"));
		c.carPrt();
	}

}
