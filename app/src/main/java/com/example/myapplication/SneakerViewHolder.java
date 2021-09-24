package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SneakerViewHolder extends RecyclerView.ViewHolder{

    private ItemClickListener itemClickListener;
    private LinearLayout linearLayout;
    private ImageView ivSneakerImage;
    private TextView tvShoeName, tvShoePrice;

    public SneakerViewHolder(@NonNull View itemView) {
        super(itemView);
        //this.itemClickListener=itemClickListener;
        initViews(itemView);
    }

    public void setData(ResponseDTO responseDTOList) {
        Glide.with(ivSneakerImage).load(responseDTOList.getMedia().getImageUrl()).into(ivSneakerImage);
        tvShoeName.setText(responseDTOList.getName());
        tvShoePrice.setText("$"+responseDTOList.getRetailPrice()+"");
        /*linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.onItemClicked(responseDTOList,getAdapterPosition());
            }
        });*/
    }

    private void initViews(View view) {
        linearLayout=view.findViewById(R.id.linearLayout);
        ivSneakerImage=view.findViewById(R.id.sneakerImage);
        tvShoeName=view.findViewById(R.id.tvShoeName);
        tvShoePrice=view.findViewById(R.id.tvShoePrice);
    }
}
