package com.sdl.dart.yellowpages2;

/**
 * Created by ashutosh on 19/8/17.
 */

public class user {
    String u_name, pass;

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {

        return pass;
    }

    public String getU_name() {

        return u_name;
    }

    user(String email, String password) {
        this.u_name = email;
        this.pass = password;
    }

    public user() {
    }
}
