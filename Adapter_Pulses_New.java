package com.infodart.salman.adapters;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Product;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Productconfig;
import com.infodart.salman.Pojo_Classes.Model_pulsesFragment.ProducTConfig;
import com.infodart.salman.R;
import com.infodart.salman.Util.image_glide;
import com.infodart.salman.Util.url;
import com.infodart.salman.activity.Cart_Category;
import com.infodart.salman.activity.City_cart_Detailed;
import com.infodart.salman.fragments.Pulses_Fragment;

import java.util.List;

public class Adapter_Pulses_New extends RecyclerView.Adapter<Adapter_Pulses_New.ViewHolderClass> {

    private LayoutInflater inflater;
    Context context;
    List<Productconfig> productconfigs;

    public Adapter_Pulses_New(Context context, List<Productconfig> productconfigs) {
        this.context = context;
        this.productconfigs = productconfigs;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public Adapter_Pulses_New.ViewHolderClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.custom_pulses_fragment,
                parent,false);

        return new Adapter_Pulses_New.ViewHolderClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderClass holder, int position){

        image_glide.loadimg(context,holder.pulses, url.PRODUCTBASE,
                productconfigs.get(position).getImagePath());
        holder.pulses_price.setText(productconfigs.get(position).getDiscountedprice());
        holder. pulses_actual_price.setText(productconfigs.get(position).getPrice());
        holder. pulses_discount.setText(productconfigs.get(position).getDiscount()+"% OFF");
        holder.pulses_description.setText(productconfigs.get(position).getDescription());
        holder. pulses_quantity.setText(productconfigs.get(position).getQuantity());
        holder.product_name.setText(productconfigs.get(position).getVariantName());
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return productconfigs.size();
    }

    public class ViewHolderClass extends RecyclerView.ViewHolder {

        ImageView pulses,heart_image;
        TextView pulses_price,pulses_actual_price,pulses_discount,pulses_description,pulses_quantity;
        TextView product_name;


        public ViewHolderClass(@NonNull View itemView) {
            super(itemView);

         pulses = itemView.findViewById(R.id.pulses_image);
         pulses_price = itemView.findViewById(R.id.pulses_price);
         pulses_actual_price = itemView.findViewById(R.id.pulses_actual_price);
         pulses_actual_price.setPaintFlags(pulses_actual_price.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);
         pulses_discount = itemView.findViewById(R.id.pulses_tot_discount);
         heart_image = itemView.findViewById(R.id.heart_image);
         pulses_description = itemView.findViewById(R.id.pulses_description);
         pulses_description.setSelected(true);
         pulses_quantity = itemView.findViewById(R.id.pulses_quantity);
         product_name=itemView.findViewById(R.id.product_name);

         itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(context, City_cart_Detailed.class);
                 intent.putExtra("id", productconfigs.get(0).getProductId());
                 intent.putExtra("product_detail_name",productconfigs.get(0).getVariantName());
                 context.startActivity(intent);

             }
         });
        }
    }
}

