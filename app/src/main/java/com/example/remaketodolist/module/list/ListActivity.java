package com.example.remaketodolist.module.list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;
import com.example.remaketodolist.module.login.LoginActivity;
import com.example.remaketodolist.utils.provider.UtilProvider;

public class ListActivity extends BaseFragmentHolderActivity{
    ListFragment listFragment;

    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        listFragment = new ListFragment();
        setCurrentFragment(listFragment, false);

        btBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                UtilProvider.getUserSessionUtil().logout();
                listFragment.gotoLogin();
            }
        });


    }
}
