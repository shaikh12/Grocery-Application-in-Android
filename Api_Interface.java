package com.infodart.salman.controllers;


import com.infodart.salman.Pojo_Classes.Model_CartCategory_Last.CartExample;
import com.infodart.salman.Pojo_Classes.Model_Cart_Category.Model_Cart_Category;

import com.infodart.salman.Pojo_Classes.Model_Citycart_Detailed.Example_cityCart;
import com.infodart.salman.Pojo_Classes.Model_ForgotPassword.Pojo_forgot_password;
import com.infodart.salman.Pojo_Classes.Model_ForgotPassword.forgot;



import com.infodart.salman.Pojo_Classes.Model_HomePage.ParentDataHomeResponse;
import com.infodart.salman.Pojo_Classes.Model_Login.Example;
import com.infodart.salman.Pojo_Classes.Model_Login.Pojo_login;
import com.infodart.salman.Pojo_Classes.Model_Signup.signup;
import com.infodart.salman.Pojo_Classes.Model_pulsesFragment.Example_cityCart1;

import retrofit2.Call;
import retrofit2.http.Body;


import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api_Interface {


    @POST("login")
    Call<Example> loginDetails (@Body Pojo_login pojoLogin);


    @POST("register")
    Call<signup>signupDetail(@Query("name")String name,
                             @Query("email")String email,
                             @Query("password")String password,
                             @Query("mobile")String phone,
                             @Query("referral_code")String code);


    @POST("emailpassword")
    Call<forgot> forgot (@Body Pojo_forgot_password pojoForgotPassword);


    @POST("gethome")
    Call<ParentDataHomeResponse> homeData(@Header("Authorization") String auth,
                                          @Query("latitude")String latitude,
                                          @Query("longitude")String longitude);

    @POST("categorylist")
    Call<Model_Cart_Category> category_data (@Header ("Authorization") String auth,
                                             @Query("sid") String sid);

    @POST("subcategorylist")
    Call<CartExample> subcategory_data(@Header ("Authorization") String auth,
                                       @Query("sid") String Sid,
                                       @Query("cid") String cid);


    @POST("productlist")
    Call<Example_cityCart> product_category(@Header ("Authorization") String auth,
                                             @Query("sid") String pid,
                                             @Query("cid") String cid);

    @POST("productview")
    Call<Example_cityCart1> city_cart(@Header("Authorization") String auth,
                                     @Query("id") String id);
}
