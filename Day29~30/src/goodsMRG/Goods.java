package goodsMRG;

import java.util.Date;

public class Goods {
	private String gid;
	private String gname;
	private String selName;
	private int gprice;
	private int gcnt;
	private Date gdate;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

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

	public int getGcnt() {
		return gcnt;
	}

	public void setGcnt(int gcnt) {
		this.gcnt = gcnt;
	}

	public Date getGdate() {
		return gdate;
	}

	public void setGdate(Date gdate) {
		this.gdate = gdate;
	}
	
	public void prt() {
		System.out.println("-----------");
		System.out.println("ID: " + gid);
		System.out.println("��ǰ��: " + gname);
		System.out.println("����: " + gprice);
		System.out.println("����: " + gcnt);
		System.out.println("�Ǹ��ڸ�: " + selName);
		System.out.println("�����: " + gdate);
	}

}
