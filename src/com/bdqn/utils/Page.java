package com.bdqn.utils;

import java.util.List;

/**
 * 分页工具类（通用型）
 * 需要设置 总记录数，当前页，数据集合 [页量]
 * @param <T> T为集合泛型
 */
public class Page<T> {

    /**
     * 数据总记录数，默认值=0
     */
    private int totalCount=0;
    /**
     * 页量，页面大小，即每页显示的记录数，默认值=10
     */
    private int pageSize=10;
    /**
     * 总页量，默认值=0
     */
    private int totalPageCount=0;
    /**
     * 当前页码，默认值=1
     */
    private int currentPageNo=1;
    /**
     * 每页显示数据的集合
     */
    private List<T> list;

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        if (totalCount > 0) {
            this.totalCount = totalCount;
            //设置总记录数的同时，根据记录总数计算总页数
            this.totalPageCount = this.totalCount%this.pageSize == 0 ? (this.totalCount/this.pageSize):((this.totalCount/this.pageSize)+1);
        }
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize > 0)
            this.pageSize = pageSize;
    }

    public int getTotalPageCount() {
        return totalPageCount;
    }

    private void setTotalPageCount(int totalPageCount) {
        //this.totalPageCount = totalPageCount;
    }

    public int getCurrentPageNo() {
        if (totalPageCount == 0)
            return 0;
        return currentPageNo;
    }

    public void setCurrentPageNo(int currentPageNo) {
        if (currentPageNo > 0)
            this.currentPageNo = currentPageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        if (list != null && list.size() > 0)
            this.list = list;
    }
}
