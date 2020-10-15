package com.example.remaketodolist.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.base.BaseFragment;
import com.example.remaketodolist.edit_add_grouplist.AddGroupListActivity;
import com.example.remaketodolist.edit_add_grouplist.AddGroupListContract;
import com.example.remaketodolist.edit_add_grouplist.EditGroupListActivity;
import com.example.remaketodolist.list.ListActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DashboardFragment extends BaseFragment<DashboardActivity, DashboardContract.Presenter> implements DashboardContract.View{
    FloatingActionButton fbtAdd;
    ImageButton ivListImage;
    TextView tvTitle;
    TextView tvDescription;
    Button btEdit;
    Button btDelete;

    public DashboardFragment(){

    }

    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        mPresenter = new DashboardPresenter(this);
        mPresenter.start();

        ivListImage = fragmentView.findViewById(R.id.ivListImage);
        tvTitle = fragmentView.findViewById(R.id.tvTitle);
        tvDescription = fragmentView.findViewById(R.id.tvDescription);
        btEdit = fragmentView.findViewById(R.id.btEdit);
        btDelete = fragmentView.findViewById(R.id.btDelete);
        fbtAdd = fragmentView.findViewById(R.id.fbtAdd);

        btEdit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                redirectToEdit();
            }
        });

        ivListImage.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                redirectToList();
            }
        });

        fbtAdd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                redirectToGroupAdd();
            }
        });

        setData();
        setTitle("Group List");

        return fragmentView;
    }

    private void setData(){
        ivListImage.setImageResource(R.mipmap.ic_origami_foreground);
        tvTitle.setText("Origami Tobiichi Schedule");
        tvDescription.setText("This is About Origami Tobiichi daily Task");
    }

    public void redirectToEdit(){
        startingActivity(new Intent(activity, EditGroupListActivity.class));
    }

    public void redirectToList(){
        startingActivity(new Intent(activity, ListActivity.class));
    }

    public void redirectToGroupAdd(){
        startingActivity(new Intent(activity, AddGroupListActivity.class));
    }

    protected void returnToDashboard(){
        startingActivity(new Intent(activity, DashboardActivity.class));
    }

    public void startingActivity(Intent intent){
        startActivity(intent);
        activity.finish();
    }

    public void setPresenter(DashboardContract.Presenter presenter){
        mPresenter = presenter;
    }
}
