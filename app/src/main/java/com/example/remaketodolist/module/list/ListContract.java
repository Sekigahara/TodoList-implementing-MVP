package com.example.remaketodolist.module.list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;
import com.example.remaketodolist.data.model.Schedule;

import java.util.ArrayList;

public interface ListContract {
    interface View extends BaseView<ListContract.Presenter> {
        void gotoNewTask();
        void setId(String id);
        void gotoLogin();
    }

    interface Presenter extends BasePresenter {
        ArrayList<Schedule> getDataSet();
    }
}
