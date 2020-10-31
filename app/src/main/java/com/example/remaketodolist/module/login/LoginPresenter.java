package com.example.remaketodolist.module.login;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;

    public LoginPresenter(LoginContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public void performLogin(final String email, final String password){
        view.redirectToProfile();
    }
}
