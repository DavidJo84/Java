package Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbs bbs = new Bbs();

		bbs.input("1Q84", 1, "무라카미 하루키 대표작");
		bbs.cntPlus();

		String title = bbs.reTitle();
		int no = bbs.reNo();
		String text = bbs.reText();
		int cnt = bbs.reCnt();
		System.out.println("제목: " + title);
		System.out.println("글번호: " + no);
		System.out.println("내용: " + text);
		System.out.println("조회수: " + cnt);
		String chkTitle = bbs.chkTitle("1Q");
		System.out.println(chkTitle);
		int chkText= bbs.chkText("하루");
		System.out.println(chkText);

	}

}
