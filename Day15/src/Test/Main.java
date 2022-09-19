package Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.proShow();
		System.out.println("¼ö·®: "+p.proCnt());
		p.priceInput(1000);
		p.proShow();
		p.proInput("aaaa", 20, 2000);
		p.proShow();

	}

}
