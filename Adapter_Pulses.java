package com.infodart.salman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.Subcategory;
import com.infodart.salman.R;
import com.infodart.salman.Util.Click;
import com.infodart.salman.Util.RecyclerViewClickListener;


import java.util.List;

public class Adapter_Pulses extends RecyclerView.Adapter<Adapter_Pulses.MyHolder> {

    Context context;
    List<Subcategory> pulseslist;
    Click click;
    RecyclerViewClickListener recyclerViewClickListener;

    public Adapter_Pulses(Context context, List<Subcategory> pulseslist, Click click) {
        this.context = context;
        this.pulseslist = pulseslist;
        this.click = click;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return pulseslist.size();
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tab_layout_citycart,
                parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder holder, final int position) {

        holder.text.setText(pulseslist.get(position).getName());

        holder.text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.Onclick(pulseslist.get(position).getId(),0);
            }
        });

    }

    public  class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView text;

        public MyHolder(@NonNull final View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.txt_categoryname);
        }

        @Override
        public void onClick(View v) {
            recyclerViewClickListener.recyclerViewListClicked(v,getAdapterPosition());
        }
    }

}

