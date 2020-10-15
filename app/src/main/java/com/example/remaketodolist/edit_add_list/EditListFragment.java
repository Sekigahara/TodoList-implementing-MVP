package com.example.remaketodolist.edit_add_list;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.list.ListActivity;

public class EditListFragment extends BaseFragment<EditListActivity, EditListContract.Presenter> implements EditListContract.View{
    private EditText etTitle;
    private EditText etDescription;
    private EditText etDate;
    private Button btCreateUpdate;

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

        return fragmentView;
    }

    protected void returnToList(){
        startingActivity(new Intent(activity, ListActivity.class));
    }

    public void startingActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(EditListContract.Presenter presenter){
        this.mPresenter = presenter;
    }
}
