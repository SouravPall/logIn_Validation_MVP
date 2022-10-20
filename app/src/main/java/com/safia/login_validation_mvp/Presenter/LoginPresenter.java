package com.safia.login_validation_mvp.Presenter;

public interface LoginPresenter {

    void  doLogin(String email, String pass);
    void  setProgressBarVisibility(int visibility);

}
