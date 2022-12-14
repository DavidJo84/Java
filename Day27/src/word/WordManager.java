package word;

import java.util.ArrayList;
import java.util.Scanner;

import DAO_DTO.WordMean_DAO;
import DAO_DTO.WordMean_DTO;

public class WordManager {
	WordMean_DAO wdao;
	Scanner in = new Scanner(System.in);
	// private HashMap<String, WordMean> word = null;

	public WordManager(WordMean_DAO wdao) {
		this.wdao = wdao;
		for (;;) {
			menu();
			System.out.println("메뉴를 선택해주세요 ");
			String selMenu = in.nextLine();
			if (selMenu.equals("1")) {
				addWord();
			} else if (selMenu.equals("2")) {
				delWord();
//			} else if (selMenu.equals("3")) {
//				searchWord();
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
		WordMean_DTO wdto = new WordMean_DTO();
		System.out.println("수정할 영단어를 입력해주세요. ");
		String modWord = in.nextLine();
//
//		if (word.get(modWord) != null) {
		System.out.println("수정할 뜻을 입력해주세요. ");
		String modMean = in.nextLine();
		System.out.println("중요도를 상/중/하로 입력하세요. ");
		String imp = in.nextLine();
		System.out.println("코멘트를 작성하세요. ");
		String comment = in.nextLine();
		if (imp.equals("상") || imp.equals("중") || imp.equals("하")) {
			wdto.setEng(modWord);
			wdto.setMean(modMean);
			wdto.setImp(imp);
			wdto.setComment(comment);

			wdao.modyWord(wdto);
			System.out.println(modWord + "(이/가) 수정되었습니다. ");
		} else {
			System.out.println("잘못된 입력입니다.");
		}
//		} else {
//			System.out.println(modWord + " 단어가 없습니다. ");
//		}
	}

//
	private void allDelWord() {
		System.out.println("정말로 삭제하시겠습니까?(Y/N)");
		String yn = in.nextLine();
		yn.toLowerCase();
		if (yn.equals("y")) {
			wdao.allDeleteWord();
			System.out.println("모든 단어가 삭제되었습니다.");
		} else {
			System.out.println("이전 메뉴로 돌아갑니다. ");
		}
	}

//
	private void showWord() {
		ArrayList<WordMean> wList = wdao.allSelect();
		System.out.println("등록된 단어의 갯수는 " + wList.size() + "개 입니다.");
		for (WordMean i : wList) {
			i.prt();
		}
	}

//
//	private void searchWord() {
//
//		for (;;) {
//			System.out.println("1. 영단어로 검색 ");
//			System.out.println("2. 뜻으로 검색 ");
//			System.out.println("3. 중요도로 검색 ");
//			System.out.println("4. 이전메뉴 ");
//			System.out.println("메뉴를 선택해주세요 ");
//			String selMenu = in.nextLine();
//			if (selMenu.equals("1")) {
//				searchEnWord();
//			} else if (selMenu.equals("2")) {
//				serchMeanWord();
//			} else if (selMenu.equals("3")) {
//				serchImpWord();
//			} else if (selMenu.equals("4")) {
//				break;
//			} else {
//				System.out.println("잘못된 입력입니다.");
//			}
//		}
//	}
//
//	private void serchImpWord() {
//		System.out.println("검색할 영단어의 중요도를 상/중/하로 입력해주세요 ");
//		String searchImp = in.nextLine();
//		boolean flag = true;
//		for (Entry<String, WordMean> entry : word.entrySet()) {
//			if (entry.getValue().getImp().equals(searchImp)) {
//				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
//						+ ")" + entry.getValue().getComment());
//				flag = false;
//			}
//		}
//		if (flag) {
//			System.out.println("중요도 " + searchImp + "(은/는) 없습니다. ");
//		}
//	}
//
//	private void serchMeanWord() {
//		System.out.println("검색할 영단어의 뜻을 입력해주세요 ");
//		String searchMean = in.nextLine();
//		boolean flag = true;
//		for (Entry<String, WordMean> entry : word.entrySet()) {
//			if (searchMean.equals(entry.getValue().getMean())) {
//				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
//						+ ")" + entry.getValue().getComment());
//				flag = false;
//			}
//		}
//		if (flag) {
//			System.out.println(searchMean + "의 뜻을 가진 단어가 없습니다. ");
//		}
//	}
//
//	private void searchEnWord() {
//		System.out.println("검색할 영단어를 입력해주세요 ");
//		String searchEn = in.nextLine();
//		boolean flag = true;
//		for (Entry<String, WordMean> entry : word.entrySet()) {
//			if (searchEn.equals(entry.getKey())) {
//				System.out.println(entry.getKey() + ": " + entry.getValue().getMean() + " (" + entry.getValue().getImp()
//						+ ")" + entry.getValue().getComment());
//				flag = false;
//			}
//		}
//		if (flag) {
//			System.out.println(searchEn + " 단어가 없습니다. ");
//		}
//	}
//
	private void delWord() {
		WordMean_DTO wdto = new WordMean_DTO();
		System.out.println("삭제할 영단어를 입력하세요. ");
		String delWord = in.nextLine();
		wdto.setEng(delWord);
		wdao.deleteWord(wdto);
		System.out.println(delWord + "(이/가) 삭제되었습니다. ");

//		if (word.get(delWord) != null) {
//			word.remove(delWord);
//			System.out.println(delWord + "(이/가) 삭제되었습니다.  ");
//		} else {
//			System.out.println(delWord + " 단어가 없습니다. ");
//		}
	}

	private void addWord() {
		WordMean_DTO wdto = new WordMean_DTO();
		// WordMean newWordMean = new WordMean();
		System.out.println("추가할 영단어를 입력하새요 ");
		String newWord = in.nextLine();
		wdto.setEng(newWord);
		if(wdao.chkWord(wdto)) {
			System.out.println("영단어의 뜻을 입력하세요. ");
			String wordMean = in.nextLine();
			System.out.println("중요도를 상/중/하로 입력하세요. ");
			String imp = in.nextLine();
			System.out.println("코멘트를 작성하세요. ");
			String comment = in.nextLine();
			if (imp.equals("상") || imp.equals("중") || imp.equals("하")) {
				
				wdto.setMean(wordMean);
				wdto.setImp(imp);
				wdto.setComment(comment);

				wdao.insertWord(wdto);
				System.out.println(newWord + "(이/가) 추가되었습니다.");
			} else {
				System.out.println("잘못된 입력입니다.");
			}
		}else{
			System.out.println(newWord + "(이/가) 있습니다.");
		}
		// boolean flag = true;
//		for (Entry<String, WordMean> entry : word.entrySet()) {
//			if (newWord.equals(entry.getKey())) {
//				System.out.println(entry.getKey() + "단어가 이미 있습니다.  ");
//				flag = false;
//			}
//		}
//		if (flag) {
		
//		}
	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. 단어추가 ");
		System.out.println("2. 단어삭제 ");
//		System.out.println("3. 단어검색 ");
		System.out.println("4. 단어수정 ");
		System.out.println("5. 전체보기 ");
		System.out.println("6. 전체삭제 ");
		System.out.println("7. 이전메뉴 ");
	}
}