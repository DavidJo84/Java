package Market;

public class GoodsBasket {
	String name= null;
	int cnt= 0;
	int goodsPrice=0;
	
	public void plusCnt(int cnt) {
		this.cnt+=cnt;
	}
	public void sumPrice(int goodsPrice) {
		this.goodsPrice= cnt*goodsPrice;
	}
	public void prt() {
		System.out.println("����:"+name);
		System.out.println("����:"+cnt);
		System.out.println("����:"+goodsPrice);
	}
}
