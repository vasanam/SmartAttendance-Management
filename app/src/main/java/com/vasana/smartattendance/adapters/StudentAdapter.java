package com.vasana.smartattendance.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vasana.smartattendance.R;
import com.vasana.smartattendance.pojo.MenuOption;
import com.vasana.smartattendance.pojo.StudentPojo;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder> {

    private List<StudentPojo> studentPojoList;
    private RecyclerClickListener recyclerClickListener;
    private Context context;

    public RecyclerClickListener getRecyclerClickListener() {
        return recyclerClickListener;
    }

    public void setRecyclerClickListener(RecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;
    }

    public void setMenuOptionList(List<StudentPojo> studentPojoList) {
        this.studentPojoList = studentPojoList;
        notifyDataSetChanged();
    }

    public StudentAdapter() {
    }

    public StudentAdapter(Context context) {
        this.context = context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView subTitle;
        private final ImageView dp;

        public MyViewHolder(final View view) {
            super(view);
            title = view.findViewById(R.id.label);
            subTitle = view.findViewById(R.id.subLabel);
            dp = view.findViewById(R.id.logo);
        }

    }


    @NonNull
    @Override
    public StudentAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(studentPojoList.get(position).getTitle());
        holder.subTitle.setText("Id : Student id.");
        Glide.with(holder.itemView.
                getContext()).load(studentPojoList.get(position).getDp()).into(holder.dp);
        holder.itemView.setOnClickListener(view -> {
            recyclerClickListener.onclick(position);
        });
    }

    @Override
    public int getItemCount() {
        return studentPojoList.size();
    }
}