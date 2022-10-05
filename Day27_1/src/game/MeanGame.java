package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

import word.WordMean;
import word.WrongWord;

public class MeanGame {
	private HashMap<String, WordMean> word = null;
	private HashMap<String, WrongWord> wrongWordList = null;
	Scanner in = new Scanner(System.in);
	private int point = 0;
	private int cnt = 0;
	private ArrayList<String> randomWord = new ArrayList<>();
	private ArrayList<String> chkWord = new ArrayList<>();

	MeanGame(HashMap<String, WordMean> word, HashMap<String, WrongWord> wrongWordList) {
		this.word = word;
		this.wrongWordList = wrongWordList;
		randomWord.addAll(word.keySet());
		System.out.println("총 문제는 " + word.size() + "개 입니다.");
		System.out.println("모든 문제를 맞추거");
		System.out.println("100을 입력하면 게임이 종료됩니다.");
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
		for (;;) {
			boolean flag = true;
			Random r = new Random();
			int rIdx = r.nextInt(randomWord.size());
			String rWord = randomWord.get(rIdx);

			if (chkWord.size() != 0) {
				for (int i = 0; i < chkWord.size(); i++) {
					if (rWord.equals(chkWord.get(i))) {
						flag = false;
					}
				}
			}

			if (flag) {
				System.out.println("---------------");
				if (wrongWordList.get(rWord) != null && wrongWordList.get(rWord).getWrongCnt() > 2) {
					System.out.println(wrongWordList.get(rWord).getWrongCnt() + "번 틀린 단어(오답조심)");
				}
				if (cnt > 2) {
					System.out.println("연속으로 " + cnt + "개 틀렸습니다. 집중해주세요. ");
				}
				System.out.println(word.get(rWord).getMean());

				System.out.println("위 뜻을 가진 영단어는?");
				String correct = in.nextLine();
				if (rWord.equals(correct)) {
					chkWord.add(rWord);
					System.out.println("정답입니다.");
					point += 10;
					cnt = 0;
				} else {
					if (wrongWordList.get(rWord) != null) {
						System.out.println("오답입니다.");
						wrongWordList.get(rWord).setWrongMean(correct);
						wrongWordList.get(rWord).plusCnt();

					} else {
						WrongWord newWrongWord = new WrongWord();
						System.out.println("오답입니다.");
						newWrongWord.setWrongMean(correct);
						newWrongWord.plusCnt();
						wrongWordList.put(rWord, newWrongWord);
					}
					cnt++;
				}
				if (correct.equals("100") || chkWord.size() == word.size()) {
					break;
				}
			}
		}

	}
}
