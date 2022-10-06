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
			System.out.println("�޴��� �������ּ��� ");
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
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}
	}

	private void modWord() {
		WordMean_DTO wdto = new WordMean_DTO();
		System.out.println("������ ���ܾ �Է����ּ���. ");
		String modWord = in.nextLine();
//
//		if (word.get(modWord) != null) {
		System.out.println("������ ���� �Է����ּ���. ");
		String modMean = in.nextLine();
		System.out.println("�߿䵵�� ��/��/�Ϸ� �Է��ϼ���. ");
		String imp = in.nextLine();
		System.out.println("�ڸ�Ʈ�� �ۼ��ϼ���. ");
		String comment = in.nextLine();
		if (imp.equals("��") || imp.equals("��") || imp.equals("��")) {
			wdto.setEng(modWord);
			wdto.setMean(modMean);
			wdto.setImp(imp);
			wdto.setComment(comment);

			wdao.modyWord(wdto);
			System.out.println(modWord + "(��/��) �����Ǿ����ϴ�. ");
		} else {
			System.out.println("�߸��� �Է��Դϴ�.");
		}
//		} else {
//			System.out.println(modWord + " �ܾ �����ϴ�. ");
//		}
	}

//
	private void allDelWord() {
		System.out.println("������ �����Ͻðڽ��ϱ�?(Y/N)");
		String yn = in.nextLine();
		yn.toLowerCase();
		if (yn.equals("y")) {
			wdao.allDeleteWord();
			System.out.println("��� �ܾ �����Ǿ����ϴ�.");
		} else {
			System.out.println("���� �޴��� ���ư��ϴ�. ");
		}
	}

//
	private void showWord() {
		ArrayList<WordMean> wList = wdao.allSelect();
		System.out.println("��ϵ� �ܾ��� ������ " + wList.size() + "�� �Դϴ�.");
		for (WordMean i : wList) {
			i.prt();
		}
	}

//
//	private void searchWord() {
//
//		for (;;) {
//			System.out.println("1. ���ܾ�� �˻� ");
//			System.out.println("2. ������ �˻� ");
//			System.out.println("3. �߿䵵�� �˻� ");
//			System.out.println("4. �����޴� ");
//			System.out.println("�޴��� �������ּ��� ");
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
//				System.out.println("�߸��� �Է��Դϴ�.");
//			}
//		}
//	}
//
//	private void serchImpWord() {
//		System.out.println("�˻��� ���ܾ��� �߿䵵�� ��/��/�Ϸ� �Է����ּ��� ");
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
//			System.out.println("�߿䵵 " + searchImp + "(��/��) �����ϴ�. ");
//		}
//	}
//
//	private void serchMeanWord() {
//		System.out.println("�˻��� ���ܾ��� ���� �Է����ּ��� ");
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
//			System.out.println(searchMean + "�� ���� ���� �ܾ �����ϴ�. ");
//		}
//	}
//
//	private void searchEnWord() {
//		System.out.println("�˻��� ���ܾ �Է����ּ��� ");
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
//			System.out.println(searchEn + " �ܾ �����ϴ�. ");
//		}
//	}
//
	private void delWord() {
		WordMean_DTO wdto = new WordMean_DTO();
		System.out.println("������ ���ܾ �Է��ϼ���. ");
		String delWord = in.nextLine();
		wdto.setEng(delWord);
		wdao.deleteWord(wdto);
		System.out.println(delWord + "(��/��) �����Ǿ����ϴ�. ");

//		if (word.get(delWord) != null) {
//			word.remove(delWord);
//			System.out.println(delWord + "(��/��) �����Ǿ����ϴ�.  ");
//		} else {
//			System.out.println(delWord + " �ܾ �����ϴ�. ");
//		}
	}

	private void addWord() {
		WordMean_DTO wdto = new WordMean_DTO();
		// WordMean newWordMean = new WordMean();
		System.out.println("�߰��� ���ܾ �Է��ϻ��� ");
		String newWord = in.nextLine();
		wdto.setEng(newWord);
		if(wdao.chkWord(wdto)) {
			System.out.println("���ܾ��� ���� �Է��ϼ���. ");
			String wordMean = in.nextLine();
			System.out.println("�߿䵵�� ��/��/�Ϸ� �Է��ϼ���. ");
			String imp = in.nextLine();
			System.out.println("�ڸ�Ʈ�� �ۼ��ϼ���. ");
			String comment = in.nextLine();
			if (imp.equals("��") || imp.equals("��") || imp.equals("��")) {
				
				wdto.setMean(wordMean);
				wdto.setImp(imp);
				wdto.setComment(comment);

				wdao.insertWord(wdto);
				System.out.println(newWord + "(��/��) �߰��Ǿ����ϴ�.");
			} else {
				System.out.println("�߸��� �Է��Դϴ�.");
			}
		}else{
			System.out.println(newWord + "(��/��) �ֽ��ϴ�.");
		}
		// boolean flag = true;
//		for (Entry<String, WordMean> entry : word.entrySet()) {
//			if (newWord.equals(entry.getKey())) {
//				System.out.println(entry.getKey() + "�ܾ �̹� �ֽ��ϴ�.  ");
//				flag = false;
//			}
//		}
//		if (flag) {
		
//		}
	}

	private void menu() {
		System.out.println("--------- ");
		System.out.println("1. �ܾ��߰� ");
		System.out.println("2. �ܾ���� ");
//		System.out.println("3. �ܾ�˻� ");
		System.out.println("4. �ܾ���� ");
		System.out.println("5. ��ü���� ");
		System.out.println("6. ��ü���� ");
		System.out.println("7. �����޴� ");
	}
}