package com.pro.dong.page;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> {
	private Integer currPage;//当前页数
    private Integer pageSize;//每页显示的记录数
    private Integer totalCount;//总记录数
    private Integer totalPage;//总页数
    private List<T> lists;//每页的显示的数据

    public PageBean() {
        super();
    }

   
    public Integer getCurrPage() {
		return currPage;
	}


	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}


	public Integer getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}


	public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
	
}
