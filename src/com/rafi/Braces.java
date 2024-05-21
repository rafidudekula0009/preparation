package com.rafi;

public class Braces {
	String brace;
	String type;

	public Braces(String brace, String type) {
		super();
		this.brace = brace;
		this.type = type;
	}

	public String getBrace() {
		return brace;
	}

	public void setBrace(String brace) {
		this.brace = brace;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Braces [brace=%s, type=%s]", brace, type);
	}

}