package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.infodart.salman.R;

public class TermsAndConditions extends AppCompatActivity {

    private ImageView backBtn_terms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        backBtn_terms = findViewById(R.id.back_image);
        backBtn_terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TermsAndConditions.this, SignupActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
