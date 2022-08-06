package com.xiaoyi.personalweb.entity.vo;

import com.xiaoyi.personalweb.entity.UserInfo;

public class UserInfoPage extends UserInfo {
    private int pageNow = 1;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    @Override
    public String toString(){
        return super.toString()+this.pageNow;
    }

}
