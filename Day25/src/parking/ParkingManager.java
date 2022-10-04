package parking;

import java.util.ArrayList;
import java.util.Scanner;

public class ParkingManager {
	CarInfo car;
	Scanner in = new Scanner(System.in);
	ArrayList<CarInfo> cList = new ArrayList<>();

	ParkingManager() {

		for (;;) {
			System.out.println("--------------" );
			System.out.println("1. 자동차등록");
			System.out.println("2. 주차요금전체보기");
			System.out.println("3. 자동차조회");
			System.out.println("4. 프로그램종료");
			System.out.println("메뉴를 선택해주세요");

			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				for (;;) {
					System.out.println("--------------" );
					System.out.println("1. 경차");
					System.out.println("2. 소형차");
					System.out.println("3. 대형차");
					System.out.println("4. 이전메뉴");
					System.out.println("메뉴를 선택해주세요");

					String selMenu2 = in.nextLine();
					if (selMenu2.equals("1")) {
						car = new S_car();
						car.setPrice(20000, 700);
						addCar();
					} else if (selMenu2.equals("2")) {
						car = new M_car();
						car.setPrice(40000, 1500);
						addCar();
					} else if (selMenu2.equals("3")) {
						car = new L_car();
						car.setPrice(70000, 2500);
						addCar();
					} else if (selMenu2.equals("4")) {
						break;
					} else {
						System.out.println("잘못된 입력입니다.");
					}
				}

			} else if (selMenu.equals("2")) {
				parkPrice();
			} else if (selMenu.equals("3")) {
				searchCar();
			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void searchCar() {
		System.out.println("--------------" );
		System.out.println("조회할 차량번호를 입력하세요.");
		String carNum = in.nextLine();
		boolean flag = true;
		for (CarInfo c : cList) {
			if (c.carNum.equals(carNum)) {
				c.prt();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("차량번호 " + carNum + "이 없습니다.");
		}
	}

	private void parkPrice() {
		for (CarInfo c : cList) {
			System.out.println("--------------" );
			System.out.println("차량번호: " + c.getCarNum());
			System.out.println("주차요금 " );
			c.p_prt();
		}
	}

	private void addCar() {
		System.out.println("--------------" );
		System.out.println("차량이름을 입력하세요.");
		String name = in.nextLine();
		car.setName(name);
		System.out.println("차량번호를 입력하세요.");
		String carNum = in.nextLine();
		car.setCarNum(carNum);
		System.out.println("저공해여부(Y/N)");
		String clean = in.nextLine();
		clean = clean.toUpperCase();
		car.setClean(clean);
		car.discount();
		System.out.println("가족 구성원은 몇명인가요?");
		int family = in.nextInt();
		in.nextLine();
		car.setFamily(family);
		car.plusDis();
		System.out.println("등록일을 입력하세요.");
		System.out.println("예)20220901");
		String joinDate = in.nextLine();
		car.setJoinDate(joinDate);
		car.setpList();

		cList.add(car);
	}
}
