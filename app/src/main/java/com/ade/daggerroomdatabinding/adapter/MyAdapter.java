package com.ade.daggerroomdatabinding.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.ade.daggerroomdatabinding.R;
import com.ade.daggerroomdatabinding.databinding.MyfeedBinding;
import com.ade.daggerroomdatabinding.entity.User;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<User> myUsers;
    private LayoutInflater layoutInflater;


    public MyAdapter(List<User> myUsers) {
        this.myUsers = myUsers;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        MyfeedBinding binding= DataBindingUtil.inflate(layoutInflater, R.layout.myfeed,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myfeedBinding.setMyus(myUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return myUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final MyfeedBinding myfeedBinding;
        public ViewHolder(MyfeedBinding myfeedBinding) {
            super(myfeedBinding.getRoot());
            this.myfeedBinding=myfeedBinding;
        }
    }
}
