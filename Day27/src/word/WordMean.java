package word;

public class WordMean {
	private String eng = null;
	private String mean = null;
	private String imp = null;
	private String comment = null;

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	public void setImp(String imp) {
		this.imp = imp;
	}

	public String getComment() {
		return comment;
	}

	public String getMean() {
		return mean;
	}

	public String getImp() {
		return imp;
	}
	
	public void prt() {
		System.out.println("------------");
		System.out.println("영단어: "+ eng);
		System.out.println("뜻: "+ mean);
		System.out.println("중요도: "+ imp);
		System.out.println("메모: "+ comment);
	}

}