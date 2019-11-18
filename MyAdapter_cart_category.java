package com.infodart.salman.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.infodart.salman.Pojo_Classes.Model_Cart_Category.Category;
import com.infodart.salman.Util.image_glide;
import com.infodart.salman.Util.url;
import com.infodart.salman.activity.Cart_Category_last;
import com.infodart.salman.R;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class MyAdapter_cart_category extends BaseAdapter {

    Context context;
    List<Category> pojo_cart_categories;
    String supermarket_id;
    String subCategoryid;

    public MyAdapter_cart_category(Context context,List<Category> pojo_cart_categories,String supermarket_id){
        this.context = context;
        this.pojo_cart_categories = pojo_cart_categories;
        this.supermarket_id = supermarket_id;
    }

    @Override
    public int getCount() {
        return pojo_cart_categories.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.custom_list_cart_category,
                parent,false);

        TextView title = convertView.findViewById(R.id.cart_category_title);
        ImageView cart_image = convertView.findViewById(R.id.cart_category_Image);

        title.setText(pojo_cart_categories.get(position).getName());
        image_glide.loadimg(context,cart_image, url.cart_img_URL,
                pojo_cart_categories.get(position).getImagePath());



        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subCategoryid = pojo_cart_categories.get(position).getId();

                Intent intent = new Intent(context, Cart_Category_last.class);
                intent.putExtra("SUPERMARKET_ID",supermarket_id);
                intent.putExtra("Id",subCategoryid);
                intent.putExtra("Category_Name",pojo_cart_categories.get(position).getName());

                context.startActivity(intent);

            }
        });


        return convertView;
    }
}
