package com.example.intent_rv_db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.viewHolder> {
     ArrayList<Infos>arrayList;

    public Adapter(ArrayList<Infos> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.list,null,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.viewHolder holder, int position) {
            Infos infos=arrayList.get(position);
            holder.textView1.setText(infos.getName());
            holder.textView2.setText(infos.getAge()+"");
            holder.textView3.setText(infos.getAddress());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView textView1,textView2,textView3;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView2);
            textView2=itemView.findViewById(R.id.textView7);
            textView3=itemView.findViewById(R.id.textView8);
        }
    }
}
