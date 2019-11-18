package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.infodart.salman.fragments.Pulses_Fragment;
import com.infodart.salman.R;

public class City_Cart extends AppCompatActivity {

    //this method is used to go back from a fragment
    // that is inside an activity & to go to an activity
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            getFragmentManager().popBackStack();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_cart_activity);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, new Pulses_Fragment(), "");
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
