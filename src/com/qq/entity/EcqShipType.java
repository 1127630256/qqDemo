package com.qq.entity;

public class EcqShipType {
    private Integer shiptypeid;

    private String shipname;

    private String memo;

    public Integer getShiptypeid() {
        return shiptypeid;
    }

    public void setShiptypeid(Integer shiptypeid) {
        this.shiptypeid = shiptypeid;
    }

    public String getShipname() {
        return shipname;
    }

    public void setShipname(String shipname) {
        this.shipname = shipname == null ? null : shipname.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqShipType{" +
                "shiptypeid=" + shiptypeid +
                ", shipname='" + shipname + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}