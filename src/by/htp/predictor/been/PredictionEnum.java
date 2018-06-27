package by.htp.predictor.been;

public enum PredictionEnum {
	LOVE(1, "Love"), MONEY(2, "Money"), ACCOMMODATION(3, "Accommodation");
	private String value;
	private int number;

	private PredictionEnum(int number, String value) {
		this.number = number;
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public int getNumber() {
		return number;
	}

}
