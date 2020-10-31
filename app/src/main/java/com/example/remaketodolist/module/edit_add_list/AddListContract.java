package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface AddListContract {
    interface View extends BaseView<AddListContract.Presenter> {
        void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter {

    }
}
