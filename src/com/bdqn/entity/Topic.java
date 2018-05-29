package com.bdqn.entity;

public class Topic {
	private Integer tId;
	private String tName;
	
	public Integer gettId() {
		return tId;
	}

	public void settId(Integer tId) {
		this.tId = tId;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public Topic(Integer tId, String tName) {
		super();
		this.tId = tId;
		this.tName = tName;
	}

	public Topic() {
		super();
	}
	
}
