package com.example.remaketodolist.edit_add_grouplist;

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

        Intent intent = getIntent();

        editGroupListFragment = new EditGroupListFragment();
        btBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editGroupListFragment.returnToDashboard();
            }
        });

        setCurrentFragment(editGroupListFragment, false);
    }
}
