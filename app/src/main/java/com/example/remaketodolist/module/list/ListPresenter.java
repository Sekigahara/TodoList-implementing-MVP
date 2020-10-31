package com.example.remaketodolist.module.list;

import com.example.remaketodolist.data.model.Schedule;

import java.util.ArrayList;

public class ListPresenter implements ListContract.Presenter{
    private final ListContract.View view;
    public ListPresenter(ListContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public ArrayList<Schedule> getDataSet(){
        ArrayList<Schedule> data = new ArrayList<>();
        data.add(new Schedule("1", "Piano", "Piano Exercise", "20-10-2020"));
        data.add(new Schedule("2", "Guitar", "Guitar Exercise", "21-10-2020"));
        return data;
    }
}
