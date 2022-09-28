package test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordGame {
	private HashMap<String, WordMean> word = null;
	private HashMap<String, WrongWord> wrongWordList = null;
	Scanner in = new Scanner(System.in);
	private int point = 0;

	WordGame(HashMap<String, WordMean> word, HashMap<String, WrongWord> wrongWordList) {
		this.word = word;
		this.wrongWordList = wrongWordList;
		System.out.println("총 문제는 " + word.size() + "개 입니다.");
		System.out.println("게임을 종료하고 싶으면 100을 입력해주세요.");
		System.out.println("엔터를 치면 게임을 시작합니다.");
		in.nextLine();

		startGame();
		endGame();
	}

	private void endGame() {
		System.out.println("최종 점수: " + point + "점");
		for (Entry<String, WrongWord> entry : wrongWordList.entrySet()) {
			System.out.println("틀린단어: " + entry.getKey() + " 오답: " + entry.getValue().getWrongMean() + " 틀린횟수: "
					+ entry.getValue().getWrongCnt());
		}
		System.out.println();
	}

	private void startGame() {
		for (Entry<String, WordMean> entry : word.entrySet()) {
			System.out.println("---------------");
			if (wrongWordList.get(entry.getKey()) != null && wrongWordList.get(entry.getKey()).getWrongCnt() > 2) {
				System.out.println(wrongWordList.get(entry.getKey()).getWrongCnt() + "번 틀린 단어(오답조심)");
			}
			System.out.println(entry.getValue().getMean());
			System.out.println("위 뜻을 가진 영단어는?");
			String correct = in.nextLine();
			if (entry.getKey().equals(correct)) {
				System.out.println("정답입니다.");
				point += 10;
			} else {
				if (wrongWordList.get(entry.getKey()) != null) {
					System.out.println("오답입니다.");
					wrongWordList.get(entry.getKey()).setWrongMean(correct);
					wrongWordList.get(entry.getKey()).plusCnt();
				} else {
					WrongWord newWrongWord = new WrongWord();
					System.out.println("오답입니다.");
					newWrongWord.setWrongMean(correct);
					newWrongWord.plusCnt();
					wrongWordList.put(entry.getKey(), newWrongWord);
				}
			}
			if (correct.equals("100")) {
				break;
			}
		}
	}
}
