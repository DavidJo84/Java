package Tr;

import java.util.Scanner;

public class Day03_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ����4. ������ �̼����� ���� 67�̴�. �̼����� ���� 0~30�̸� ����, 31~80�̸� ����
		// 81~150�̸� ���� 151�̻��� �ſ쳪���̶�� ��Ÿ���� ���α׷��� ���弼��
		int dust = 67;

		if (dust <= 30) {
			System.out.println("����");
		} else if (dust <= 80) {
			System.out.println("����");
		} else if (dust <= 150) {
			System.out.println("����");
		} else {
			System.out.println("�ſ쳪��");
		}

		// �޴��� �Է¹޾� 1���� �ݶ�,2���� ���̴�,3���� Ŀ��,4���� �꽺�� ���
		// �ݶ�� �ٽ� ������ �Է¹޾� 1���� ��ũ, 2���� ��� ���
		Scanner in = new Scanner(System.in); // ctrl+shift+o = �ڵ� import
		
		System.out.println("�޴��� �����ϼ���");

		int menu = in.nextInt();

		System.out.println(menu + "�� �Է��߽��ϴ�.");

		if (menu == 1) {
			System.out.println("�ݶ��� ������ �����ϼ���");

			int colaKind = in.nextInt();

			if (colaKind == 1) {
				System.out.println("��ũ");
			} else if (colaKind == 2) {
				System.out.println("���");
			}

		} else if (menu == 2) {
			System.out.println("���̴�");
		} else if (menu == 3) {
			System.out.println("Ŀ��");
		} else if (menu == 4) {
			System.out.println("�꽺");
		}

		// �� �� �� ū ���� ����ϼ���

		int a = 30;
		int b = 40;

		if (a > b) {
			System.out.println(a);
		} else if (b > a) {
			System.out.println(b);
		}
		in.close();
	}

}
