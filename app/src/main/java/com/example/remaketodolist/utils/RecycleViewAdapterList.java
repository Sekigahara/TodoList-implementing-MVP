package com.example.remaketodolist.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.remaketodolist.R;
import com.example.remaketodolist.data.model.Schedule;

import java.util.ArrayList;

public class RecycleViewAdapterList extends RecyclerView.Adapter<RecycleViewAdapterList.MyViewHolder> {
    private static ArrayList<Schedule> mDataset;
    private static RecycleViewAdapterList.MyClickListener myClickListener;

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle;
        TextView tvDescription;
        TextView tvDate;
        public MyViewHolder(View itemView){
            super(itemView);
            tvDate = (TextView) itemView.findViewById(R.id.tvDate);
            tvTitle = (TextView) itemView.findViewById(R.id.tvTitleList);
            tvDescription = (TextView) itemView.findViewById(R.id.tvDescriptionList);
            itemView.setOnClickListener(this);
        }

        public void onClick(View view){
            int position = getAdapterPosition();
            myClickListener.onItemClick(position, view);
        }
    }

    public RecycleViewAdapterList(ArrayList<Schedule> myDataset){
        mDataset = myDataset;
    }

    public RecycleViewAdapterList.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_list, parent, false);
        RecycleViewAdapterList.MyViewHolder myViewHolder = new RecycleViewAdapterList.MyViewHolder(view);

        return myViewHolder;
    }

    public void onBindViewHolder(RecycleViewAdapterList.MyViewHolder holder, int position){
        holder.tvTitle.setText(mDataset.get(position).getTitle());
        holder.tvDescription.setText(mDataset.get(position).getDescription());
        holder.tvDate.setText(mDataset.get(position).getDate());
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
