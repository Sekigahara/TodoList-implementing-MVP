package com.example.remaketodolist.edit_add_list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class EditListActivity extends BaseFragmentHolderActivity{
    private EditListFragment editListFragment;

    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        Intent intent = getIntent();

        editListFragment = new EditListFragment();
        btBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editListFragment.returnToList();
            }
        });

        setCurrentFragment(editListFragment, false);
    }
}
