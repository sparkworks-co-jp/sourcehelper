package jp.co.sparkworks.sourcehelper.datastruct;

public class ReplacementDefine {

	private String from;
	private String to;

	public ReplacementDefine(String from, String to) {
		this.from = from;
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String toString() {
		return from + "->" + to;
	}

}
