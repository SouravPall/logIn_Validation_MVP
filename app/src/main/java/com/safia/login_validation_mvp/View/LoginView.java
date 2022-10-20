package com.safia.login_validation_mvp.View;

public interface LoginView {

    void onLoginSuccess (String msg);
    void onLoginError(String msg);
    void onSetProgressBarVisibility(int visibility);

}
