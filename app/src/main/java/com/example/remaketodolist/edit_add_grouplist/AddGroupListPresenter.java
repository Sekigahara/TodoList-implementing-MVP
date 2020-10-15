package com.example.remaketodolist.edit_add_grouplist;

import com.example.remaketodolist.edit_add_list.AddListContract;

public class AddGroupListPresenter implements AddGroupListContract.Presenter{
    private final AddGroupListContract.View view;
    public AddGroupListPresenter(AddGroupListContract.View view){
        this.view = view;
    }

    public void start(){

    }
}
