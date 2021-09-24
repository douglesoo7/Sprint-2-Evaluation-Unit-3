package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SneakerViewAdapter extends RecyclerView.Adapter<SneakerViewHolder> {

    private ItemClickListener itemClickListener;
    private List<ResponseDTO> responseDTOList;

    public SneakerViewAdapter(List<ResponseDTO> responseDTOList){
        this.responseDTOList=responseDTOList;
        //this.itemClickListener=itemClickListener;
    }

    @NonNull

    @Override
    public SneakerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.sneakerlayout,parent,false);
        return new SneakerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SneakerViewHolder holder, int position) {
        holder.setData(responseDTOList.get(position));
    }

    @Override
    public int getItemCount() {
        return responseDTOList.size();
    }
}
