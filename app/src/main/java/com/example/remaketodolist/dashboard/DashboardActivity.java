package com.example.remaketodolist.dashboard;

import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;

public class DashboardActivity extends BaseFragmentHolderActivity {
    DashboardFragment dashboardFragment;
    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.GONE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        dashboardFragment = new DashboardFragment();
        setCurrentFragment(dashboardFragment, false);
    }
}
