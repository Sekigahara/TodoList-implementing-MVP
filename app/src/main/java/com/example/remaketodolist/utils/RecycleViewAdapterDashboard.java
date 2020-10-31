package com.example.remaketodolist.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.GroupSchedule;

public class RecycleViewAdapterDashboard extends RecyclerView.Adapter<RecycleViewAdapterDashboard.MyViewHolder> {
    private static ArrayList<GroupSchedule> mDataset;
    private static MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView ivListImage;
        TextView tvTitle;
        TextView tvDescription;
        public MyViewHolder(View itemView){
            super(itemView);
            ivListImage = (ImageView) itemView.findViewById(R.id.ivListImage);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitle);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescription);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterDashboard(ArrayList<GroupSchedule> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterDashboard.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_dashboard, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(MyViewHolder holder, int position){
        holder.ivListImage.setImageResource(mDataset.get(position).getImage());
        holder.tvTitle.setText(mDataset.get(position).getTitle());
        holder.tvDescription.setText(mDataset.get(position).getDescription());
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
