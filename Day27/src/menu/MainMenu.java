package menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import DAO_DTO.WordMean_DAO;
import game.WordGame;
import word.WordManager;
import word.WordMean;
import word.WrongWord;

public class MainMenu {
	WordMean_DAO wdao = new WordMean_DAO();
	private ArrayList<WordMean> wList = wdao.allSelect();
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
				new WordManager(wdao);
			} else if (selMenu.equals("2")) {
				if (wList.size() > 0) {
					new WordGame(wList, wrongWordList);
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