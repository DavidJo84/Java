package Test;

public class Bbs {
	String title = null;
	int no = 0;
	String text = null;
	int cnt = 0;
	String[] badWord = { "개나리", "십장생" };

	public int input(String ti, int n, String te) {
		int cnt = 0;
		for (int i = 0; i < badWord.length; i++) {

			for (int j = 0; j < ti.length(); j++) {
				if (badWord[i].indexOf(ti.charAt(j)) != -1) {
					cnt++;
				}
			}
		}
		if (cnt < 3) {
			title = ti;
			no = n;
			text = te;
			return 1;
		}

		return 0;
	}

	public void cntPlus() {
		cnt++;
	}

	public String reTitle() {
		return title;
	}

	public int reNo() {
		return no;
	}

	public String reText() {
		return text;
	}

	public int reCnt() {
		return cnt;
	}

	public String chkTitle(String t) {
		if (title.contains(t)) {
			return title;
		}
		return null;
	}

	public int chkText(String chk) {

		int cnt2 = 0;
		String a = text;
		for (int i = 0; i < a.length(); i++) {

			if (a.indexOf(chk) != -1) {
				a = a.substring(a.indexOf(chk) + 1);
				cnt2++;
				i--;
			}
		}
		return cnt2;

	}
}
