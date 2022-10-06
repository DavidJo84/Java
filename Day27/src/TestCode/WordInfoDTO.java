package TestCode;

//DTO는 튜플에 저장할 정보를 갖고 있거나 데이터 베이스에서 가져온 튜플의 정보를 자바로 가져오는 객체
//이름은 가독성을 위해 DTO라고 하며 반드시 전역변수의 getter setter가 있어야 한다.
public class WordInfoDTO {
	private String engName;
	private String korName;
	private String imporFlag;
	private String comment;
	private int[] checkFlag = new int[3];
	private int missChk;

	public String getEngName() {
		return engName;
	}

	public void setEngName(String engName) {
		this.engName = engName;
	}

	public String getKorName() {
		return korName;
	}

	public void setKorName(String korName) {
		this.korName = korName;
	}

	public String getImporFlag() {
		return imporFlag;
	}

	public void setImporFlag(String imporFlag) {
		this.imporFlag = imporFlag;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int[] getCheckFlag() {
		return checkFlag;
	}

	public void setCheckFlag(int[] checkFlag) {
		this.checkFlag = checkFlag;
	}

	public int getMissChk() {
		return missChk;
	}

	public void setMissChk(int missChk) {
		this.missChk = missChk;
	}

}
