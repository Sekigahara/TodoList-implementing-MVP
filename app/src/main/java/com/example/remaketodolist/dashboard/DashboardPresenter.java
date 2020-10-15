package com.example.remaketodolist.dashboard;

import android.content.Context;
import android.content.SharedPreferences;

public class DashboardPresenter implements DashboardContract.Presenter{
    private final DashboardContract.View view;
    public DashboardPresenter(DashboardContract.View view){
        this.view = view;
    }

    public void start() {

    }
}
