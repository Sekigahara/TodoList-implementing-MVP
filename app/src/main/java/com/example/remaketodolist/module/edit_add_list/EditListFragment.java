package com.example.remaketodolist.module.edit_add_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.module.list.ListActivity;

public class EditListFragment extends BaseFragment<EditListActivity, EditListContract.Presenter> implements EditListContract.View{
    private EditText etTitle;
    private EditText etDescription;
    private EditText etDate;
    private Button btCreateUpdate;
    String id;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_update_list,container,false);
        mPresenter = new EditListPresenter(this);
        mPresenter.start();

        etTitle = fragmentView.findViewById(R.id.etTitle);
        etDescription = fragmentView.findViewById(R.id.etDescription);
        etDate = fragmentView.findViewById(R.id.etDate);
        btCreateUpdate = fragmentView.findViewById(R.id.btCreateUpdate);

        btCreateUpdate.setText("Update");
        setTitle("Edit Your List");

        mPresenter.loadData(this.id);

        return fragmentView;
    }


    public void setBtSaveClick(){
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        mPresenter.saveData(title,description);
    }

    @Override
    public void setPresenter(EditListContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void redirectToScheduleList() {
        Intent intent = new Intent(activity, ListActivity.class);
        startActivity(intent);
        activity.finish();
    }

    @Override
    public void showData(Schedule schedule) {
        this.etTitle.setText(schedule.getTitle());
        this.etDescription.setText(schedule.getDescription());
    }

    @Override
    public void setId(String id) {
        this.id=id;
    }
}
