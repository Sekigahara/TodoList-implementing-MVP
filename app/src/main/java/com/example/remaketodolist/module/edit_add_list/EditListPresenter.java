package com.example.remaketodolist.module.edit_add_list;

import com.example.remaketodolist.data.model.Schedule;

public class EditListPresenter implements EditListContract.Presenter{
    private final EditListContract.View view;

    public EditListPresenter(EditListContract.View view){
        this.view = view;
    }

    public void start(){

    }

    public void saveData(final String title, final String description){
        Schedule schedule = new Schedule("2", title, description, "Saturday");
        view.redirectToScheduleList();
    }

    public void loadData(String id){
        Schedule schedule = new Schedule("2", "Test", "try schedule", "Saturday");
        view.showData(schedule);
    }

}
