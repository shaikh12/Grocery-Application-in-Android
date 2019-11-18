package com.infodart.salman.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.infodart.salman.Pojo_Classes.HomePageNew.HomeExample;
import com.infodart.salman.Pojo_Classes.HomePageNew.list;
import com.infodart.salman.Pojo_Classes.Model_HomePage.ChildHomeResponse;
import com.infodart.salman.Pojo_Classes.Model_HomePage.ParentDataHomeResponse;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.activity.Location_Activity;
import com.infodart.salman.R;
import com.infodart.salman.activity.LoginActivity;
import com.infodart.salman.adapters.ViewPagerAdapter;
import com.infodart.salman.activity.Cart_Category;
import com.infodart.salman.adapters.AdapterRecyclerGrid;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements AdapterRecyclerGrid.OnNoteListener {

    // for displaying Image through viewpager and dots to show position
    private ViewPager viewPager;
    private LinearLayout sliderDotspanel;
    private int dotsCount;
    private ImageView[] dots;
    private TextView textview_location;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    AdapterRecyclerGrid adapterRecyclerGrid;
    List<ChildHomeResponse> arrayList = new ArrayList<>();
    private Api_Interface api_interface;

    private ImageView imageView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String latitude = "25.151046";
        String longitude = "55.244308";

        recyclerView = view.findViewById(R.id.recycler_view);


        api_interface = Api_Utils.getAPIService();
        Call<ParentDataHomeResponse> homePageCall = api_interface.homeData("Bearer " +
                SharePrefrence.getToken(getActivity()), latitude, longitude);

        ProgressDialog();

        homePageCall.enqueue(new Callback<ParentDataHomeResponse>() {
            @Override
            public void onResponse(Call<ParentDataHomeResponse> call, Response<ParentDataHomeResponse> response) {

                Log.e("Tag", "response:" + response.message());
                arrayList = response.body().getData().getList();
                if (response.body().code.equals("403"))
                    Toast.makeText(getContext(), "There is no supermarket available for this location", Toast.LENGTH_SHORT).show();
                else
                {
                    supermarketlist(arrayList);
                }

            }

            @Override
            public void onFailure(Call<ParentDataHomeResponse> call, Throwable t) {
                Log.e("Tag", "failure:" + t.toString());

            }
        });

        // this snippet is for supermarket view using RecyclerView,LayoutManager
        imageView = view.findViewById(R.id.image_cardview);
        //casting of IDs
        sliderDotspanel = view.findViewById(R.id.SliderDots);

        //----------- CODE FOR DIRECTING THE LOCATION------------------------
        textview_location = view.findViewById(R.id.textview_location);
        textview_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Location_Activity.class);
                startActivity(intent);
            }
        });

        //--------code for dots on the image to switch the images----------------
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity());
        viewPager = view.findViewById(R.id.viewpager_home);
        viewPager.setAdapter(viewPagerAdapter);
        dotsCount = viewPagerAdapter.getCount();

        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {

            dots[i] = new ImageView(getActivity());
            dots[i].setImageDrawable(ContextCompat.
                    getDrawable(getContext(),
                            R.drawable.non_active_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout
                    .LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(8, 0, 8, 0);
            sliderDotspanel.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.
                getDrawable(getContext(),
                        R.drawable.active_dot));
        //THis code is for sliding the dots on the Image
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                for (int i = 0; i < dotsCount; i++) {
                    dots[i].setImageDrawable(ContextCompat.
                            getDrawable(getContext(),
                                    R.drawable.non_active_dot));
                }
                dots[position].setImageDrawable(ContextCompat.
                        getDrawable(getContext(),
                                R.drawable.active_dot));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return view;
        //--------------Code for dots ends -----------------------------------
    }

    // For SuperMarket Cart
    @Override
    public void onClick(int position) {
        Intent intent = new Intent(getContext(), Cart_Category.class);
        intent.putExtra("position", arrayList.get(position).getId());
        intent.putExtra("SUPERMATKETNAME",arrayList.get(position).getName());
        startActivity(intent);
    }

    public void supermarketlist(List<ChildHomeResponse> list) {
        layoutManager = new GridLayoutManager(getContext(), 3);
        recyclerView.setLayoutManager(layoutManager);
        //This is a class adapterRecyclerGrid
        adapterRecyclerGrid = new AdapterRecyclerGrid(getContext(), list,
                this);
        recyclerView.setAdapter(adapterRecyclerGrid);

    }

    private void ProgressDialog() {

        int progressStatus = 0;
        final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(getActivity());

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
                while (finalProgressStatus[0] < 100) {
                    // Update the progress status
                    finalProgressStatus[0] += 1;

                    // Try to sleep the thread for 20 milliseconds
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            // Update the progress status
                            pd.setProgress(finalProgressStatus[0]);
                            // If task execution completed
                            if (finalProgressStatus[0] == 100) {
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

