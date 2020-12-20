package com.qq.entity;

public class EcqState {
    private Integer stateid;

    private String statename;

    private String memo;

    public Integer getStateid() {
        return stateid;
    }

    public void setStateid(Integer stateid) {
        this.stateid = stateid;
    }

    public String getStatename() {
        return statename;
    }

    public void setStatename(String statename) {
        this.statename = statename == null ? null : statename.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqState{" +
                "stateid=" + stateid +
                ", statename='" + statename + '\'' +
                ", memo='" + memo + '\'' +
                '}';
    }
}