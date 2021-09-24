package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class SneakerViewHolder extends RecyclerView.ViewHolder{

    private LinearLayout linearLayout;
    private ImageView ivSneakerImage;
    private TextView tvShoeName, tvShoePrice;

    public SneakerViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    public void setData(ResponseDTO responseDTOList) {
        Glide.with(ivSneakerImage).load(responseDTOList.getMedia().getImageUrl()).into(ivSneakerImage);
        tvShoeName.setText(responseDTOList.getName());
        tvShoePrice.setText("$"+responseDTOList.getRetailPrice()+"");
    }

    private void initViews(View view) {
        ivSneakerImage=view.findViewById(R.id.sneakerImage);
        tvShoeName=view.findViewById(R.id.tvShoeName);
        tvShoePrice=view.findViewById(R.id.tvShoePrice);
        linearLayout=view.findViewById(R.id.linearLayout);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
