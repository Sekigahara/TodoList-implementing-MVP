package com.example.remaketodolist.module.edit_add_grouplist;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.GroupSchedule;

public class EditGroupListPresenter implements EditGroupListContract.Presenter{
    private final EditGroupListContract.View view;
    public EditGroupListPresenter(EditGroupListContract.View view){
        this.view = view;
    }

    public void start(){
    }

    public void saveData(final String title, final String description){
        GroupSchedule groupSchedule = new GroupSchedule("3", R.mipmap.ic_guitar_foreground, "Test", "Test");
        view.redirectToGroupSchedule();
    }

    public void loadData(String id){
        GroupSchedule groupSchedule = new GroupSchedule("3", R.mipmap.ic_guitar_foreground, "Test", "Test");
        view.showData(groupSchedule);
    }
}
