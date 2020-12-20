package com.qq.entity;

public class EcqFriendPolicy {
    private Integer policyid;

    private String policyname;

    private String memo;

    public Integer getPolicyid() {
        return policyid;
    }

    public void setPolicyid(Integer policyid) {
        this.policyid = policyid;
    }

    public String getPolicyname() {
        return policyname;
    }

    public void setPolicyname(String policyname) {
        this.policyname = policyname == null ? null : policyname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqFriendPolicy{" +
                "policyid=" + policyid +
                ", policyname='" + policyname + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}