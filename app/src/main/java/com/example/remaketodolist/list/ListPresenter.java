package com.example.remaketodolist.list;

import android.content.Context;
import android.content.SharedPreferences;

public class ListPresenter implements ListContract.Presenter{
    private final ListContract.View view;
    public ListPresenter(ListContract.View view){
        this.view = view;
    }

    public void start(){

    }
}
