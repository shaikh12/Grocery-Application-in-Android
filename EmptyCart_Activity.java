package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.infodart.salman.R;

public class EmptyCart_Activity extends AppCompatActivity {

    Button btn_startShopping;
//
//    @Override
//    public void onBackPressed() {
//
//        Intent intent = new Intent(EmptyCart_Activity.this, MainActivity.class);
//        startActivity(intent);
//        finish();
//        super.onBackPressed();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_cart_);

        btn_startShopping = findViewById(R.id.btn_startShopping);
        btn_startShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EmptyCart_Activity.this,
                        MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
