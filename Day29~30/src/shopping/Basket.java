package shopping;

import java.util.Date;

public class Basket {
	private String gid;
	private String gname;
	private String selName;
	private int gprice;
	private Date buyDate;
	private int buyCnt;
	private String id;
	private String addr;

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getSelName() {
		return selName;
	}

	public void setSelName(String selName) {
		this.selName = selName;
	}

	public int getGprice() {
		return gprice;
	}

	public void setGprice(int gprice) {
		this.gprice = gprice;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getBuyCnt() {
		return buyCnt;
	}

	public void setBuyCnt(int buyCnt) {
		this.buyCnt = buyCnt;
	}
	
	public void prt() {
		System.out.println("-----------");
		System.out.println("��ǰID: " + gid);
		System.out.println("��ǰ��: " + gname);
		System.out.println("��ǰ����: " + gprice);
		System.out.println("���ż���: " + buyCnt);
		System.out.println("�Ǹ��ڸ�: " + selName);
		System.out.println("������: " + buyDate);
		System.out.println("�����: " + addr);
	}

}
