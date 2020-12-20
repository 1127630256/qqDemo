package com.qq.entity;

import java.util.Date;

public class EcqUsers {
    private Long userid;

    private String nickname;

    private String loginpwd;

    private Integer state;

    private String facepath;

    private Date rgedate;

    private Integer age;

    private String sex;

    private Integer star;

    private Integer blood;

    private String realname;

    private Integer friendpolicy;

    private String memo;

    private EcqBlood ecqBlood;

    private EcqStar ecqStar;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public EcqBlood getEcqBlood() {
        return ecqBlood;
    }

    public void setEcqBlood(EcqBlood ecqBlood) {
        this.ecqBlood = ecqBlood;
    }

    public EcqStar getEcqStar() {
        return ecqStar;
    }

    public void setEcqStar(EcqStar ecqStar) {
        this.ecqStar = ecqStar;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd == null ? null : loginpwd.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getFacepath() {
        return facepath;
    }

    public void setFacepath(String facepath) {
        this.facepath = facepath == null ? null : facepath.trim();
    }

    public Date getRgedate() {
        return rgedate;
    }

    public void setRgedate(Date rgedate) {
        this.rgedate = rgedate;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        if (sex.equals(1)){
            this.sex = "男";
        }else if (sex.equals(2)){
            this.sex = "女";
        }else {
            this.sex = sex == null ? null : sex.trim();
        }

    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getFriendpolicy() {
        return friendpolicy;
    }

    public void setFriendpolicy(Integer friendpolicy) {
        this.friendpolicy = friendpolicy;
    }

    @Override
    public String toString() {
        return "EcqUsers{" +
                "userid=" + userid +
                ", nickname='" + nickname + '\'' +
                ", loginpwd='" + loginpwd + '\'' +
                ", state=" + state +
                ", facepath='" + facepath + '\'' +
                ", rgedate=" + rgedate +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", star=" + star +
                ", blood=" + blood +
                ", realname='" + realname + '\'' +
                ", friendpolicy=" + friendpolicy +
                ", memo='" + memo + '\'' +
                ", ecqBlood=" + ecqBlood +
                ", ecqStar=" + ecqStar +
                '}';
    }
}