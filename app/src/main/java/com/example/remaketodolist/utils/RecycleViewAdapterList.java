package com.example.remaketodolist.utils;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.local.TableHandler;
import com.example.remaketodolist.data.model.Schedule;
import com.example.remaketodolist.utils.provider.UtilProvider;

import java.util.ArrayList;

public class RecycleViewAdapterList extends RecyclerView.Adapter<RecycleViewAdapterList.MyViewHolder> {
    private static ArrayList<Schedule> mDataset;
    private static RecycleViewAdapterList.MyClickListener myClickListener;
    private Activity activity;
    private TableHandler tableHandler;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle;
        TextView tvDescription;
        TextView tvDate;
        Button btDelete;
        Button btShare;
        CheckBox cbIsDone;
        public MyViewHolder(final View itemView, final Activity activity){
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitleList);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescriptionList);
            btDelete = (Button) itemView.findViewById(R.id.btDelete);
            btShare = (Button) itemView.findViewById(R.id.btShare);
            cbIsDone = (CheckBox) itemView.findViewById(R.id.cbIsDone);

            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterList(ArrayList<Schedule> myDataset, TableHandler tableHandler, Activity activity){
        mDataset = myDataset;
        this.tableHandler = tableHandler;
        this.activity = activity;
    }

    public RecycleViewAdapterList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list, parent, false);
        RecycleViewAdapterList.MyViewHolder myViewHolder = new RecycleViewAdapterList.MyViewHolder(view, activity);

        return myViewHolder;
    }

    public void onBindViewHolder(RecycleViewAdapterList.MyViewHolder holder, final int position){
        if(mDataset.get(position) != null){
            holder.tvTitle.setText(mDataset.get(position).getTitle());
            holder.tvDescription.setText(mDataset.get(position).getDescription());
            holder.tvDate.setText(mDataset.get(position).getDate());

            Integer isDone = mDataset.get(position).getIsDone();
            if(isDone == 1)
                holder.cbIsDone.setChecked(true);
            else if(isDone == 0)
                holder.cbIsDone.setChecked(false);

            holder.cbIsDone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    final Schedule schedule = mDataset.get(position);
                    if(isChecked) {
                        schedule.setIsDone(1);
                    }
                    else {
                        schedule.setIsDone(0);
                    }

                    ThreadUI.runOnUI(new Runnable() {
                        @Override
                        public void run() {
                            mDataset.set(position, schedule);
                            notifyItemChanged(position);
                            tableHandler.update(schedule);
                        }
                    });
                }
            });

            holder.btDelete.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    tableHandler.delete(Integer.parseInt(mDataset.get(position).getId()));
                    mDataset.remove(position);
                    notifyItemRemoved(position);
                }
            });

            holder.btShare.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    String email = UtilProvider.getUserSessionUtil().getSession().getEmail();
                    String displayName = UtilProvider.getUserSessionUtil().getSession().getDisplayName();
                    String date = mDataset.get(position).getDate();
                    String title = mDataset.get(position).getTitle();
                    String description = mDataset.get(position).getDescription();
                    String doneTask = "";

                    int isDone = mDataset.get(position).getIsDone();
                    if(isDone == 0)
                        doneTask = "Incomplete";
                    else if(isDone == 1)
                        doneTask = "Completed";

                    String sentText = "Todo List by : " + displayName + "\n" +
                                      "Account      : " + email       + "\n" +
                                      "Date         : " + date        + "\n" +
                                      "Activity     : " + title       + "\n" +
                                      "Description  : " + description + "\n" +
                                      "Status       : " + doneTask    + "\n" ;

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_TEXT, sentText);
                    intent.setType("text/plain");

                    Intent shareIntent = Intent.createChooser(intent, null);
                    activity.startActivity(shareIntent);
                }
            });
        }
    }

    public int getItemCount(){
        return mDataset.size();
    }

    public void setOnItemClickListener(MyClickListener myClickListener){
        this.myClickListener = myClickListener;
    }

    public interface MyClickListener{
        public void onItemClick(int position, View view);
    }
}
