package com.example.remaketodolist.module.login;

import android.content.Context;

import com.example.remaketodolist.data.model.User;
import com.example.remaketodolist.data.source.SessionRepository;
import com.example.remaketodolist.utils.provider.UtilProvider;

public class LoginPresenter implements LoginContract.Presenter{
    private final LoginContract.View view;
    private final Context context;

    public LoginPresenter(LoginContract.View view, Context context){
        this.view = view;
        this.context = context;
    }

    public void start(){
        UtilProvider.initUserSession(context);

        if(UtilProvider.getUserSessionUtil().getSession() != null)
            view.redirectToProfile();
    }

    public void performLogin(final String email, final String password){
        UtilProvider.getUserSessionUtil().setSession(new User(email, password));
        view.redirectToProfile();
    }
}
