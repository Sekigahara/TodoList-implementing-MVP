package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class AddListActivity extends BaseFragmentHolderActivity {
    private AddListFragment addListFragment;

    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        addListFragment = new AddListFragment();
        btBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                addListFragment.returnToList();
            }
        });

        setCurrentFragment(addListFragment, false);
    }
}
