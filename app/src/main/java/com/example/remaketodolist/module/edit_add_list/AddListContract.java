package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;
import com.example.remaketodolist.data.model.Schedule;

public interface AddListContract {
    interface View extends BaseView<AddListContract.Presenter> {
        void startingNewActivity(Intent intent);
        void returnToList();
    }

    interface Presenter extends BasePresenter {
        void commitSchedule(Schedule schedule);
    }
}
