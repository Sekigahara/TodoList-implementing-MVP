package com.example.remaketodolist.edit_add_list;

import android.content.SharedPreferences;

public class EditListPresenter implements EditListContract.Presenter{
    private final EditListContract.View view;

    public EditListPresenter(EditListContract.View view){
        this.view = view;
    }

    public void start(){

    }
}
