package jp.co.sparkworks.sourcehelper.datastruct;

public enum ReplacementType {
	TEXT(1), 
	EXCEL(2), 
	OTHER(3);

	private final int id;

	private ReplacementType(final int id) {
		this.id = id;
	}

	public static ReplacementType valueOf(int id) {

		for (ReplacementType num : values()) {
			if (num.getId() == id) {
				return num;
			}
		}
		throw new IllegalArgumentException("no such enum object for the id: " + id);
	}

	public int getId() {
		return id;
	}
}
