package com.example.remaketodolist.module.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.module.dashboard.DashboardActivity;

public class LoginFragment extends BaseFragment<LoginActivity, LoginContract.Presenter> implements LoginContract.View {
    EditText etEmail;
    EditText etPassword;
    Button btLogin;

    public LoginFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_login, container, false);
        mPresenter = new LoginPresenter(this);
        mPresenter.start();

        etEmail = fragmentView.findViewById(R.id.etEmail);
        etPassword = fragmentView.findViewById(R.id.etPassword);
        btLogin = fragmentView.findViewById(R.id.btLogin);
        btLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setBtnLoginClick();
            }
        });

        setTitle("To Do List Login");

        return fragmentView;
    }

    public void setBtnLoginClick(){
        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();
        mPresenter.performLogin(email, password);
    }

    public void setPresenter(LoginContract.Presenter presenter){
        mPresenter = presenter;
    }

    public void redirectToProfile(){
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }
}
