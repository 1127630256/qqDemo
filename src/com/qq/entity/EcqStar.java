package com.qq.entity;

public class EcqStar {
    private Integer starid;

    private String starname;

    private String memo;

    public Integer getStarid() {
        return starid;
    }

    public void setStarid(Integer starid) {
        this.starid = starid;
    }

    public String getStarname() {
        return starname;
    }

    public void setStarname(String starname) {
        this.starname = starname == null ? null : starname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {

        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqStar{" +
                "starid=" + starid +
                ", starname='" + starname + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}