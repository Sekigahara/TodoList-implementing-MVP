package com.example.remaketodolist.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface AddListContract {
    interface View extends BaseView<AddListContract.Presenter> {
        public void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter {

    }
}
