package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.CartExample;
import com.infodart.salman.R;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.adapters.Adapter_Subcategory;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Cart_Category_last extends AppCompatActivity {

    ListView listView;
    ImageView cartcategory_last_backImage;
    ImageView cartcategory_last_cartImage;
    private Api_Interface api_interface;
    Adapter_Subcategory  adapter_cartCategory_last;
    String Category_name;
    TextView txt_toolbar_subcategory;

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(Cart_Category_last.this , Cart_Category.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart__category_last);

        init();
        setListener();

        Intent intent = getIntent();
        final String Sid=intent.getStringExtra("SUPERMARKET_ID");
        final String cid=intent.getStringExtra("Id");
        Category_name = intent.getStringExtra("Category_Name");

        txt_toolbar_subcategory.setText(Category_name);


        api_interface= Api_Utils.getAPIService();
        Call<CartExample> cartExample = api_interface.subcategory_data("Bearer " +
                SharePrefrence.getToken(this),Sid,cid);

        ProgressDialog();
        cartExample.enqueue(new Callback<CartExample>() {
            @Override
            public void onResponse(Call<CartExample> call, Response<CartExample> response) {

                Log.e("Tag","Subcategory Response: "+response.message());

                adapter_cartCategory_last = new Adapter_Subcategory(Cart_Category_last.this,
                                response.body().getData().getSubcategories(),Sid,cid);
                listView.setAdapter(adapter_cartCategory_last);
       }
            @Override
            public void onFailure(Call<CartExample> call, Throwable t) {
                Log.e("Tag","OnFailure"+ t.toString());
            }
        });
    }

    public void init(){
        listView = findViewById(R.id.listview_1st);
        cartcategory_last_backImage=findViewById(R.id.cartcategory_last_backImage);
        cartcategory_last_cartImage=findViewById(R.id.cartcategory_last_cartImage);
        txt_toolbar_subcategory=findViewById(R.id.txt_toolbar_subcategory);
    }
    public void setListener(){

        cartcategory_last_backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart_Category_last.this,Cart_Category.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
        });

        cartcategory_last_cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cart_Category_last.this,EmptyCart_Activity.class);
                startActivity(intent);
            }
        });
    }

    private void ProgressDialog(){

        int progressStatus = 0;
        final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(Cart_Category_last.this);

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
}
