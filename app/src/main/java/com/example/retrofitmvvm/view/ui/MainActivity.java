package com.example.retrofitmvvm.view.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.retrofitmvvm.R;
import com.example.retrofitmvvm.service.model.Model;
import com.example.retrofitmvvm.view.adapter.RecyclerAdapter;
import com.example.retrofitmvvm.viewmodel.RetrofitViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_xml);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RetrofitViewModel retrofitViewModel = ViewModelProviders.of(MainActivity.this).get(RetrofitViewModel.class);

        retrofitViewModel.getHeroes().observe(this, new Observer<List<Model>>()
        {
            @Override
            public void onChanged(@Nullable List<Model> resList)
            {
                adapter = new RecyclerAdapter(MainActivity.this, resList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}
