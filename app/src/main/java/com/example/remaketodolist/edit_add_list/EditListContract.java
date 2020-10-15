package com.example.remaketodolist.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.base.BasePresenter;
import com.example.remaketodolist.base.BaseView;

public interface EditListContract {
    interface View extends BaseView<Presenter>{
        public void startingActivity(Intent intent);
    }

    interface Presenter extends BasePresenter{

    }
}
