package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class EditListActivity extends BaseFragmentHolderActivity{
    private EditListFragment editListFragment;

    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        editListFragment = new EditListFragment();
        String id = getIntent().getExtras().getString("ScheduleId");
        editListFragment.setId(id);

        setCurrentFragment(editListFragment, false);
    }
}
