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
import com.example.remaketodolist.data.local.ScheduleTableHandler;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.data.source.ScheduleSessionRepository;
import com.example.remaketodolist.module.list.ListActivity;

public class AddListFragment extends BaseFragment<AddListActivity, AddListContract.Presenter> implements AddListContract.View{
    private EditText etTitle;
    private EditText etDescription;
    private EditText etDate;
    private Button btCreateUpdate;

    public AddListFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_update_list,container,false);
        mPresenter = new AddListPresenter(this, new ScheduleSessionRepository(getActivity()), new ScheduleTableHandler(getActivity()));
        mPresenter.start();

        etTitle = fragmentView.findViewById(R.id.etTitle);
        etDescription = fragmentView.findViewById(R.id.etDescription);
        etDate = fragmentView.findViewById(R.id.etDate);
        btCreateUpdate = fragmentView.findViewById(R.id.btCreateUpdate);

        btCreateUpdate.setText("Add");
        btCreateUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String title = etTitle.getText().toString();
                String description = etDescription.getText().toString();
                String date = etDate.getText().toString();

                mPresenter.commitSchedule(new Schedule(title, description, date, 0));
            }
        });

        setTitle("Add Your List");

        return fragmentView;
    }

    public void returnToList(){
        startingNewActivity(new Intent(activity, ListActivity.class));
    }

    public void startingNewActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(AddListContract.Presenter presenter){
        this.mPresenter = presenter;
    }
}
