package com.example.remaketodolist.module.login;

import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class LoginActivity extends BaseFragmentHolderActivity {
    LoginFragment loginFragment;

    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        loginFragment = new LoginFragment();
        setCurrentFragment(loginFragment, false);
    }
}
