package com.example.remaketodolist.module.edit_add_grouplist;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class AddGroupListActivity extends BaseFragmentHolderActivity {
    AddGroupListFragment addGroupListFragment;
    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        addGroupListFragment = new AddGroupListFragment();

        setCurrentFragment(addGroupListFragment,false);
    }
}
