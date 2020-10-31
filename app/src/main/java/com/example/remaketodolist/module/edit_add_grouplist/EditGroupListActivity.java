package com.example.remaketodolist.module.edit_add_grouplist;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class EditGroupListActivity extends BaseFragmentHolderActivity{
    EditGroupListFragment editGroupListFragment;
    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        editGroupListFragment = new EditGroupListFragment();

        String id = getIntent().getExtras().getString("GroupScheduleId");
        editGroupListFragment.setId(id);
        setCurrentFragment(editGroupListFragment, false);
    }
}
