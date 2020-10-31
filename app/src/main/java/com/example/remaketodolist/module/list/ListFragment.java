package com.example.remaketodolist.module.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.module.dashboard.DashboardActivity;
import com.example.remaketodolist.module.edit_add_list.AddListActivity;
import com.example.remaketodolist.module.edit_add_list.EditListActivity;
import com.example.remaketodolist.utils.RecycleViewAdapterList;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View {
    RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    String id;
    FloatingActionButton fbtAdd;

    public ListFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new ListPresenter(this);
        mPresenter.start();

        mRecyclerView = fragmentView.findViewById(R.id.RecycleViewAdapterList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        final ArrayList<Schedule> data = mPresenter.getDataSet();
        mAdapter = new RecycleViewAdapterList(data);
        mRecyclerView.setAdapter(mAdapter);

        setTitle("Schedule");

        fbtAdd = fragmentView.findViewById(R.id.fbtAdd);
        fbtAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask();
            }
        });

        ((RecycleViewAdapterList) mAdapter).setOnItemClickListener(new RecycleViewAdapterList.MyClickListener(){
            public void onItemClick(int position, View view){
                String id = data.get(position).getId();
                Log.d("Schedule Activity", ">>>>>" + position);
                editTask(id);
            }
        });

        return fragmentView;
    }

    public void gotoNewTask(){
        Intent intent = new Intent(activity, AddListActivity.class);
        startActivity(intent);
    }

    public void editTask(String id){
        Intent intent = new Intent(activity, EditListActivity.class);
        intent.putExtra("ScheduleId", id);
        startActivity(intent);
    }

    public void setId(String id){
        this.id = id;
    }

    public void showData(Schedule schedule){

    }

    public void setPresenter(ListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
