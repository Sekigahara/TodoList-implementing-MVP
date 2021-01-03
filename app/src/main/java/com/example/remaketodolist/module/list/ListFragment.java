package com.example.remaketodolist.module.list;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.data.local.ScheduleTableHandler;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.module.edit_add_list.AddListActivity;
import com.example.remaketodolist.module.edit_add_list.EditListActivity;
import com.example.remaketodolist.module.login.LoginActivity;
import com.example.remaketodolist.utils.RecycleViewAdapterList;
import com.example.remaketodolist.utils.provider.UtilProvider;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ListFragment extends BaseFragment<ListActivity, ListContract.Presenter> implements ListContract.View, GoogleApiClient.OnConnectionFailedListener {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    RecyclerView mRecyclerView;
    String id;
    ImageButton btBack;
    FloatingActionButton fbtAdd;

    public ListFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_list, container, false);
        mPresenter = new ListPresenter(this, new ScheduleTableHandler(activity));
        mPresenter.start();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(getContext())
                .enableAutoManage(activity, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API)
                .build();

        mRecyclerView = fragmentView.findViewById(R.id.RecycleViewAdapterList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(activity);
        mRecyclerView.setLayoutManager(mLayoutManager);

        setTitle("Schedule");

        if(mPresenter.getDataSet() == null)
            Toast.makeText(activity, "you don't Have any Todo List", Toast.LENGTH_SHORT).show();
        else{
            final ArrayList<Schedule> data = mPresenter.getDataSet();
            mAdapter = new RecycleViewAdapterList(data, new ScheduleTableHandler(getActivity()), activity);
            mRecyclerView.setAdapter(mAdapter);
            ((RecycleViewAdapterList) mAdapter).setOnItemClickListener(new RecycleViewAdapterList.MyClickListener(){
                public void onItemClick(int position, View view){
                    String id = data.get(position).getId();
                    editTask(id);
                }
            });
        }

        fbtAdd = fragmentView.findViewById(R.id.fbtAdd);
        fbtAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                gotoNewTask();
            }
        });

        return fragmentView;
    }

    public void setBtBack(ImageButton btBack){
        this.btBack = btBack;

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {
                FirebaseAuth.getInstance().signOut();
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(@NonNull Status status) {
                                if(status.isSuccess()){
                                    UtilProvider.getUserSessionUtil().logout();
                                    Intent intent = new Intent(activity, LoginActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(activity,"Logout Successful", Toast.LENGTH_LONG).show();
                                }else{
                                    Toast.makeText(activity,"Session not close", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                );
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult){

    }

    public void gotoNewTask(){
        Intent intent = new Intent(activity, AddListActivity.class);
        startActivity(intent);

    }

    public void gotoLogin(){
        Intent intent = new Intent(activity, LoginActivity.class);
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

    public void setPresenter(ListContract.Presenter presenter){
        mPresenter = presenter;
    }
}
