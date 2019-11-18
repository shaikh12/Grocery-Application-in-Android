package com.infodart.salman.fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.CartExample;
import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.Subcategory;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Example_cityCart;
import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Productconfig;
import com.infodart.salman.R;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.Util.Click;
import com.infodart.salman.activity.Cart_Category_last;
import com.infodart.salman.activity.EmptyCart_Activity;
import com.infodart.salman.adapters.Adapter_Pulses;
import com.infodart.salman.adapters.Adapter_Pulses_New;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Pulses_Fragment extends Fragment implements Click {

    private Adapter_Pulses adapter_pulses;
    private Api_Interface api_interface;
    private Adapter_Pulses_New adapter_pulses_new;
    private RecyclerView recylerview_list,recycler_tab;
    Click itemListener;
    ImageView back_image,img_cart;
    TextView txt_title;
    String sid,cid,product_name;
    TextView text_toolbar_product;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.activity_city__cart, container,false);

        //this RecyclerView IS FOR SHOWING THE PRODUCT WHOLE DATA.
        recylerview_list=view.findViewById(R.id.recylerview_list);
        //THIS RecyclerViewIS FOR SHOWING THE TABS.
        recycler_tab=view.findViewById(R.id.recycler_viewTabs);
        back_image=view.findViewById(R.id.back_image_fragment);
        img_cart=view.findViewById(R.id.img_cart_fragment);

        txt_title= view.findViewById(R.id.txt_title);
        text_toolbar_product=view.findViewById(R.id.text_toolbar_product);

        SharedPreferences preferences = getContext().getSharedPreferences
                ("myprefs", 0);
        sid=  preferences.getString("SupermarketId","");
        cid= preferences.getString("subCategoryid","");
        product_name=preferences.getString("Product_name","");

        text_toolbar_product.setText(product_name);

        TabApi(cid);

        setListener();

        return view;
    }

    //1st Api
    private void TabApi(String cid){

        api_interface= Api_Utils.getAPIService();
        Call<CartExample> cityCartExample = api_interface.subcategory_data
                ("Bearer "+ SharePrefrence.getToken(getContext()),sid,cid);

        ProgressDialog();
        cityCartExample.enqueue(new Callback<CartExample>() {
            @Override
            public void onResponse(Call<CartExample> call, Response<CartExample> response) {

                if(response.body().getStatus().equals("401")){
                    Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                }
                else {
                    List<Subcategory> Pulses_CityCart = response.body().getData().getSubcategories();
                    adddata(Pulses_CityCart);
                    Log.e("Tag", "OnResponse:" + response.message());

                    if(Pulses_CityCart.size()!=0)
                    {
                        sendProductId(sid, Pulses_CityCart.get(0).getId());
                    } else {
                        Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<CartExample> call, Throwable t) {
                Log.e("Tag","onFailure:"+t.toString());
            }
        });
    }

    //2nd Api
    private void sendProductId(String Supermarketid, String str) {

        final Call<Example_cityCart> example_cityCartCall = api_interface.product_category
                ("Bearer "+ SharePrefrence.getToken(getContext()),Supermarketid,str);

        ProgressDialog();
        example_cityCartCall.enqueue(new Callback<Example_cityCart>() {
            @Override
            public void onResponse(Call<Example_cityCart> call, Response<Example_cityCart> response) {
                Log.e("Tag","Pulses Fragment Response: "+response.message());
                if(response.body().getStatus().equals("401")){
                    Toast.makeText(getActivity(), "No Data Available", Toast.LENGTH_SHORT).show();
                }else {
                    List<Productconfig> productconfigs = response.body().getData().getProduct().get(0).getProductconfig();
                    adapter_pulses_new = new Adapter_Pulses_New(getContext(), productconfigs);
                    recylerview_list.setAdapter(adapter_pulses_new);
                    recylerview_list.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }
            @Override
            public void onFailure(Call<Example_cityCart> call, Throwable t) {
                Log.e("Tag","onFailure:"+t.toString());
            }
        });
    }

    private void ProgressDialog(){

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
                while(finalProgressStatus[0] < 100){
                    // Update the progress status
                    finalProgressStatus[0] +=1;

                    // Try to sleep the thread for 20 milliseconds
                    try{
                        Thread.sleep(10);
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

    public void setListener(){

        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();

            }
        });

        img_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), EmptyCart_Activity.class);
                startActivity(intent);
            }
        });
    }

    // method of Ist Api for method TabApi
    public void adddata(List<Subcategory> pulses_CityCart)
    {
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager
                (getContext(), LinearLayoutManager.HORIZONTAL,false);

        recycler_tab.setLayoutManager(horizontalLayoutManager);
        adapter_pulses=new Adapter_Pulses(getContext(),pulses_CityCart,this);
        recycler_tab.setAdapter(adapter_pulses);
        // for the yellow title
        //txt_title.setText(pulses_CityCart.get(0).getName());
    }

    @Override
    public void Onclick(String v, int position) {
        //Toast.makeText(getActivity(), v, Toast.LENGTH_SHORT).show();
        sendProductId(sid,v);
    }
}