package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;
import com.example.remaketodolist.data.model.Schedule;

public interface EditListContract {
    interface View extends BaseView<Presenter>{
        void redirectToScheduleList();
        void showData(Schedule schedule);
        void setId(String id);
    }

    interface Presenter extends BasePresenter{
        void saveData(Schedule schedule);
        void loadData(String id);
    }
}
