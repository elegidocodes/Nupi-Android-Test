package com.elegidocodes.androidtest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.processing.Generated;

@Generated("jsonschema2pojo")
public class LoginResponseData {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("token")
    @Expose
    private Token token;
    @SerializedName("isAdmin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("user")
    @Expose
    private User user;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginResponseData{" +
                "msg='" + msg + '\'' +
                ", token=" + token +
                ", isAdmin=" + isAdmin +
                ", user=" + user +
                '}';
    }

}
