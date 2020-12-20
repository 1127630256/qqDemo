package com.qq.entity;

public class EcqBlood {
    private Integer bloodid;

    private String bloodtype;

    private String memo;

    public Integer getBloodid() {
        return bloodid;
    }

    public void setBloodid(Integer bloodid) {
        this.bloodid = bloodid;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype == null ? null : bloodtype.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
            }

    @Override
    public String toString() {
        return "EcqBlood{" +
                "bloodid=" + bloodid +
                ", bloodtype='" + bloodtype + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}