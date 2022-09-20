package Zoo;

import java.util.Scanner;

public class ZooManager {
	Animal[] aList = new Animal[10];
	Scanner in = new Scanner(System.in);

	ZooManager() {
		for (;;) {
			menu();
			String slt = in.nextLine();
			if (slt.equals("1")) {
				addAni();
			} else if (slt.equals("2")) {
				prtAni();
			} else if (slt.equals("3")) {
				updateAni();
			} else if (slt.equals("4")) {
				deleteAni();
			}else if(slt.equals("5")) {
				searchAni();
			}else {
				System.out.println("잘못된 입력입니다.");
			}

		}
	}

	private void deleteAni() {
		System.out.println("삭제할 동물의 번호을 입력하세요");
		String a = in.nextLine();
		int aa = Integer.parseInt(a);
		if (aa < aList.length && aList[aa] != null) {

			System.out.println("동물정보를 확인하세요");
			aList[aa].prt();
			System.out.println("위의 정보가 맞나요?(Y/N)");
			String b = in.nextLine();
			b.toLowerCase();
			if (b.equals("y")) {
				aList[aa] = null;
				System.out.println(aList[aa] + "가 삭제되었습니다.");
			} else {
				System.out.println("메뉴로 돌아갑니다.");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void updateAni() {
		System.out.println("수정할 동물의 번호을 입력하세요");
		String a = in.nextLine();
		int aa = Integer.parseInt(a);
		if (aa < aList.length && aList[aa] != null) {

			System.out.println("동물정보를 확인하세요");
			aList[aa].prt();
			System.out.println("위의 정보가 맞나요?(Y/N)");
			String b = in.nextLine();
			b.toLowerCase();
			if (b.equals("y")) {
				Animal newAnimal = inputAni();
				aList[aa] = newAnimal;
			} else {
				System.out.println("메뉴로 돌아갑니다.");
			}
		} else {
			System.out.println("잘못된 입력입니다.");
		}
	}

	private void prtAni() {
		for (int i = 0; i < aList.length; i++) {
			if (aList[i] != null) {
				System.out.println(i + "번 정보-------");
				aList[i].prt();
				System.out.println("------------");
			}
		}
	}

	private void addAni() {
		Animal newAnimal = inputAni();
		for (int i = 0; i < aList.length; i++) {
			if (aList[i] == null) {
				aList[i] = newAnimal;
				break;
			}

		}

	}

	private void menu() {
		System.out.println("1.동물등록");
		System.out.println("2.동물전체보기");
		System.out.println("3.동물수정");
		System.out.println("4.동물삭제");
		System.out.println("5.동물검색");

	}

	public Animal inputAni() {
		Animal newAnimal = new Animal();
		System.out.println("동물명 입력");
		String kind = in.nextLine();
		System.out.println("동물이름 입력");
		String name = in.nextLine();
		System.out.println("동물먹이 입력");
		String food = in.nextLine();
		System.out.println("동물나이 입력");
		int age = in.nextInt();
		in.nextLine();
		System.out.println("동물질병 입력");
		String sick = in.nextLine();

		newAnimal.setAnimal(kind, name, food, age, sick);

		return newAnimal;
	}
	
	public void searchAni() {
//		System.out.println("검색할 속성을 선택하세요.");
//		System.out.println("1.동물명");
//		System.out.println("2.동물이름");
//		System.out.println("3.동물먹이");
//		System.out.println("4.동물나이");
//		System.out.println("5.동물질병");
//		String a = in.nextLine();
//		
//		if(a.equals("1")) {
			
			System.out.println("검색할 동물의 식성을 입력해주세요");
		      String b = in.nextLine();
		      for(int i = 0; i < aList.length; i++) {
		         if(aList[i].food.equals(b)) {
		            aList[i].prt();
		         }
		         if(i == aList.length - 1) {
		            break;
		         }
		      }
//		}
	      
	   }

}
