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
        mPresenter = new AddListPresenter(this);
        mPresenter.start();

        etTitle = fragmentView.findViewById(R.id.etTitle);
        etDescription = fragmentView.findViewById(R.id.etDescription);
        etDate = fragmentView.findViewById(R.id.etDate);
        btCreateUpdate = fragmentView.findViewById(R.id.btCreateUpdate);

        btCreateUpdate.setText("Add");
        setTitle("Add Your List");

        return fragmentView;
    }

    protected void returnToList(){
        startingActivity(new Intent(activity, ListActivity.class));
    }

    public void startingActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(AddListContract.Presenter presenter){
        this.mPresenter = presenter;
    }
}