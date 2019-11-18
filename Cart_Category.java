package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.infodart.salman.Pojo_Classes.Model_Cart_Category.Model_Cart_Category;
import com.infodart.salman.Pojo_Classes.Model_pulsesFragment.Supermarket;
import com.infodart.salman.Pojo_Classes.Others.Pojo_Cart_Category;
import com.infodart.salman.R;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.adapters.MyAdapter_cart_category;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;
import com.infodart.salman.fragments.HomeFragment;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cart_Category extends AppCompatActivity {

    ListView listView;
    MyAdapter_cart_category myAdapter_cart_category;
    ImageView cart_category_backimage;
    TextView _txt_toolbarname;
    ImageView cart_category_cartImage;
    private Api_Interface api_interface;
    String superMarketName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart__category);


        Intent intent = getIntent();
        final String supermarket_id=intent.getStringExtra("position");
        superMarketName = intent.getStringExtra("SUPERMATKETNAME");


        //this method is for casting of ID's
        init();
        _txt_toolbarname.setText(superMarketName);

        api_interface= Api_Utils.getAPIService();
        Call<Model_Cart_Category> cart_category = api_interface.category_data
                ("Bearer "+SharePrefrence.getToken(getApplicationContext())
                        ,supermarket_id);

        ProgressDialog();
        cart_category.enqueue(new Callback<Model_Cart_Category>() {
           @Override
           public void onResponse(Call<Model_Cart_Category> call, Response<Model_Cart_Category> response) {

               Log.e("Tag","Cart Category Response: "+response.message());

               myAdapter_cart_category = new MyAdapter_cart_category(Cart_Category.this,
                       response.body().getData().getCategories(),supermarket_id);

               listView.setAdapter(myAdapter_cart_category);

           }

           @Override
           public void onFailure(Call<Model_Cart_Category> call, Throwable t) {
                Log.e("Tag","OnFailure"+ t.toString());
           }
       });
        //this method is for toolbar functionality - Cart and BackButton
        clickListener();
    }
        private void init(){
            listView = findViewById(R.id.listview);
            _txt_toolbarname = findViewById(R.id._txt_toolbarname);
            cart_category_backimage = findViewById(R.id.cart_category_backImage);
            cart_category_cartImage = findViewById(R.id.cart_category_cartImage);
        }

        private void ProgressDialog(){

        int progressStatus = 0;
        final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(Cart_Category.this);

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
        Thread.sleep(8);
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

        private void clickListener(){

            cart_category_backimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cart_Category.this,MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            });

            cart_category_cartImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Cart_Category.this, EmptyCart_Activity.class);
                    startActivity(intent);
                }
            });

        }

}
