package com.bliss.print.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bliss.print.R;
import com.bliss.print.model.JobDescribe;

import java.util.ArrayList;
import java.util.List;

public class JobAdapter extends RecyclerView.Adapter<JobAdapter.ViewHolder> {
    private List<JobDescribe.JobBean> jobBeans = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder{
        View itemView;
        ImageView iv_contact;
        TextView tv_title,tv_price,tv_name,tv_describe,tv_contact;

        public ViewHolder(View view) {
            super(view);
            itemView = view;
            iv_contact = view.findViewById(R.id.iv_contact);
            tv_title = view.findViewById(R.id.tv_title);
            tv_price = view.findViewById(R.id.tv_price);
            tv_name = view.findViewById(R.id.tv_name);
            tv_describe = view.findViewById(R.id.tv_describe);
            tv_contact = view.findViewById(R.id.tv_contact);
        }

    }

    public JobAdapter(List<JobDescribe.JobBean> jobBeans) {
        this.jobBeans = jobBeans;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.job_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int postion = holder.getAdapterPosition();
                JobDescribe.JobBean jobBean = jobBeans.get(postion);
                Toast.makeText(view.getContext(), "你点击了图片"+ jobBean.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        JobDescribe.JobBean jobBean = jobBeans.get(position);
        holder.tv_contact.setText(jobBean.getContact());
        holder.tv_describe.setText(jobBean.getDescribe());
        holder.tv_name.setText(jobBean.getName());
        holder.tv_price.setText(jobBean.getSalary());
        holder.tv_title.setText(jobBean.getTitle());
        holder.iv_contact.setImageResource(jobBean.getImg());

    }

    @Override
    public int getItemCount() {
        return jobBeans.size();
    }
}
