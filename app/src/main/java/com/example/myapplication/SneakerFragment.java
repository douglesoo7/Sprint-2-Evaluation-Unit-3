package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SneakerFragment extends Fragment {

    SneakerViewAdapter sneakerViewAdapter;
    private List<ResponseDTO> responseDTOList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sneaker,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewSneakers);
        callAPI();
        Log.d("sachin", "onviewcreated");

    }

    private void callAPI() {
        ApiInterface apiInterface = Network.getInstance().create(ApiInterface.class);
        apiInterface.getSneakers().enqueue(new Callback<List<ResponseDTO>>() {
            @Override
            public void onResponse(Call<List<ResponseDTO>> call, Response<List<ResponseDTO>> response) {
                if (response.isSuccessful()) {
                    responseDTOList = response.body();
                    setRecyclerView();
                    Log.d("sachin", "success");
                }
            }

            @Override
            public void onFailure(Call<List<ResponseDTO>> call, Throwable t) {
                t.printStackTrace();
                Log.d("sachin", "unsuccess");
            }
        });
    }

    private void setRecyclerView() {
        sneakerViewAdapter = new SneakerViewAdapter(responseDTOList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setAdapter(sneakerViewAdapter);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}