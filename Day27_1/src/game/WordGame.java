package game;

import java.util.HashMap;
import java.util.Scanner;

import word.WordMean;
import word.WrongWord;

public class WordGame {
	Scanner in = new Scanner(System.in);

	public WordGame(HashMap<String, WordMean> word, HashMap<String, WrongWord> wrongWordList) {
		for (;;) {
			menu();
			System.out.println("�޴��� �������ּ���");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				new MeanGame(word, wrongWordList);
			} else if (selMenu.equals("2")) {
				new EnWordGame(word, wrongWordList);
			} else if (selMenu.equals("3")) {
				new RanGame(word, wrongWordList);
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