package com.infodart.salman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.infodart.salman.Pojo_Classes.HomePageNew.list;
import com.infodart.salman.Pojo_Classes.Model_HomePage.ChildHomeResponse;
import com.infodart.salman.R;
import com.infodart.salman.Util.image_glide;
import com.infodart.salman.Util.url;

import java.util.ArrayList;
import java.util.List;

public class AdapterRecyclerGrid extends RecyclerView.Adapter<AdapterRecyclerGrid.MyHolder> {

    public Context context;
    List<ChildHomeResponse> arrayList;
    private OnNoteListener onNoteListener;

    public AdapterRecyclerGrid(Context context, List<ChildHomeResponse> arrayList,OnNoteListener onNoteListener ){
        this.context = context;
        this.arrayList = arrayList;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.custom_list,parent,false);
        MyHolder myHolder = new MyHolder(view,onNoteListener);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

        holder.title.setText(arrayList.get(position).getName());
        holder.desciption.setText(arrayList.get(position).getAddress());

        // inserting the image through Glide Library
        image_glide.loadimg(context,holder.image, url.img_URL,
                arrayList.get(position).getImage_path());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public  class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title,desciption;
        ImageView image;

        OnNoteListener onNoteListener;

        public MyHolder(@NonNull final View itemView,OnNoteListener onNoteListener) {
            super(itemView);

            title = itemView.findViewById(R.id.textview_superMarket);
            desciption =itemView.findViewById(R.id.textview_superMarket_Description);
            image = itemView.findViewById(R.id.image_cardview);

            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onClick(getAdapterPosition());
        }
    }

    public interface OnNoteListener{
        void onClick(int position);
    }

}
