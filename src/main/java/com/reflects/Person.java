package com.reflects;

/**
 * @author Stephen
 * @date 2020/4/12 11:44
 */
public class Person {
    public String pname;
    private int page;

    public Person(String pname, int page) {
        this.pname = pname;
        this.page = page;
    }

    public Person() {
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
