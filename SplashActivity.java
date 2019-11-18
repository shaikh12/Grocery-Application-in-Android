package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.infodart.salman.R;

public class SplashActivity extends AppCompatActivity {

    private ImageView logo;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);
        title = findViewById(R.id.title);

        Handler handler = new  Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);


       Animation myanim = AnimationUtils.loadAnimation(this,R.anim.splash_animation);
         logo.startAnimation(myanim);
        title.startAnimation(myanim);
    }
}
