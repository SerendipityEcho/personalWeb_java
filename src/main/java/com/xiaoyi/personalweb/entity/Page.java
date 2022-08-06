package com.xiaoyi.personalweb.entity;

import java.util.List;

public class Page<T> {

    private List<T> list; // 对象列表
    private int total; // 总条数
    private int limit = 7; // 每页显示的条数
    private int pages; // 总页数
    private int pageNow = 1; // 当前页
    private int start = 0; // 当前页首条数据

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        this.pages = this.total / this.limit;
        if (this.total%this.limit != 0){
            this.pages += 1;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
        this.start = this.limit * (this.pageNow - 1);
    }

}
