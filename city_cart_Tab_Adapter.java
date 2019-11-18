package com.infodart.salman.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.infodart.salman.R;
import com.infodart.salman.Util.RecyclerViewClickListener;

public class city_cart_Tab_Adapter extends RecyclerView.Adapter<city_cart_Tab_Adapter.MyHolder> {

    Context context;
    //String[] list;
    private  RecyclerViewClickListener itemListener;

    public city_cart_Tab_Adapter(Context context,RecyclerViewClickListener itemListener) {
        this.context=context;
        //this.list=list;
        this.itemListener=itemListener;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_layout_citycart, parent, false);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {

       // holder.text.setText(list[position]);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        TextView text;


        public MyHolder(@NonNull View itemView) {
            super(itemView);

            text=itemView.findViewById(R.id.txt_categoryname);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v,getAdapterPosition());
        }
    }
}
