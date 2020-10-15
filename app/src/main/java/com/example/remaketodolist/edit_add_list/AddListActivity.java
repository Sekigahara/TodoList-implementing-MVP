package com.example.remaketodolist.edit_add_list;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class AddListActivity extends BaseFragmentHolderActivity {
    private AddListFragment addListFragment;

    protected void initializeFragment() {
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        Intent intent = getIntent();

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
