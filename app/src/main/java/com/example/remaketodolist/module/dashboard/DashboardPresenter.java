package com.example.remaketodolist.module.dashboard;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.GroupSchedule;

import java.util.ArrayList;

public class DashboardPresenter implements DashboardContract.Presenter{
    private final DashboardContract.View view;
    public DashboardPresenter(DashboardContract.View view){
        this.view = view;
    }

    public void start() {

    }

    public ArrayList<GroupSchedule> getDataSet(){
        ArrayList<GroupSchedule> data = new ArrayList<>();
        data.add(new GroupSchedule("1", R.mipmap.ic_origami_foreground, "Origami Schedule", "This is Tobiichi Origami Daily Schedule"));
        data.add(new GroupSchedule("2", R.mipmap.ic_guitar_foreground, "Music Exercise", "My Own Music Instrument Excercise"));

        return data;
    }
}
