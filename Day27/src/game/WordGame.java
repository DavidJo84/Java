package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import DAO_DTO.WordMean_DAO;
import word.WordMean;
import word.WrongWord;

public class WordGame {
	Scanner in = new Scanner(System.in);
	WordMean_DAO wdao;
	public WordGame(ArrayList<WordMean> wList, HashMap<String, WrongWord> wrongWordList) {
		for (;;) {
			menu();
			System.out.println("�޴��� �������ּ���");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				new MeanGame(wList, wrongWordList);
			} else if (selMenu.equals("2")) {
				new EnWordGame(wList, wrongWordList);
			} else if (selMenu.equals("3")) {
				new RanGame(wList, wrongWordList);
			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void menu() {
		System.out.println("1. ������ ���ܾ� ���߱� ");
		System.out.println("2. ���ܾ�� �� ���߱� ");
		System.out.println("3. �������� ���߱� ");
		System.out.println("4. �����޴� ");
	}
}