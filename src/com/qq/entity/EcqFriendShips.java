package com.qq.entity;

import java.util.Date;

public class EcqFriendShips {
    private Long shipid;

    private Long hostid;

    private Long friendid;

    private Integer shiptype;

    private Date createdate;

    private String memo;

    public Long getShipid() {
        return shipid;
    }

    public void setShipid(Long shipid) {
        this.shipid = shipid;
    }

    public Long getHostid() {
        return hostid;
    }

    public void setHostid(Long hostid) {
        this.hostid = hostid;
    }

    public Long getFriendid() {
        return friendid;
    }

    public void setFriendid(Long friendid) {
        this.friendid = friendid;
    }

    public Integer getShiptype() {
        return shiptype;
    }

    public void setShiptype(Integer shiptype) {
        this.shiptype = shiptype;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqFriendShips{" +
                "shipid=" + shipid +
                ", hostid=" + hostid +
                ", friendid=" + friendid +
                ", shiptype=" + shiptype +
                ", createdate=" + createdate +
                ", memo='" + memo + '\'' +
                '}';
    }
}