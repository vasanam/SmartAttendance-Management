package com.vasana.smartattendance.pojo;

public class StudentPojo {
    private String title;
    private String subTitle;
    private int dp;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public StudentPojo(String title, String subTitle, int dp) {
        this.title = title;
        this.subTitle = subTitle;
        this.dp = dp;
    }
}
