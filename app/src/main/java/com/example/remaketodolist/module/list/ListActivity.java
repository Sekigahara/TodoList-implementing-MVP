package com.example.remaketodolist.module.list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class ListActivity extends BaseFragmentHolderActivity{
    ListFragment listFragment;

    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        listFragment = new ListFragment();

        String id = getIntent().getExtras().getString("GroupScheduleId");

        setCurrentFragment(listFragment, false);
    }
}
