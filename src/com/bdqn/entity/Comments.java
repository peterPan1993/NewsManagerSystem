package com.bdqn.entity;

import java.util.Date;

public class Comments {
	private Integer cId;
	private Integer cnId;
	private String cContent;
	private Date cDate;
	private String cip;
	private String cAuthor;
	
	public Integer getcId() {
		return cId;
	}
	public void setcId(Integer cId) {
		this.cId = cId;
	}
	public Integer getCnId() {
		return cnId;
	}
	public void setCnId(Integer cnId) {
		this.cnId = cnId;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public Date getcDate() {
		return cDate;
	}
	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}
	public String getCip() {
		return cip;
	}
	public void setCip(String cip) {
		this.cip = cip;
	}
	public String getcAuthor() {
		return cAuthor;
	}
	public void setcAuthor(String cAuthor) {
		this.cAuthor = cAuthor;
	}
	public Comments(Integer cId, Integer cnId, String cContent, Date cDate,
			String cip, String cAuthor) {
		super();
		this.cId = cId;
		this.cnId = cnId;
		this.cContent = cContent;
		this.cDate = cDate;
		this.cip = cip;
		this.cAuthor = cAuthor;
	}
	public Comments() {
		super();
	}
}
