package com.example.demo.controller;


public class LoginDetails {

    private String loginUrl;

    public LoginDetails(String loginUrl, String authUrl) {
        this.loginUrl = loginUrl;
        this.authUrl = authUrl;
    }

    private String authUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }

}
