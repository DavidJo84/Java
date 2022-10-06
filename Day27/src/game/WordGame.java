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
			System.out.println("메뉴를 선택해주세요");
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