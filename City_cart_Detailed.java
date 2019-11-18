package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Example_cityCart;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Productconfig;
import com.infodart.salman.Pojo_Classes.Model_pulsesFragment.Example_cityCart1;
import com.infodart.salman.Pojo_Classes.Model_pulsesFragment.ProducTConfig;
import com.infodart.salman.R;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.Util.image_glide;
import com.infodart.salman.Util.url;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class City_cart_Detailed extends AppCompatActivity {

    TextView discount,product_name,discount_price,original_price,description;
    ImageView product_image;
    TextView header_name;
    ImageView addButton;
    Button btn_weekely;
    ImageView city_cart_detailed_backImage,city_cart_detailed_cartImage;
    Context context;
    private Api_Interface api_interface;
    String product_detail_name;
    TextView txttoolbar_citycart_detailed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_cart__detailed);

        init();
        clickListener();

        Intent intent = getIntent();
        String id=intent.getStringExtra("id");
        product_detail_name=intent.getStringExtra("product_detail_name");

        ProgressDialog();

        api_interface= Api_Utils.getAPIService();
        Call<Example_cityCart1> city_cart_detailed = api_interface.city_cart("Bearer "+
                SharePrefrence.getToken(getApplicationContext()),id);

        city_cart_detailed.enqueue(new Callback<Example_cityCart1>() {
            @Override
            public void onResponse(Call<Example_cityCart1> call, Response<Example_cityCart1> response) {

                Log.e("Tag","OnResponse:"+response.message());
                List<ProducTConfig> productconfigs = response.body().getData().getProduct1().get(0).getProducTConfig();

                image_glide.loadimg(City_cart_Detailed.this,product_image, url.PRODUCTBASE,
                        productconfigs.get(0).getImagePath());
                discount.setText(productconfigs.get(0).getDiscount()+"% OFF");
                product_name.setText(productconfigs.get(0).getVariantName());
                discount_price.setText(productconfigs.get(0).getDiscountedprice());
                original_price.setText(productconfigs.get(0).getPrice());
                description.setText(productconfigs.get(0).getDescription());
                //header_name.setText(productconfigs.get(0).getVariantName());
                txttoolbar_citycart_detailed.setText(productconfigs.get(0).getVariantName());

                Toast.makeText(City_cart_Detailed.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<Example_cityCart1> call, Throwable t) {
                Log.e("Tag","onFailure:"+t.toString());
            }
        });

    }
    public void init(){
        product_image=findViewById(R.id.city_cart_detailed_image);
        discount = findViewById(R.id.pulses_discount);
        product_name = findViewById(R.id.product_name);
        discount_price = findViewById(R.id.discount_price);
        original_price = findViewById(R.id.original_price);
        original_price.setPaintFlags(original_price.getPaintFlags()
                | Paint.STRIKE_THRU_TEXT_FLAG);
        description = findViewById(R.id.product_description);
        header_name = findViewById(R.id.header_name);

        addButton = findViewById(R.id.addButton);
        btn_weekely = findViewById(R.id.btn_weekely);
        city_cart_detailed_backImage=findViewById(R.id.city_cart_detailed_backImage);
        city_cart_detailed_cartImage = findViewById(R.id.city_cart_detailed_cartImage);

        txttoolbar_citycart_detailed=findViewById(R.id.txttoolbar_citycart_detailed);

    }

    private void ProgressDialog(){

        int progressStatus = 0;
        final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(this);

        // Set progress dialog style spinner
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // Set the progress dialog message
        pd.setMessage("Loading...");

        // Set the progress dialog background color
        pd.getWindow().setBackgroundDrawable(new ColorDrawable
                (Color.parseColor("#FFD4D9D0")));

        pd.setIndeterminate(false);

        // Finally, show the progress dialog
        pd.show();

        // Set the progress status zero on each button Click
        progressStatus = 0;

        // Start the lengthy operation in a background thread
        final int[] finalProgressStatus = {progressStatus};
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(finalProgressStatus[0] < 100){
                    // Update the progress status
                    finalProgressStatus[0] +=1;

                    // Try to sleep the thread for 20 milliseconds
                    try{
                        Thread.sleep(12);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // Update the progress status
                            pd.setProgress(finalProgressStatus[0]);
                            // If task execution completed
                            if(finalProgressStatus[0] == 100){
                                // Dismiss/hide the progress dialog
                                pd.dismiss();
                            }
                        }
                    });
                }
            }
        }).start(); // Start the operation
    }

    public void clickListener(){

        city_cart_detailed_backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(City_cart_Detailed.this,City_Cart.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });

        city_cart_detailed_cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(City_cart_Detailed.this, EmptyCart_Activity.class);
                startActivity(intent);
            }
        });

    }

}
