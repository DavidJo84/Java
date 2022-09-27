package test;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class MainMenu {
	Scanner in = new Scanner(System.in);
	HashMap<String, WordMean> word = new HashMap<>();

	MainMenu() {

		for (;;) {
			menu();
			System.out.println("메뉴를 선택해주세요 ");
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
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void modWord() {
		System.out.println("수정할 영단어를 입력해주세요 ");
		String modWord = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (modWord.equals(entry.getKey())) {
				System.out.println("수정할 뜻을 입력해주세요 ");
				String modMean = in.nextLine();
				System.out.println("중요도를 입력하새요 ");
				String imp = in.nextLine();
				entry.getValue().setMean(modMean);
				entry.getValue().setImp(imp);
				word.put(modWord, entry.getValue());
				System.out.println(entry.getKey() + "가 수정되었습니다. ");
				flag = false;
			}
		}
		if (flag) {
			System.out.println(modWord + " 단어가 없습니다. ");
		}

	}

	private void allDelWord() {
		System.out.println("정말로 삭제하시겠습니까?(Y/N)");
		String yn = in.nextLine();
		yn.toLowerCase();
		if (yn.equals("y")) {
			word.clear();
			System.out.println("모든 단어가 삭제되었습니다.");

		} else {
			System.out.println("이전 메뉴로 돌아갑니다. ");
		}
	}

	private void showWord() {
		for (String i : word.keySet()) {
			System.out.println(i + ": " + word.get(i).getMean() + " (" + word.get(i).getImp() + ")");
		}

	}

	private void searchWord() {

		for (;;) {
			System.out.println("1. 영단어로 검색 ");
			System.out.println("2. 뜻으로 검색 ");
			System.out.println("3. 중요도로 검색 ");
			System.out.println("4. 이전메뉴 ");
			System.out.println("메뉴를 선택해주세요 ");
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
				System.out.println("잘못된 입력입니다.");
			}
		}
	}

	private void serchImpWord() {
		System.out.println("검색할 영단어의 중요도를 상/중/하로 입력해주세요 ");
		String searchImp = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (entry.getValue().getImp().equals(searchImp)) {
				System.out.println(
						entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp() + ")");
				flag = false;
			}
		}
		if (flag) {
			System.out.println("중요도 " + searchImp + "는 없습니다. ");
		}

	}

	private void serchMeanWord() {
		System.out.println("검색할 영단어의 뜻을 입력해주세요 ");
		String searchMean = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (searchMean.equals(entry.getValue().getMean())) {
				System.out.println(
						entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp() + ")");
				flag = false;
			}
		}
		if (flag) {
			System.out.println(searchMean + "의 뜻을 가진 단어가 없습니다. ");
		}
	}

	private void searchEnWord() {
		System.out.println("검색할 영단어를 입력해주세요 ");
		String searchEn = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (searchEn.equals(entry.getKey())) {
				System.out.println(
						entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp() + ")");
				flag = false;
			}
		}
		if (flag) {
			System.out.println(searchEn + " 단어가 없습니다. ");
		}
	}

	private void delWord() {
		System.out.println("삭제할 영단어를 입력하새요 ");
		String delWord = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (delWord.equals(entry.getKey())) {
				word.remove(delWord);
				System.out.println(entry.getKey() + "가 삭제되었습니다.  ");
				flag = false;
			}
		}
		if (flag) {
			System.out.println(delWord + " 단어가 없습니다. ");
		}

	}

	private void addWord() {
		WordMean newWordMean = new WordMean();
		System.out.println("추가할 영단어를 입력하새요 ");
		String newWord = in.nextLine();
		boolean flag = true;
		for (Entry<String, WordMean> entry : word.entrySet()) {
			if (newWord.equals(entry.getKey())) {
				System.out.println(entry.getKey() + "단어가 이미 있습니다.  ");
				flag = false;
			}
		}
		if (flag) {
			System.out.println("영단어의 뜻을 입력하새요 ");
			String wordMean = in.nextLine();
			System.out.println("중요도를 입력하새요 ");
			String imp = in.nextLine();
			newWordMean.setMean(wordMean);
			newWordMean.setImp(imp);
			word.put(newWord, newWordMean);
		}
	}

	private void menu() {
		System.out.println("1. 단어추가 ");
		System.out.println("2. 단어삭제 ");
		System.out.println("3. 단어검색 ");
		System.out.println("4. 단어수정 ");
		System.out.println("5. 전체보기 ");
		System.out.println("6. 전체삭제 ");
		System.out.println("7. 프로그램종료 ");

	}
}
