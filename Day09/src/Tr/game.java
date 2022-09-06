package Tr;

import java.util.Scanner;

public class game {
	String[] word = new String[10];
	Scanner in = new Scanner(System.in);
	String[] badWord = { "fuck", "asshole", "bullshit", "bitch" };

	game() {
		menu();
	}

	private void menu() {
		for (;;) {
			System.out.println("----메뉴----");
			System.out.println("1. 영단어 입력 ");
			System.out.println("2. 영단어 목록 ");
			System.out.println("3. 영단어 수정 ");
			System.out.println("4. 영단어 삭제 ");
			System.out.println("5. 영단어 검색 ");
			System.out.println("6. 영타 게임시작 ");
			System.out.println("7. 프로그램 종료 ");
			System.out.println("1~7번까지 원하는 메뉴의 숫자를 입력하세요. ");
			int a = in.nextInt();
			in.nextLine();
			if (a == 1) {
				wordInput();
			} else if (a == 2) {
				prt();
			} else if (a == 3) {
				update();
			} else if (a == 4) {
				del();
			} else if (a == 5) {
				search();
			} else if (a == 6) {
				game1();
			} else if (a == 7) {
				break;
			} else {
				System.out.println("잘못된 입력입니다. ");
			}
		}
	}

	public int chkLength(String w) {//
		if (w.length() > 8) {
			return 0;
		} else {
			return 1;
		}
	}

//	public int chkbadWord(String w) {
//		int checkFlag = 1;
//		for (int i = 0; i < badWord.length; i++) {
//			if (w.equals(badWord[i])) {
//				checkFlag = 0;
//			}
//		}
//		return checkFlag;
//	}
	
	//입력받은 문자열과 배열의 값에 중복을 비교.
	public int chkOverlap(String w,String[] b) {
		int checkFlag = 1;
		for (int i = 0; i < b.length; i++) {
			if (w.equals(b[i])) {//중복이 있으면 0
				checkFlag = 0;
			}
		}
		return checkFlag;// 중복이 없으면 1
	}

	public void wordInput() {
		System.out.println("저장할 영어 단어를 입력하세요.");
		String wordIn = in.nextLine();
		if (chkLength(wordIn) == 0) {
			System.out.println("8글자 이하로 입력해주세요. ");
		} else {
			if (chkOverlap(wordIn,badWord) == 0) {
				System.out.println("욕은 사용할 수 없습니다. ");
			} else {
				if (chkOverlap(wordIn,word) == 0) {
					System.out.println("중복된 단어입니다. ");
				} else {
					for (int i = 0; i < word.length; i++) {
						if (word[i] == null) {
							word[i] = wordIn;
							break;
						}
					}
				}
			}
		}
	}

	public void prt() {// 출력하는 기능을 수행하는 메서드. 호출이 없으면 메서드는 실행되지 않음.
		for (int i = 0; i < word.length; i++) {
			if (word[i] != null) {
				System.out.println(i + ":" + word[i]);
			}
		}
	}

	public void del() {
		System.out.println("삭제할 영단어를 입력하세요.");
		String delWord = in.nextLine();
		int checkFlag = 0;

		for (int i = 0; i < word.length; i++) {
			if (delWord.equals(word[i])) {
				word[i] = null;
				checkFlag = 1;
				System.out.println(delWord + " 삭제완료 ");
				break;
			}
		}

		if (checkFlag == 0) {
			System.out.println(delWord + "(이/가) 없습니다.");
		}
	}

	public void update() {
		System.out.println("수정할 영단어를 입력하세요.");
		String updateWord = in.nextLine();
		int checkFlag = 0;
		for (int i = 0; i < word.length; i++) {
			if (updateWord.equals(word[i])) {
				System.out.println("새로운 영단어를 입력하세요.");
				String newWord = in.nextLine();
				if (chkLength(newWord) == 0) {
					System.out.println("8글자 이하로 입력해주세요. ");
					i--;
				} else if (chkOverlap(newWord,badWord) == 0) {
					System.out.println("욕은 사용할 수 없습니다. ");
					i--;
				} else if (chkOverlap(newWord,word) == 0) {
					System.out.println("중복된 단어입니다. ");
					i--;
				} else {
					word[i] = newWord;
					checkFlag = 1;
					System.out.println(" 수정완료 ");
					break;
				}
			}
		}
		if (checkFlag == 0) {
			System.out.println(updateWord + "(이/가) 없습니다.");
		}
	}

	public void search() {

		System.out.println("검색할 영단어를 입력하세요.");
		String searchWord = in.nextLine();

		if (chkOverlap(searchWord,word) == 0) {
			System.out.println(searchWord);

		} else if (chkOverlap(searchWord,word) == 1) {
			System.out.println(searchWord + "(이/가) 없습니다.");
		}
	}

	private void game1() {
		System.out.println("5게임 후 또는 stop 입력시 게임 종료 ");
		// null의 갯수 체크 하여 null이 6개이상이면 게임 시작 안함.
		int nullChk = 0;
		for (int k = 0; k < word.length; k++) {
			if (word[k] == null) {
				nullChk++;
			}
		}
		// null 갯수 6미만이면 게임시
		if (nullChk < 6) {
			double score = 0; // 점수 누계
			String[] gameWord=new String[5];
			for (int j = 0; j < 5; j++) {// 게임횟수 5번
				int idx = (int) (Math.random() * word.length);// 랜덤한 단어 뽑기
				// 랜덤한 값이 null 값이 아니고 중복되는 단어가 아닌 경우 제시어를 제시.
				if (word[idx] != null && chkOverlap(word[idx],gameWord)==1) {
					System.out.println("제시어를 따라서 입력하세요.");
					System.out.println("제시어:" + word[idx]);
					String newWord = in.nextLine();
					//stop을 입력할 경우 게임 종료 
					if(newWord.equals("stop")) {
						break;
					}else {
						// 입력한 단어를 제시한 단어보다 짧게 쳤을 경우 에러나는것을 방지.
						if (word[idx].length() >= newWord.length()) {
							for (int i = 0; i < newWord.length(); i++) {
								if (word[idx].charAt(i) == newWord.charAt(i)) {
									score= score + (double)100/word[idx].length();
								}
							}
							System.out.println("현재 점수: " + (int)Math.round(score) + "점 ");
							
						} else {
							for (int i = 0; i < word[idx].length(); i++) {
								if (word[idx].charAt(i) == newWord.charAt(i)) {
									score= score + (double)100/word[idx].length();
								}
							}
							System.out.println("현재 점수: " + (int)Math.round(score) + "점 ");
							
						}
					}
					gameWord[j]=word[idx];
				} else {// 랜덤한 값이 null 값을 뽑을 경우 다시 뽑음.
					j--;
				}
			}
			System.out.println("최종 점수: " + (int)score + "점 ");
		} else {// 단어가 5개 미만일 경우 다시 뽑기.
			System.out.println("영단어를 최소 5개 입력해주세요. ");
		}

//		String aa="word!@";
//		String sign="!@#$%^&*";
//		
//		for(int i=0; i<aa.length();i++) {
//			System.out.println("현재문자: "+aa.charAt(i)+"-----------");
//			for(int j=0; j<sign.length();j++) {
//				System.out.println("비교문자: "+ sign.charAt(j));
//				if(aa.charAt(i)==sign.charAt(j)) {
//					System.out.println("특수문자있음 ");
//					break;
//				}
//			}
//		}

	}

	// cahrAt(): 매개변수로 입력받은 문자열을 잘라서 문자로 리턴. 비교연산자 사용 가

}
