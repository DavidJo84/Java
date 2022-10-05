package menu;

import java.util.HashMap;
import java.util.Scanner;

import game.WordGame;
import word.WordManager;
import word.WordMean;
import word.WrongWord;

public class MainMenu {
	private HashMap<String, WordMean> word = new HashMap<>();
	private HashMap<String, WrongWord> wrongWordList = new HashMap<>();

	Scanner in = new Scanner(System.in);

	MainMenu() {
		for (;;) {
			System.out.println("1. �ܾ����");
			System.out.println("2. �ܾ����");
			System.out.println("3. ���α׷� ����");
			System.out.println("�޴��� �������ּ���");

			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				new WordManager(word);
			} else if (selMenu.equals("2")) {
				if (word.size() > 0) {
					new WordGame(word, wrongWordList);
				} else {
					System.out.println("�ܾ��忡 �ܾ �߰����ּ���.");
				}
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}
}