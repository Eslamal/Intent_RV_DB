package com.example.intent_rv_db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import java.util.ArrayList;

public class rv extends AppCompatActivity {
RecyclerView recyclerView;
ArrayList<Infos>list;
Adapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv);
        recyclerView=findViewById(R.id.rv);
        list=new ArrayList<>();
        list.add(new Infos("   Islam", 22,"   Tanta"));
        adapter=new Adapter(list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
    }
}