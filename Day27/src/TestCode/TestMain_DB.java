package TestCode;

public class TestMain_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDAO wdao = new WordDAO();
		String engName = "banana";
		String korName = "�ٳ���";
		String imporFlag = "��";
		String comment = "���";
		
		WordInfoDTO w = new WordInfoDTO();
		
		w.setEngName(engName);
		w.setKorName(korName);
		w.setImporFlag(imporFlag);
		w.setComment(comment);
		wdao.insertWord(w);
	}

}
