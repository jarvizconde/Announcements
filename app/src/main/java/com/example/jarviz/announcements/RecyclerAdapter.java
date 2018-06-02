package com.example.jarviz.announcements;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    @NonNull

        private List <Announcements> announcements;

    public RecyclerAdapter(List<Announcements>announcements)
    {
        this.announcements = announcements;
    }

    public RecyclerAdapter() {

    }

    @Override
    public MyViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder ( MyViewHolder holder, int position) {
       holder.Title.setText(announcements.get(position).getTitle());
       holder.Text.setText(announcements.get(position).getText());
       holder.Date.setText(announcements.get(position).getDate());

    }



    @Override
    public int getItemCount() {
        return announcements.size();
    }


    //dito nagconnect yung sa layout
    public class MyViewHolder extends RecyclerView.ViewHolder {

      TextView Title,Text,Date;
        public MyViewHolder(View itemView) {
            super(itemView);
            Title = (TextView)itemView.findViewById(R.id.titles);
            Text = (TextView)itemView.findViewById(R.id.text);
            Date = (TextView)itemView.findViewById(R.id.date);


        }
    }
}
