package com.qq.common;

import java.io.Serializable;

public class ServerResponse<T> implements Serializable {
    //状态1不是成功
    private int success;
    private  T date;
    private String url;

    public ServerResponse() {
    }

    public ServerResponse(int success, T date) {
        this.success = success;
        this.date = date;
    }

    public ServerResponse(int success) {
        this.success = success;
    }

    public ServerResponse(int success, T date, String url) {
        this.success = success;
        this.date = date;
        this.url = url;
    }


    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "success=" + success +
                ", date=" + date +
                ", url='" + url + '\'' +
                '}';
    }
}
