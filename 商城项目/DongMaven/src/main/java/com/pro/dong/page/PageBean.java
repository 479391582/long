package com.pro.dong.page;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> {
	private Integer currPage;//��ǰҳ��
    private Integer pageSize;//ÿҳ��ʾ�ļ�¼��
    private Integer totalCount;//�ܼ�¼��
    private Integer totalPage;//��ҳ��
    private List<T> lists;//ÿҳ����ʾ������

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
