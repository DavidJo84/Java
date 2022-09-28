package test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordManager {
	Scanner in = new Scanner(System.in);
	private HashMap<String, WordMean> word = null;

	WordManager(HashMap<String, WordMean> word) {
		this.word = word;
		for (;;) {
			menu();
			System.out.println("�޴��� �������ּ��� ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addWord();
			} else if (selMenu.equals("2")) {
				delWord();
			} else if (selMenu.equals("3")) {
				searchWord();
			} else if (selMenu.equals("4")) {
				modWord();
			} else if (selMenu.equals("5")) {
				showWord();
			} else if (selMenu.equals("6")) {
				allDelWord();
			} else if (selMenu.equals("7")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void modWord() {
		System.out.println("������ ���ܾ �Է����ּ���. ");
		String modWord = in.nextLine();

		if (word.get(modWord) != null) {
			System.out.println("������ ���� �Է����ּ���. ");
			String modMean = in.nextLine();
			System.out.println("�߿䵵�� ��/��/�Ϸ� �Է��ϼ���. ");
			String imp = in.nextLine();
			System.out.println("�ڸ�Ʈ�� �ۼ��ϼ���. ");
			String comment = in.nextLine();
			if (imp.equals("��") || imp.equals("��") || imp.equals("��")) {
				word.get(modWord).setMean(modMean);
				word.get(modWord).setImp(imp);
				word.get(modWord).setComment(comment);
				word.put(modWord, word.get(modWord));
				System.out.println(modWord + "(��/��) �����Ǿ����ϴ�. ");
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		} else {
			System.out.println(modWord + " �ܾ �����ϴ�. ");
		}
	}

	private void allDelWord() {
		System.out.println("������ �����Ͻðڽ��ϱ�?(Y/N)");
		String yn = in.nextLine();
		yn.toLowerCase();
		if (yn.equals("y")) {
			word.clear();
			System.out.println("��� �ܾ �����Ǿ����ϴ�.");

		} else {
			System.out.println("���� �޴��� ���ư��ϴ�. ");
		}
	}

	private void showWord() {
		System.out.println("��ϵ� �ܾ��� ������ " + word.size() + "�� �Դϴ�.");
		for (String i : word.keySet()) {
			System.out.println(
					i + ": " + word.get(i).getMean() + " (" + word.get(i).getImp() + ")" + word.get(i).getComment());
		}
	}

	private void searchWord() {

		for (;;) {
			System.out.println("1. ���ܾ�� �˻� ");
			System.out.println("2. ������ �˻� ");
			System.out.println("3. �߿䵵�� �˻� ");
			System.out.println("4. �����޴� ");
			System.out.println("�޴��� �������ּ��� ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				searchEnWord();
			} else if (selMenu.equals("2")) {
				serchMeanWord();
			} else if (selMenu.equals("3")) {
				serchImpWord();
			} else if (selMenu.equals("4")) {
				break;
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void serchImpWord() {
		System.out.println("�˻��� ���ܾ��� �߿䵵�� ��/��/�Ϸ� �Է����ּ��� ");
		String searchImp = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (entry.getValue().getImp().equals(searchImp)) {
				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
						+ ")" + entry.getValue().getComment());
				flag = false;
			}
		}
		if (flag) {
			System.out.println("�߿䵵 " + searchImp + "(��/��) �����ϴ�. ");
		}
	}

	private void serchMeanWord() {
		System.out.println("�˻��� ���ܾ��� ���� �Է����ּ��� ");
		String searchMean = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (searchMean.equals(entry.getValue().getMean())) {
				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
						+ ")" + entry.getValue().getComment());
				flag = false;
			}
		}
		if (flag) {
			System.out.println(searchMean + "�� ���� ���� �ܾ �����ϴ�. ");
		}
	}

	private void searchEnWord() {
		System.out.println("�˻��� ���ܾ �Է����ּ��� ");
		String searchEn = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (searchEn.equals(entry.getKey())) {
				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
						+ ")" + entry.getValue().getComment());
				flag = false;
			}
		}
		if (flag) {
			System.out.println(searchEn + " �ܾ �����ϴ�. ");
		}
	}

	private void delWord() {
		System.out.println("������ ���ܾ �Է��ϼ���. ");
		String delWord = in.nextLine();
		if (word.get(delWord) != null) {
			word.remove(delWord);
			System.out.println(delWord + "(��/��) �����Ǿ����ϴ�.  ");
		} else {
			System.out.println(delWord + " �ܾ �����ϴ�. ");
		}
	}

	private void addWord() {
		WordMean newWordMean = new WordMean();
		System.out.println("�߰��� ���ܾ �Է��ϻ��� ");
		String newWord = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (newWord.equals(entry.getKey())) {
				System.out.println(entry.getKey() + "�ܾ �̹� �ֽ��ϴ�.  ");
				flag = false;
			}
		}
		if (flag) {
			System.out.println("���ܾ��� ���� �Է��ϼ���. ");
			String wordMean = in.nextLine();
			System.out.println("�߿䵵�� ��/��/�Ϸ� �Է��ϼ���. ");
			String imp = in.nextLine();
			System.out.println("�ڸ�Ʈ�� �ۼ��ϼ���. ");
			String comment = in.nextLine();
			if (imp.equals("��") || imp.equals("��") || imp.equals("��")) {
				newWordMean.setMean(wordMean);
				newWordMean.setImp(imp);
				newWordMean.setComment(comment);
				word.put(newWord, newWordMean);
				System.out.println(newWord + "(��/��) �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void menu() {
		System.out.println("1. �ܾ��߰� ");
		System.out.println("2. �ܾ���� ");
		System.out.println("3. �ܾ�˻� ");
		System.out.println("4. �ܾ���� ");
		System.out.println("5. ��ü���� ");
		System.out.println("6. ��ü���� ");
		System.out.println("7. �����޴� ");
	}
}
