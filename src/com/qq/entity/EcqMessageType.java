package com.qq.entity;

public class EcqMessageType {
    private Integer typeid;

    private String typename;

    private String memo;

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqMessageType{" +
                "typeid=" + typeid +
                ", typename='" + typename + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}