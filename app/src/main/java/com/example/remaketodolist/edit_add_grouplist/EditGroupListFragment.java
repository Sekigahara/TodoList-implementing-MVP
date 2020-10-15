package com.example.remaketodolist.edit_add_grouplist;

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
import com.example.remaketodolist.dashboard.DashboardActivity;

public class EditGroupListFragment extends BaseFragment<EditGroupListActivity, EditGroupListContract.Presenter> implements EditGroupListContract.View{
    EditText etTitle;
    EditText etDescription;
    ImageView ivImage;
    Button btCreateUpdate;

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

        btCreateUpdate.setText("Edit");
        setTitle("Edit Group List");

        return fragmentView;
    }

    protected void returnToDashboard(){
        startingActivity(new Intent(activity, DashboardActivity.class));
    }

    public void startingActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(EditGroupListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
