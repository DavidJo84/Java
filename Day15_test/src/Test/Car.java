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
		if (f.equals("경유") || f.equals("가솔린") || f.equals("LPG") || 
				f.equals("하이브리드") || f.equals("전기")|| f.equals("수소")) {
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
		System.out.println("자동차명:" + name + ", 주유타입:" + fuel + ", 년식:" + year + ", 색상:" + color);
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
