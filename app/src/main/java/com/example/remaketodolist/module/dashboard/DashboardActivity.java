package com.example.remaketodolist.module.dashboard;

import android.content.Intent;
import android.view.View;

import com.example.remaketodolist.base.BaseFragmentHolderActivity;
import com.example.remaketodolist.module.login.LoginActivity;
import com.example.remaketodolist.utils.provider.UserSessionUtil;
import com.example.remaketodolist.utils.provider.UtilProvider;

public class DashboardActivity extends BaseFragmentHolderActivity {
    DashboardFragment dashboardFragment;
    protected void initializeFragment(){
        initializeView();

        btBack.setVisibility(View.VISIBLE);
        btOptionMenu.setVisibility(View.GONE);
        ivIcon.setVisibility(View.GONE);

        dashboardFragment = new DashboardFragment();

        btBack.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                UtilProvider.getUserSessionUtil().logout();
                Intent intent = new Intent(dashboardFragment.getContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
        setCurrentFragment(dashboardFragment, false);
    }
}
