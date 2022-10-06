package memberMGR;

public class Member {
	private String id;
	private String name;
	private String pass;
	private String addr;
	private int point;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public void prt() {
		System.out.println("-----------");
		System.out.println("ID: " + id);
		System.out.println("PW: " + pass);
		System.out.println("이름: " + name);
		System.out.println("주소: " + addr);
		System.out.println("포인트: " + point);
	}

}
