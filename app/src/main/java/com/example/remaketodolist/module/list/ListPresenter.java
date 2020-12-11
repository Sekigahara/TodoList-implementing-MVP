package com.example.remaketodolist.module.list;

import com.example.remaketodolist.data.local.TableHandler;
import com.example.remaketodolist.data.model.Schedule;

import java.util.ArrayList;

public class ListPresenter implements ListContract.Presenter{
    private final ListContract.View view;
    private final TableHandler tableHandler;
    public ListPresenter(ListContract.View view, TableHandler tableHandler){
        this.view = view;
        this.tableHandler = tableHandler;
    }

    public void start(){

    }

    public ArrayList<Schedule> getDataSet(){
        ArrayList<Schedule> data = tableHandler.readAll();
        return data;
    }
}
