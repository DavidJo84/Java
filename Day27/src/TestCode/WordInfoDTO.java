package TestCode;

//DTO�� Ʃ�ÿ� ������ ������ ���� �ְų� ������ ���̽����� ������ Ʃ���� ������ �ڹٷ� �������� ��ü
//�̸��� �������� ���� DTO��� �ϸ� �ݵ�� ���������� getter setter�� �־�� �Ѵ�.
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
