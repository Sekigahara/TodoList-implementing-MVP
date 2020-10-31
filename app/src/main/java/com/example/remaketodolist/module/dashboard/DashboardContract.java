package com.example.remaketodolist.module.dashboard;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;
import com.example.remaketodolist.data.model.GroupSchedule;

import java.util.ArrayList;

public interface DashboardContract {
    interface View extends BaseView<Presenter> {
        void gotoNewTask();
    }

    interface Presenter extends BasePresenter{
        ArrayList<GroupSchedule> getDataSet();
    }
}
