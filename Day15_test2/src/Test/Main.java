package Test;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bbs bbs = new Bbs();

		bbs.input("1Q84", 1, "����ī�� �Ϸ�Ű ��ǥ��");
		bbs.cntPlus();

		String title = bbs.reTitle();
		int no = bbs.reNo();
		String text = bbs.reText();
		int cnt = bbs.reCnt();
		System.out.println("����: " + title);
		System.out.println("�۹�ȣ: " + no);
		System.out.println("����: " + text);
		System.out.println("��ȸ��: " + cnt);
		String chkTitle = bbs.chkTitle("1Q");
		System.out.println(chkTitle);
		int chkText= bbs.chkText("�Ϸ�");
		System.out.println(chkText);

	}

}
