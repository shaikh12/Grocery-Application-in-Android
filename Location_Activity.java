package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.infodart.salman.R;

public class Location_Activity extends AppCompatActivity {

    TextView use_mylocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_);

        use_mylocation = findViewById(R.id.use_mylocation);
        use_mylocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Location_Activity.this,
                        "Location API Will be used here",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
