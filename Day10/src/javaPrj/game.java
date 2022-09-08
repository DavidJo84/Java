package javaPrj;

import java.util.Scanner;

public class game {
	String[] word = new String[10];//입력하는 영단어를 저장할 배열 
	Scanner in = new Scanner(System.in);
	String[] badWord = { "fuck", "asshole", "bullshit", "bitch" };//금지어를 저장해놓은 배열 
	int sru = 9;
	int[] point = new int[sru];//순위표 점수를 저장할 배열 
	String[] rate = new String[sru];//순위표 정답률을 저장할 배열 
	String[] user = new String[sru];//순위표 유저명을 저장할 배열 

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
			System.out.println("7. 순위표 보기 ");
			System.out.println("8. 프로그램 종료 ");
			System.out.println("1~8번까지 원하는 메뉴의 숫자를 입력하세요. ");

			// 숫자를 입력해야 하는데 잘못해서 문자를 입력했을때 오류가 생기기 때문에
			// 문자열로 받아 equals를 사용하여 오류를 처리함.
			String a = in.nextLine();
			if (a.equals("1")) {
				wordInput();
			} else if (a.equals("2")) {
				prt();
			} else if (a.equals("3")) {
				update();
			} else if (a.equals("4")) {
				del();
			} else if (a.equals("5")) {
				search();
			} else if (a.equals("6")) {
				game1();
			} else if (a.equals("7")) {
				score();
			} else if (a.equals("8")) {
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

	// 입력받은 문자열과 배열의 값에 중복을 비교.
	public int chkOverlap(String w, String[] b) {
		int checkFlag = 1;
		for (int i = 0; i < b.length; i++) {
			if (w.equals(b[i])) {// 중복이 있으면 0
				checkFlag = 0;
			}
		}
		return checkFlag;// 중복이 없으면 1
	}

	public void wordInput() {
		// 10개 이상 입력이 되지 않도록 null값 체크
		int nullChk = 0;
		for (int k = 0; k < word.length; k++) {
			if (word[k] == null) {
				nullChk++;
			}
		}
		if (nullChk == 0) {
			System.out.println("10개 단어를 입력하셨습니다. ");
		} else {
			System.out.println("저장할 영어 단어를 입력하세요.");
			String wordIn = in.nextLine();
			if (chkLength(wordIn) == 0) {
				System.out.println("8글자 이하로 입력해주세요. ");
			} else {
				if (chkOverlap(wordIn, badWord) == 0) {
					System.out.println("욕은 사용할 수 없습니다. ");
				} else {
					if (chkOverlap(wordIn, word) == 0) {
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
	}

	public void prt() {
		for (int i = 0; i < word.length; i++) {
			if (word[i] != null) {// 입력된 값만 출력되도록 함.
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
				} else if (chkOverlap(newWord, badWord) == 0) {
					System.out.println("욕은 사용할 수 없습니다. ");
					i--;
				} else if (chkOverlap(newWord, word) == 0) {
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

		if (chkOverlap(searchWord, word) == 0) {
			System.out.println(searchWord+"(이/가) 있습니다.");

		} else if (chkOverlap(searchWord, word) == 1) {
			System.out.println(searchWord + "(이/가) 없습니다.");
		}
	}

	private void game1() {
	      
	      int time = 15;
	      System.out.println("5게임 후 또는 stop 입력시 게임 종료 ");
	      System.out.println("제한시간 " + time + "초");
	      new StopWatch(15);
	      // null의 갯수 체크 하여 null이 6개이상이면 게임 시작 안함.
	      int nullChk = 0;
	      for (int k = 0; k < word.length; k++) {
	         if (word[k] == null) {
	            nullChk++;
	         }
	      }
	      //최종 정답률을 계산하기 위해 놓은 인수
	      double score = 0; // 문제당 점수
	      double scoreSum = 0; // 점수 누계
	      // null 갯수 6미만이면 게임시작
	      if (nullChk < 6) {      
	         String[] gameWord = new String[5];
	         long start = System.currentTimeMillis();
	         long end = start + time*1000;               
	         for (int j = 0; j < 5; j++) {// 게임횟수 5번
	            int idx = (int) (Math.random() * word.length);// 랜덤한 단어 뽑기
	            // 랜덤한 값이 null 값이 아니고 중복되는 단어가 아닌 경우 제시어를 제시.
	            if (word[idx] != null && chkOverlap(word[idx], gameWord) == 1) {   
	               //단어를 받은 시점의 시각 계산
	               System.out.println("제시어를 따라서 입력하세요.");
	               System.out.println("제시어:" + word[idx]);
	               String newWord = in.nextLine();
	               // stop을 입력할 경우 게임 종료
	               if (newWord.equals("stop")) {
	                  break;
	               } else {
	                  if(System.currentTimeMillis() < end) {
	                     // 입력한 단어를 제시한 단어보다 짧게 쳤을 경우 에러나는것을 방지.
	                     if (word[idx].length() >= newWord.length()) {
	                        for (int i = 0; i < newWord.length(); i++) {
	                           if (word[idx].charAt(i) == newWord.charAt(i)) {
	                              score = (double) 100 / word[idx].length();
	                              scoreSum += score;
	                           }
	                        }
	                        System.out.println("현재 점수: " + (int) Math.round(scoreSum) + "점 ");

	                     } else {//입력한 단어가 제시어보다 긴경우 한글자당 -10점.
	                        for (int i = 0; i < word[idx].length(); i++) {
	                           if (word[idx].charAt(i) == newWord.charAt(i)) {
	                              score += (double) 100 / word[idx].length();                              
	                           }
	                        }
	                        scoreSum += score - (newWord.length() - word[idx].length()) * 10;
	                        System.out.println("단어 개수 초과 :" + (newWord.length() - word[idx].length()) + " / 각 10점씩 감점");
	                        System.out.println("현재 점수: " + (int) Math.round(scoreSum) + "점 ");
	                        score = 0;
	                     }
	                  }else {
	                     System.out.println("시간초과... 점수 없음");
	                  }
	               }
	               gameWord[j] = word[idx];
	               
	            } else {// 랜덤한 값이 null 값을 뽑을 경우 다시 뽑음.
	               j--;
	            }
	            
	            score = 0;
	         }
	         
	      } else {// 단어가 5개 미만일 경우 다시 뽑기.
	         System.out.println("영단어를 최소 5개 입력해주세요. ");
	      }
	      System.out.println("게임종료...");
	      System.out.println("최종 점수: " + (int) Math.round(scoreSum) + "점 ");
	      System.out.println("정답률: " + Math.round((scoreSum / 500)*10000)/100 + "%");
	      //최종 점수가 기존 기록을 경신했을경우를 판별
	      for(int i = 0; i < point.length; i++) {
	         if((int) scoreSum > point[i]) {
	            System.out.println("기록경신! 현재순위 : " + (i + 1));
	            System.out.println("이름을 입력해주세요");
	            //점수표에 입력할 이름을 저장
	            String name = in.nextLine();
	            //정렬을 위한 인수들 생성
	            int bScore = (int) scoreSum;
	            String bRate = Math.round((scoreSum / 500)*10000)/100 + "%";
	            String bUser = name;
	            int sScore = 0;
	            String sRate = null;
	            String sUser = null;
	            //점수표를 갱신되는 정보를 포함하여 재정렬
	            for(int j = i; j < point.length; j++) {   
	               sScore = point[j];
	               sRate = rate[j];
	               sUser = user[j];
	               point[j] = bScore;
	               rate[j] = bRate;
	               user[j] = bUser;
	               bScore = sScore;
	               bRate = sRate;
	               bUser = sUser;
	            }
	            //재 정렬후 정보 중복을 막기 위해 반복문 건너뜀
	            i = point.length;
	         }
	      }
	   }

	public void score() {
		System.out.println("점수표를 보여줍니다");
		// 점수표를 위해 만든 배열의 각 값을 보여줌
		for (int i = 0; i < sru; i++) {
			System.out
					.println("순위 : " + (i + 1) + " / 점수 : " + point[i] + " / 정답률 : " + rate[i] + " / 이름 : " + user[i]);
		}
	}
}
