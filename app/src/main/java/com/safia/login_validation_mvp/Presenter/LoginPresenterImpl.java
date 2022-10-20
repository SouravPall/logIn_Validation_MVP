package com.safia.login_validation_mvp.Presenter;



import android.os.Looper;
import android.os.Handler;

import com.safia.login_validation_mvp.Model.InterfaceUser;
import com.safia.login_validation_mvp.Model.UserImpl;
import com.safia.login_validation_mvp.View.LoginView;




public class LoginPresenterImpl implements LoginPresenter{



    private LoginView loginView;
    private Handler handler;


    public LoginPresenterImpl(LoginView loginView) {

        this.loginView = loginView;
        handler = new Handler(Looper.getMainLooper());

    }

    @Override
    public void doLogin(String email, String pass) {

        InterfaceUser user = new UserImpl(email,pass);
        int login_code = user.checkUserValidity();


        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                if (login_code == 0){
                    loginView.onLoginError("Please Enter Your Email");
                }
                else if (login_code == 1){
                    loginView.onLoginError("Please Enter A valid Email");
                }
                else if (login_code == 2){
                    loginView.onLoginError("Please Enter Your Password.");
                }
                else if (login_code == 3){
                    loginView.onLoginError("Please Enter a password that should be more than 6 character");
                }
                else {
                    loginView.onLoginSuccess("Log In Successful");
                }


            }
        }, 1000);






    }

    @Override
    public void setProgressBarVisibility(int visibility) {

        loginView.onSetProgressBarVisibility(visibility);
    }
}
