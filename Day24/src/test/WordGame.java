package test;

import java.util.HashMap;
import java.util.Scanner;

public class WordGame {
	Scanner in = new Scanner(System.in);

	WordGame(HashMap<String, WordMean> word, HashMap<String, WrongWord> wrongWordList) {
		for (;;) {
			menu();
			System.out.println("메뉴를 선택해주세요");
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
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void menu() {
		System.out.println("1. 뜻으로 영단어 맞추기 ");
		System.out.println("2. 영단어로 뜻 맞추기 ");
		System.out.println("3. 랜덤으로 맞추기 ");
		System.out.println("4. 이전메뉴 ");
	}
}