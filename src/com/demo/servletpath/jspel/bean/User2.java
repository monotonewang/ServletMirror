package com.demo.servletpath.jspel.bean;

/**
 * Created by 7 on 2016/12/6.
 */
public class User2 {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public User2(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User2() {
    }
}
