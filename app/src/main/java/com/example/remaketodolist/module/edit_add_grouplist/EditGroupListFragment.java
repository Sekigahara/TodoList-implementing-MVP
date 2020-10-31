package com.example.remaketodolist.module.edit_add_grouplist;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.GroupSchedule;
import com.example.remaketodolist.module.dashboard.DashboardActivity;

public class EditGroupListFragment extends BaseFragment<EditGroupListActivity, EditGroupListContract.Presenter> implements EditGroupListContract.View{
    EditText etTitle;
    EditText etDescription;
    ImageView ivImage;
    Button btCreateUpdate;
    String id;

    public EditGroupListFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_add_update_grouplist, container, false);
        mPresenter = new EditGroupListPresenter(this);
        mPresenter.start();

        etTitle = fragmentView.findViewById(R.id.etTitle);
        etDescription = fragmentView.findViewById(R.id.etDescription);
        ivImage = fragmentView.findViewById(R.id.ivImage);
        btCreateUpdate = fragmentView.findViewById(R.id.btCreateUpdate);

        btCreateUpdate.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                setBtSaveClick();
            }
        });

        btCreateUpdate.setText("Edit");
        setTitle("Edit Group List");

        return fragmentView;
    }

    public void setBtSaveClick(){
        String title = etTitle.getText().toString();
        String description = etDescription.getText().toString();
        mPresenter.saveData(title, description);
    }

    public void setPresenter(EditGroupListContract.Presenter presenter){
        mPresenter = presenter;
    }

    public void redirectToGroupSchedule(){
        Intent intent = new Intent(activity, DashboardActivity.class);
        startActivity(intent);
        activity.finish();
    }

    public void showData(GroupSchedule groupSchedule){
        this.ivImage.setImageResource(groupSchedule.getImage());
        this.etTitle.setText(groupSchedule.getTitle());
        this.etDescription.setText(groupSchedule.getDescription());
    }

    public void setId(String id){
        this.id = id;
    }
}
