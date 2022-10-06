package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Map.Entry;

import word.WordMean;
import word.WrongWord;

public class MeanGame {
	private ArrayList<WordMean> wList = null;
	private HashMap<String, WrongWord> wrongWordList = null;
	Scanner in = new Scanner(System.in);
	private int point = 0;
	private int cnt = 0;
	private ArrayList<String> chkWord = new ArrayList<>();

	MeanGame(ArrayList<WordMean> wList, HashMap<String, WrongWord> wrongWordList) {
		this.wList = wList;
		this.wrongWordList = wrongWordList;
		System.out.println("�� ������ " + wList.size() + "�� �Դϴ�.");
		System.out.println("��� ������ ���߰�");
		System.out.println("100�� �Է��ϸ� ������ ����˴ϴ�.");
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
		for (;;) {
			boolean flag = true;
			Random r = new Random();
			int rIdx = r.nextInt(wList.size());
			String rWord = wList.get(rIdx).getEng();

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
					System.out.println(wrongWordList.get(rWord).getWrongCnt() + "�� Ʋ�� �ܾ�(��������)");
				}
				if (cnt > 2) {
					System.out.println("�������� " + cnt + "�� Ʋ�Ƚ��ϴ�. �������ּ���. ");
				}
				System.out.println(wList.get(rIdx).getMean());

				System.out.println("�� ���� ���� ���ܾ��?");
				String correct = in.nextLine();
				if (rWord.equals(correct)) {
					chkWord.add(rWord);
					System.out.println("�����Դϴ�.");
					point += 10;
					cnt = 0;
				} else {
					if (wrongWordList.get(rWord) != null) {
						System.out.println("�����Դϴ�.");
						wrongWordList.get(rWord).setWrongMean(correct);
						wrongWordList.get(rWord).plusCnt();

					} else {
						WrongWord newWrongWord = new WrongWord();
						System.out.println("�����Դϴ�.");
						newWrongWord.setWrongMean(correct);
						newWrongWord.plusCnt();
						wrongWordList.put(rWord, newWrongWord);
					}
					cnt++;
				}
				if (correct.equals("100") || chkWord.size() == wList.size()) {
					break;
				}
			}
		}

	}
}
