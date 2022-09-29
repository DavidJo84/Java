package test;

import java.util.HashMap;
import java.util.Scanner;

public class MainMenu {
	private HashMap<String, WordMean> word = new HashMap<>();
	private HashMap<String, WrongWord> wrongWordList = new HashMap<>();
	
	Scanner in = new Scanner(System.in);

	MainMenu() {
		for (;;) {
			System.out.println("1. 단어관리");
			System.out.println("2. 단어게임");
			System.out.println("3. 프로그램 종료");
			System.out.println("메뉴를 선택해주세요");

			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				new WordManager(word);
			} else if (selMenu.equals("2")) {
				if (word.size() > 0) {
					new WordGame(word, wrongWordList);
				} else {
					System.out.println("단어장에 단어를 추가해주세요.");
				}
			} else if (selMenu.equals("3")) {
				break;
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}
	}
}