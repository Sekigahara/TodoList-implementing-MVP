package com.example.remaketodolist.list;

import android.app.Activity;
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
import com.example.remaketodolist.dashboard.DashboardActivity;
import com.example.remaketodolist.edit_add_list.AddListActivity;
import com.example.remaketodolist.edit_add_list.EditListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {
    FloatingActionButton fbtAdd;
    TextView tvDate;
    TextView tvTitleList;
    TextView tvDescriptionList;
    Button btEdit;
    Button btDelete;

    public ListFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new ListPresenter(this);
        mPresenter.start();

        tvDate = fragmentView.findViewById(R.id.tvDate);
        tvTitleList = fragmentView.findViewById(R.id.tvTitleList);
        tvDescriptionList = fragmentView.findViewById(R.id.tvDescriptionList);
        btEdit = fragmentView.findViewById(R.id.btEdit);
        btDelete = fragmentView.findViewById(R.id.btDelete);
        fbtAdd = fragmentView.findViewById(R.id.fbtAdd);

        fbtAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                redirectToAddList();
            }
        });

        btEdit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                redirectToEditList();
            }
        });

        setData();
        setTitle("List : todo list");

        return fragmentView;
    }

    public void redirectToAddList(){
        startingActivity(new Intent(activity, AddListActivity.class));
    }

    public void redirectToEditList(){
        startingActivity(new Intent(activity, EditListActivity.class));
    }

    private void setData(){
        tvDate.setText("Saturday, 8 April 2020");
        tvTitleList.setText("Attend to AST Meeting");
        tvDescriptionList.setText("Held at 19:00 PM in AST Base");
    }

    protected void returnToDashboard(){
        startingActivity(new Intent(activity, DashboardActivity.class));
    }

    public void startingActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(ListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
