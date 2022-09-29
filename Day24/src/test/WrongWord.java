package test;

public class WrongWord {
	private String wrongMean = null;
	private int wrongCnt = 0;

	public String getWrongMean() {
		return wrongMean;
	}

	public void setWrongMean(String wrongMean) {
		this.wrongMean = wrongMean;
	}

	public int getWrongCnt() {
		return wrongCnt;
	}

	public void setWrongCnt(int wrongCnt) {
		this.wrongCnt = wrongCnt;
	}

	public void plusCnt() {
		wrongCnt++;
	}
}