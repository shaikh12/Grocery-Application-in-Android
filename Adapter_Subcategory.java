package com.infodart.salman.adapters;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.Subcategory;

import com.infodart.salman.R;
import com.infodart.salman.Util.image_glide;
import com.infodart.salman.Util.url;

import com.infodart.salman.activity.City_Cart;

import java.util.ArrayList;
import java.util.List;

public class Adapter_Subcategory extends BaseAdapter {

    Context context;
    List<Subcategory> subcategories ;
    String supermarket_id;
    String subCategoryid;
    LayoutInflater inflater;

    public Adapter_Subcategory(Context context, List<Subcategory> pojo_cart_categories,
                               String supermarket_id, String cid){
        this.context = context;
        this.subcategories = pojo_cart_categories;
        this.supermarket_id = supermarket_id;
        this.subCategoryid=cid;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return subcategories.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.custom_list_cart_category,
                parent,false);

        TextView title = convertView.findViewById(R.id.cart_category_title);
        ImageView cart_image = convertView.findViewById(R.id.cart_category_Image);

        title.setText(subcategories.get(position).getName());
        image_glide.loadimg(context,cart_image, url.cart_img_URL,
                subcategories.get(position).getImagePath());


        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, City_Cart.class);

                SharedPreferences sharedPreferences=context.getSharedPreferences
                        ("myprefs", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("SupermarketId",supermarket_id);
                editor.putString("subCategoryid",subcategories.get(position).getId());
                editor.putString("Product_name",subcategories.get(position).getName());
                editor.apply();
                context.startActivity(intent);


            }
        });

        return convertView;
    }
}
