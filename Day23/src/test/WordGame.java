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
		System.out.println("�� ������ " + word.size() + "�� �Դϴ�.");
		System.out.println("������ �����ϰ� ������ 100�� �Է����ּ���.");
		System.out.println("���͸� ġ�� ������ �����մϴ�.");
		in.nextLine();

		startGame();
		endGame();
	}

	private void endGame() {
		System.out.println("���� ����: " + point + "��");
		for (Entry<String, WrongWord> entry : wrongWordList.entrySet()) {
			System.out.println("Ʋ���ܾ�: " + entry.getKey() + " ����: " + entry.getValue().getWrongMean() + " Ʋ��Ƚ��: "
					+ entry.getValue().getWrongCnt());
		}
		System.out.println();
	}

	private void startGame() {
		for (Entry<String, WordMean> entry : word.entrySet()) {
			System.out.println("---------------");
			if (wrongWordList.get(entry.getKey()) != null && wrongWordList.get(entry.getKey()).getWrongCnt() > 2) {
				System.out.println(wrongWordList.get(entry.getKey()).getWrongCnt() + "�� Ʋ�� �ܾ�(��������)");
			}
			System.out.println(entry.getValue().getMean());
			System.out.println("�� ���� ���� ���ܾ��?");
			String correct = in.nextLine();
			if (entry.getKey().equals(correct)) {
				System.out.println("�����Դϴ�.");
				point += 10;
			} else {
				if (wrongWordList.get(entry.getKey()) != null) {
					System.out.println("�����Դϴ�.");
					wrongWordList.get(entry.getKey()).setWrongMean(correct);
					wrongWordList.get(entry.getKey()).plusCnt();
				} else {
					WrongWord newWrongWord = new WrongWord();
					System.out.println("�����Դϴ�.");
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
