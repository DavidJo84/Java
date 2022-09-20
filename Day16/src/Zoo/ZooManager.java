package Zoo;

import java.util.Scanner;

public class ZooManager {
	Animal[] aList = new Animal[10];
	Scanner in = new Scanner(System.in);

	ZooManager() {
		for (;;) {
			menu();
			String slt = in.nextLine();
			if (slt.equals("1")) {
				addAni();
			} else if (slt.equals("2")) {
				prtAni();
			} else if (slt.equals("3")) {
				updateAni();
			} else if (slt.equals("4")) {
				deleteAni();
			}else if(slt.equals("5")) {
				searchAni();
			}else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}

		}
	}

	private void deleteAni() {
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���");
		String a = in.nextLine();
		int aa = Integer.parseInt(a);
		if (aa < aList.length && aList[aa] != null) {

			System.out.println("���������� Ȯ���ϼ���");
			aList[aa].prt();
			System.out.println("���� ������ �³���?(Y/N)");
			String b = in.nextLine();
			b.toLowerCase();
			if (b.equals("y")) {
				aList[aa] = null;
				System.out.println(aList[aa] + "�� �����Ǿ����ϴ�.");
			} else {
				System.out.println("�޴��� ���ư��ϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

	private void updateAni() {
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���");
		String a = in.nextLine();
		int aa = Integer.parseInt(a);
		if (aa < aList.length && aList[aa] != null) {

			System.out.println("���������� Ȯ���ϼ���");
			aList[aa].prt();
			System.out.println("���� ������ �³���?(Y/N)");
			String b = in.nextLine();
			b.toLowerCase();
			if (b.equals("y")) {
				Animal newAnimal = inputAni();
				aList[aa] = newAnimal;
			} else {
				System.out.println("�޴��� ���ư��ϴ�.");
			}
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
	}

	private void prtAni() {
		for (int i = 0; i < aList.length; i++) {
			if (aList[i] != null) {
				System.out.println(i + "�� ����-------");
				aList[i].prt();
				System.out.println("------------");
			}
		}
	}

	private void addAni() {
		Animal newAnimal = inputAni();
		for (int i = 0; i < aList.length; i++) {
			if (aList[i] == null) {
				aList[i] = newAnimal;
				break;
			}

		}

	}

	private void menu() {
		System.out.println("1.�������");
		System.out.println("2.������ü����");
		System.out.println("3.��������");
		System.out.println("4.��������");
		System.out.println("5.�����˻�");

	}

	public Animal inputAni() {
		Animal newAnimal = new Animal();
		System.out.println("������ �Է�");
		String kind = in.nextLine();
		System.out.println("�����̸� �Է�");
		String name = in.nextLine();
		System.out.println("�������� �Է�");
		String food = in.nextLine();
		System.out.println("�������� �Է�");
		int age = in.nextInt();
		in.nextLine();
		System.out.println("�������� �Է�");
		String sick = in.nextLine();

		newAnimal.setAnimal(kind, name, food, age, sick);

		return newAnimal;
	}
	
	public void searchAni() {
//		System.out.println("�˻��� �Ӽ��� �����ϼ���.");
//		System.out.println("1.������");
//		System.out.println("2.�����̸�");
//		System.out.println("3.��������");
//		System.out.println("4.��������");
//		System.out.println("5.��������");
//		String a = in.nextLine();
//		
//		if(a.equals("1")) {
			
			System.out.println("�˻��� ������ �ļ��� �Է����ּ���");
		      String b = in.nextLine();
		      for(int i = 0; i < aList.length; i++) {
		         if(aList[i].food.equals(b)) {
		            aList[i].prt();
		         }
		         if(i == aList.length - 1) {
		            break;
		         }
		      }
//		}
	      
	   }

}
