package com.qq.entity;

import java.util.Date;

public class EcqMessages {
    private Long messageid;

    private Long fromid;

    private Long toid;

    private String message;

    private Integer messagetype;

    private Integer messagestate;

    private Date sendtime;

    private String memo;

    public Long getMessageid() {
        return messageid;
    }

    public void setMessageid(Long messageid) {
        this.messageid = messageid;
    }

    public Long getFromid() {
        return fromid;
    }

    public void setFromid(Long fromid) {
        this.fromid = fromid;
    }

    public Long getToid() {
        return toid;
    }

    public void setToid(Long toid) {
        this.toid = toid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Integer getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(Integer messagetype) {
        this.messagetype = messagetype;
    }

    public Integer getMessagestate() {
        return messagestate;
    }

    public void setMessagestate(Integer messagestate) {
        this.messagestate = messagestate;
    }

    public Date getSendtime() {
        return sendtime;
    }

    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {

        this.memo = memo == null ? null : memo.trim();
    }

    @Override
    public String toString() {
        return "EcqMessages{" +
                "messageid=" + messageid +
                ", fromid=" + fromid +
                ", toid=" + toid +
                ", message='" + message + '\'' +
                ", messagetype=" + messagetype +
                ", messagestate=" + messagestate +
                ", sendtime=" + sendtime +
                ", memo='" + memo + '\'' +
                '}';
    }
}