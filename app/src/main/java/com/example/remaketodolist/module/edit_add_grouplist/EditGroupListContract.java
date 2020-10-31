package com.example.remaketodolist.module.edit_add_grouplist;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;
import com.example.remaketodolist.data.model.GroupSchedule;

public interface EditGroupListContract {
    interface View extends BaseView<Presenter>{
        void redirectToGroupSchedule();
        void showData(GroupSchedule groupSchedule);
        void setId(String id);
    }

    interface Presenter extends BasePresenter{
        void saveData(String title,  String description);
        void loadData(String id);
    }
}
