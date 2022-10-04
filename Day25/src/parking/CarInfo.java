package parking;

import java.util.ArrayList;

public abstract class CarInfo {
	ArrayList<Integer> pList = new ArrayList<>();
	String name;
	String clean;
	String carNum;
	int price;
	int dPrice;
	int family;//����������
	String joinDate;//�����
	String today="20220930";//�����ȸ��
	
	
	public void setpList() {
		int j_month = Integer.parseInt(joinDate.substring(4, 6));
		int s_month = Integer.parseInt(today.substring(4, 6));
		int m_price = (s_month-j_month);
		int j_day = Integer.parseInt(joinDate.substring(6));
		int s_day = Integer.parseInt(today.substring(6));
		int d_price = (s_day-j_day-1);
		if(m_price==0) {
			pList.add(0,d_price*dPrice);
		}else if(m_price == 1){
			pList.add(0,(30-j_day-1)*dPrice);
		}else {
			pList.add(0,(30-j_day-1)*dPrice);
			for(int i =1; i<m_price; i++) {
				pList.add(price);
			}
		}
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price, int dPrice) {
		this.price = price;
		this.dPrice = dPrice;
	}

	public CarInfo() {

	}
	
	public abstract void plusDis();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public String getClean() {
		return clean;
	}

	public void setClean(String clean) {
		this.clean = clean;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public int getFamily() {
		return family;
	}
	public void setFamily(int family) {
		this.family = family;
	}
	
	public void prt() {
		System.out.println("������ȣ: "+ carNum);
		System.out.println("������: "+ name);
		System.out.println("������ ����: "+ clean);
		System.out.println("����������: "+ family + "��");
		System.out.println("�������: ");
		p_prt();
		System.out.println("�����: "+ joinDate);
		
	}
	
	public void discount() {
		if(clean.equals("Y")) {
			price = price/2;
			dPrice = dPrice/2;
		}
	}
	
	public void p_prt() {
		for(int i = 0; i<pList.size(); i++) {
			System.out.println(i+Integer.parseInt(joinDate.substring(4, 6)) + "�� ���: " + pList.get(i) + "��");
		}
	}

}
