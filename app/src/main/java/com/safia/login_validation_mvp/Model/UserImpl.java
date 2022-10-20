package com.safia.login_validation_mvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

import java.util.regex.Pattern;

public class UserImpl implements InterfaceUser{

    private String email, passWord;

    public UserImpl(String email, String passWord) {
        this.email = email;
        this.passWord = passWord;
    }



    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassWord() {
        return passWord;
    }

    @Override
    public int checkUserValidity() {

        if (TextUtils.isEmpty(getEmail())){
            return 0;
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
            return 1;
        }
        else if (TextUtils.isEmpty(getPassWord())){
            return 2;
        }
        else if (getPassWord().length()<6){
            return 3;
        }
        else return -1;

    }
}
