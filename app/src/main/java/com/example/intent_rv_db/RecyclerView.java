package com.example.intent_rv_db;

import  androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerView extends AppCompatActivity {
Button button;
TextView textView1,textView2,textView3,textView4;
StringBuilder stringBuilder1,stringBuilder2,stringBuilder3,stringBuilder4 ;
    DataBase dataBase=new DataBase(this,"data",null,3);
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        button=findViewById(R.id.button7);
        textView1=findViewById(R.id.textView6);
        textView2=findViewById(R.id.textView5);
        textView3=findViewById(R.id.textView4);
        textView4=findViewById(R.id.textView3);
        stringBuilder1=new StringBuilder();
        stringBuilder2=new StringBuilder();
        stringBuilder3=new StringBuilder();
        stringBuilder4=new StringBuilder();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Infos>infosArrayList=dataBase.retrive();
                for(Infos iin:infosArrayList){
                    stringBuilder1.append(iin.getId()+"\n");
                    stringBuilder2.append(iin.getName()+"\n");
                    stringBuilder3.append(iin.getAge()+"\n");
                    stringBuilder4.append(iin.getAddress()+"\n");
                }
                textView1.setText(stringBuilder1);
                textView2.setText(stringBuilder2);
                textView3.setText(stringBuilder3);
                textView4.setText(stringBuilder4);

            }
        });

    }
}