package com.codegym.meeting_room_management.dao.entity;

public class MyPageable {
    int pageSize;
    int pageNumber;
    MySort mySort;



    public MyPageable(int pageSize, int pageNumber) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public MySort getMySort() {
        return mySort;
    }

    public void setMySort(MySort mySort) {
        this.mySort = mySort;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
