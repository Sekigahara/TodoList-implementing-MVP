package com.example.remaketodolist.list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface ListContract {
    interface View extends BaseView<ListContract.Presenter> {
        public void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter {

    }
}
