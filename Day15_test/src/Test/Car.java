package Test;

public class Car {
	String name;
	String fuel;
	int year;
	String color;
	int mileage;

	public void inName(String n) {
		name = n;
	}

	public boolean inFuel(String f) {
		if (f.equals("����") || f.equals("���ָ�") || f.equals("LPG") || 
				f.equals("���̺긮��") || f.equals("����")|| f.equals("����")) {
			fuel = f;
			return true;
		}
		return false;
	}

	public void inYearColor(int y, String c) {
		year = y;
		color = c;
	}

	public String chkFuel() {
		return fuel;
	}

	public void carPrt() {
		System.out.println("�ڵ�����:" + name + ", ����Ÿ��:" + fuel + ", ���:" + year + ", ����:" + color);
		;
	}

	public int chkMileage(int m) {
		return mileage + m;
	}

	public int chkColor(String C) {
		if (C.equals(color)) {
			return 1;
		}
		return -1;
	}

}
