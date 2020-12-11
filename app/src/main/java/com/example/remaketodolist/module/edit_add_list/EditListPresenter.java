package com.example.remaketodolist.module.edit_add_list;

import com.example.remaketodolist.data.local.TableHandler;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.data.source.SessionRepository;

public class EditListPresenter implements EditListContract.Presenter{
    private final EditListContract.View view;
    private final TableHandler tableHandler;
    private final SessionRepository sessionRepository;

    public EditListPresenter(EditListContract.View view, SessionRepository sessionRepository,TableHandler tableHandler){
        this.view = view;
        this.tableHandler = tableHandler;
        this.sessionRepository = sessionRepository;
    }

    public void start(){

    }

    public void saveData(Schedule schedule){
        tableHandler.update(schedule);

        view.redirectToScheduleList();
    }

    public void loadData(String id){
        Schedule schedule = (Schedule) tableHandler.readById(id);
        view.showData(schedule);
    }

}
