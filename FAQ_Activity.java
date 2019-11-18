package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;


import com.infodart.salman.R;

public class FAQ_Activity extends AppCompatActivity {

    private ImageView FAQ_backbtn;

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(FAQ_Activity.this, MainActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_);

        FAQ_backbtn = findViewById(R.id.FAQ_backbtn);
        FAQ_backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FAQ_Activity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

}
