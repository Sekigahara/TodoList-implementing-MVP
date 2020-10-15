package com.example.remaketodolist.edit_add_grouplist;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface AddGroupListContract {
    interface View extends BaseView<Presenter>{
        public void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter{

    }
}
