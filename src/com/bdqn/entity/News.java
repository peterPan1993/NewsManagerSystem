package com.bdqn.entity;

import java.util.Date;
import java.util.List;

public class News {
    private Integer nId;
    private Integer ntId;
    private String ntname;
    private List<Comments> comments;
    private String nTitle;
    private String nAuthor;
    private Date nCreateDate;
    private String nPicPath;
    private String nContent;
    private Date nModifyDate;
    private String nSummary;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Integer getNtId() {
        return ntId;
    }

    public void setNtId(Integer ntId) {
        this.ntId = ntId;
    }

    public String getNtname() {
        return ntname;
    }

    public void setNtname(String ntname) {
        this.ntname = ntname;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public String getnTitle() {
        return nTitle;
    }

    public void setnTitle(String nTitle) {
        this.nTitle = nTitle;
    }

    public String getnAuthor() {
        return nAuthor;
    }

    public void setnAuthor(String nAuthor) {
        this.nAuthor = nAuthor;
    }

    public Date getnCreateDate() {
        return nCreateDate;
    }

    public void setnCreateDate(Date nCreateDate) {
        this.nCreateDate = nCreateDate;
    }

    public String getnPicPath() {
        return nPicPath;
    }

    public void setnPicPath(String nPicPath) {
        this.nPicPath = nPicPath;
    }

    public String getnContent() {
        return nContent;
    }

    public void setnContent(String nContent) {
        this.nContent = nContent;
    }

    public Date getnModifyDate() {
        return nModifyDate;
    }

    public void setnModifyDate(Date nModifyDate) {
        this.nModifyDate = nModifyDate;
    }

    public String getnSummary() {
        return nSummary;
    }

    public void setnSummary(String nSummary) {
        this.nSummary = nSummary;
    }

    public News(Integer nId, Integer ntId, String ntname, List<Comments> comments, String nTitle, String nAuthor, Date nCreateDate, String nPicPath, String nContent, Date nModifyDate, String nSummary) {
        this.nId = nId;
        this.ntId = ntId;
        this.ntname = ntname;
        this.comments = comments;
        this.nTitle = nTitle;
        this.nAuthor = nAuthor;
        this.nCreateDate = nCreateDate;
        this.nPicPath = nPicPath;
        this.nContent = nContent;
        this.nModifyDate = nModifyDate;
        this.nSummary = nSummary;
    }

    public News() {
        super();
    }

}
