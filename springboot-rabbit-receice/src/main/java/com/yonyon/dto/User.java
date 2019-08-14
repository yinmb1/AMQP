package com.yonyon.dto;


import java.io.Serializable;

/**
 * @author yinmb
 * @Date 2019/3/20 17:51:18
 */

public class User implements Serializable {
    private static final long serialVersionUID = 8895620355110218248L;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    private String passWord;


    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }
}
