package com.example.remaketodolist.list;

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

        Intent intent = getIntent();

        listFragment = new ListFragment();

        btBack.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                listFragment.returnToDashboard();
            }
        });

        setCurrentFragment(listFragment, false);
    }
}
