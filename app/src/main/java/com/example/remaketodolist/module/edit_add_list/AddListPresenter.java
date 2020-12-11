package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;

import com.example.remaketodolist.data.local.TableHandler;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.data.source.SessionRepository;

public class AddListPresenter implements AddListContract.Presenter{
    private final AddListContract.View view;
    private final TableHandler tableHandler;
    private final SessionRepository sessionRepository;

    public AddListPresenter(AddListContract.View view, SessionRepository sessionRepository,TableHandler tableHandler){
        this.view = view;
        this.tableHandler = tableHandler;
        this.sessionRepository = sessionRepository;
    }

    public void start(){

    }

    public void commitSchedule(Schedule schedule){
        tableHandler.create(schedule);

        view.returnToList();
    }
}
