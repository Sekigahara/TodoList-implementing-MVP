package com.example.remaketodolist.dashboard;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface DashboardContract {
    interface View extends BaseView<Presenter> {
        public void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter{

    }
}
