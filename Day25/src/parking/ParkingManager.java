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
			System.out.println("1. �ڵ������");
			System.out.println("2. ���������ü����");
			System.out.println("3. �ڵ�����ȸ");
			System.out.println("4. ���α׷�����");
			System.out.println("�޴��� �������ּ���");

			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				for (;;) {
					System.out.println("--------------" );
					System.out.println("1. ����");
					System.out.println("2. ������");
					System.out.println("3. ������");
					System.out.println("4. �����޴�");
					System.out.println("�޴��� �������ּ���");

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
						System.out.println("�߸��� �Է��Դϴ�.");
					}
				}

			} else if (selMenu.equals("2")) {
				parkPrice();
			} else if (selMenu.equals("3")) {
				searchCar();
			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void searchCar() {
		System.out.println("--------------" );
		System.out.println("��ȸ�� ������ȣ�� �Է��ϼ���.");
		String carNum = in.nextLine();
		boolean flag = true;
		for (CarInfo c : cList) {
			if (c.carNum.equals(carNum)) {
				c.prt();
				flag = false;
			}
		}
		if (flag) {
			System.out.println("������ȣ " + carNum + "�� �����ϴ�.");
		}
	}

	private void parkPrice() {
		for (CarInfo c : cList) {
			System.out.println("--------------" );
			System.out.println("������ȣ: " + c.getCarNum());
			System.out.println("������� " );
			c.p_prt();
		}
	}

	private void addCar() {
		System.out.println("--------------" );
		System.out.println("�����̸��� �Է��ϼ���.");
		String name = in.nextLine();
		car.setName(name);
		System.out.println("������ȣ�� �Է��ϼ���.");
		String carNum = in.nextLine();
		car.setCarNum(carNum);
		System.out.println("�����ؿ���(Y/N)");
		String clean = in.nextLine();
		clean = clean.toUpperCase();
		car.setClean(clean);
		car.discount();
		System.out.println("���� �������� ����ΰ���?");
		int family = in.nextInt();
		in.nextLine();
		car.setFamily(family);
		car.plusDis();
		System.out.println("������� �Է��ϼ���.");
		System.out.println("��)20220901");
		String joinDate = in.nextLine();
		car.setJoinDate(joinDate);
		car.setpList();

		cList.add(car);
	}
}
