package com.infodart.salman.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.fragments.NotificationFragment;
import com.infodart.salman.R;
import com.infodart.salman.adapters.FragmentAdapter;
import com.infodart.salman.fragments.AccountFragment;
import com.infodart.salman.fragments.CartFragment;
import com.infodart.salman.fragments.HomeFragment;
import com.infodart.salman.fragments.LotteryFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private Toolbar toolbar;
    private DrawerLayout drawerlayout;
    private NavigationView navigationView;
    private ImageView img_cart;
    private Spinner spinner;
    private BottomNavigationView bottomNavigationView;

    String title[] = {"Lottery", "Cart", "Home", "Notification", "Account"};

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            this.finish();
        } else {
            super.onBackPressed(); //replaced
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        spinnerWork();
        clickListener();
    }

    //CODE FOR putting Fragment on the Click of a button
    private static void setupFragmentManager(FragmentManager fragmentManager,
                                             ViewPager viewPager) {

        FragmentAdapter adapter = new FragmentAdapter(fragmentManager);

        //Add All Fragment To bottom navigation
        adapter.add(new LotteryFragment(), "Lottery");
        adapter.add(new CartFragment(), "Cart");
        adapter.add(new HomeFragment(), "Home");
        adapter.add(new NotificationFragment(), "Notification");
        adapter.add(new AccountFragment(), "Account");

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(2);

    }

    //CODE FOR Bottom Navigation View
    private BottomNavigationView.OnNavigationItemSelectedListener
            onNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){

                case R.id.navigation_lottery:
                    viewPager.setCurrentItem(0);
                    return true;

                case R.id.navigation_cart:
                    viewPager.setCurrentItem(1);
                    return true;

                case R.id.navigation_home:
                    viewPager.setCurrentItem(2);
                    return true;

                case R.id.navigation_notification:
                    viewPager.setCurrentItem(3);
                    return true;

                case R.id.navigation_account:
                    viewPager.setCurrentItem(4);
                    return true;
            }
            return false;
        }
    };


    public  class PageChange implements ViewPager.OnPageChangeListener {

        TextView textView=findViewById(R.id.textview_toolbar_main);

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            textView.setText(title[position]);
        }

        @Override
        public void onPageSelected(int position) {

//            switch (position) {
//                case 0:
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_lottery);
//                    break;
//
//                case 1:
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_cart);
//                    break;
//
//                case 2:
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_home);
//                    break;
//
//                case 3:
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_notification);
//                    break;
//
//                case 4:
//                    bottomNavigationView.setSelectedItemId(R.id.navigation_account);
//                    break;
//            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

            if (state == 0){
                View inflatedView = getLayoutInflater().inflate(R.layout.fragment_lottery,null);
            }
            if (state == 1){
                View inflatedView = getLayoutInflater().inflate(R.layout.fragment_cart,null);
            }
            if (state == 2){
                View inflatedView = getLayoutInflater().inflate(R.layout.fragment_home,null);
            }
            if (state == 3){
                View inflatedView = getLayoutInflater().inflate(R.layout.fragment_notification,null);
            }
            if (state == 4){
                View inflatedView = getLayoutInflater().inflate(R.layout.fragment_account,null);
            }
        }
    }

    // Code for Navigation Drawer
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {

            case R.id.navi_home:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_myOrders:
                Toast.makeText(this, "My Orders", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_help:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_rate:
                Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_language:
                Toast.makeText(this, "Language", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_FAQ:
                Intent intent = new Intent(MainActivity.this,
                        FAQ_Activity.class);
                startActivity(intent);
                finish();
                break;

            case R.id.navi_Privacy:
                Toast.makeText(this, "Privacy", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_terms:
                Toast.makeText(this, "Terms", Toast.LENGTH_SHORT).show();
                break;

            case R.id.navi_broughtLottery:
                Toast.makeText(this, "Lottery", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }

     public  void init(){
         viewPager = findViewById(R.id.viewPager);
         viewPager.setOnPageChangeListener(new PageChange());

         toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
         getSupportActionBar().setDisplayShowTitleEnabled(false);

         img_cart = findViewById(R.id.img_cart);

         drawerlayout = findViewById(R.id.drawerlayout);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                 drawerlayout, toolbar, R.string.open, R.string.close);
         drawerlayout.addDrawerListener(toggle);
         toggle.syncState();

         navigationView = findViewById(R.id.navigation_view);
         navigationView.setNavigationItemSelectedListener(this);

         bottomNavigationView = findViewById(R.id.bottom_navigation);
         bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

         spinner = findViewById(R.id.spinner);

         //Setup Fragment
         setupFragmentManager(getSupportFragmentManager(),viewPager);
         //Listeners For Viewpager When Page Changed
         viewPager.setOnPageChangeListener(new PageChange());

     }

     public void spinnerWork(){
         spinner.getBackground().setColorFilter(getResources().getColor(R.color.yellow)
                 , PorterDuff.Mode.SRC_ATOP);
         final ArrayAdapter myadapter = new ArrayAdapter<String>(getBaseContext(),
                 R.layout.custom_spinner_item, getResources()
                 .getStringArray(R.array.country));
         myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner.setAdapter(myadapter);
         spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> adapterView,
                                        View view, int i, long l) {
             }

             @Override
             public void onNothingSelected(AdapterView<?> adapterView) {
             }
         });
     }

     public void clickListener(){
         img_cart.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(MainActivity.this,
                         EmptyCart_Activity.class);
                 startActivity(intent);
                 finish();
             }
         });
     }

}




