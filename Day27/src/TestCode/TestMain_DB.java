package TestCode;

public class TestMain_DB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDAO wdao = new WordDAO();
		String engName = "banana";
		String korName = "바나나";
		String imporFlag = "중";
		String comment = "명사";
		
		WordInfoDTO w = new WordInfoDTO();
		
		w.setEngName(engName);
		w.setKorName(korName);
		w.setImporFlag(imporFlag);
		w.setComment(comment);
		wdao.insertWord(w);
	}

}
