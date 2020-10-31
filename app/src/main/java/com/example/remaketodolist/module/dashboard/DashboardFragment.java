package com.example.remaketodolist.module.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.data.model.GroupSchedule;
import com.example.remaketodolist.module.edit_add_grouplist.AddGroupListActivity;
import com.example.remaketodolist.module.edit_add_grouplist.EditGroupListActivity;
import com.example.remaketodolist.module.list.ListActivity;
import com.example.remaketodolist.utils.RecycleViewAdapterDashboard;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View{
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FloatingActionButton fbtAdd;
    Button btEdit;
    RecyclerView mRecyclerView;

    public DashboardFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.RecycleViewAdapterDashboard);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<GroupSchedule> data = mPresenter.getDataSet();
        mAdapter = new RecycleViewAdapterDashboard(data);
        mRecyclerView.setAdapter(mAdapter);

        setTitle("List of Todo List");

        fbtAdd = fragmentView.findViewById(R.id.fbtAdd);
        fbtAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask();
            }
        });

        ((RecycleViewAdapterDashboard) mAdapter).setOnItemClickListener(new RecycleViewAdapterDashboard.MyClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                String id = data.get(position).getId();
                Log.d("Dashboard", ">>>>" + position);
                goToSchedule(id);
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(){
        Intent intent = new Intent(activity, AddGroupListActivity.class);
        startActivity(intent);
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }

    public void goToSchedule(String id){
        Intent intent = new Intent(activity, ListActivity.class);
        intent.putExtra("GroupScheduleId", id);
        startActivity(intent);
    }

    public void editTask(){
        Intent intent = new Intent(activity, EditGroupListActivity.class);
        //intent.putExtra("GroupScheduleId", id);
        startActivity(intent);
    }
}