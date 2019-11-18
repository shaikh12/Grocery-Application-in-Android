package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.infodart.salman.Pojo_Classes.Model_Signup.signup;
import com.infodart.salman.R;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private TextInputEditText reg_name;
    private TextInputEditText reg_email;
    private TextInputEditText reg_password;
    private TextInputEditText reg_mobile;
    Button btn_register;
    private CheckBox checkBox;
    private EditText edit_referralcode;


    private TextView termsandcondition;
    private ImageView backimage;
    private Api_Interface api_interface;

    private static final Pattern NAME_PATTERN =
            Pattern.compile("^[a-zA-Z0-9]*$");

    String MobilePattern = "[0-9]{10}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        init();
        setListener();

        termsandcondition.setPaintFlags(termsandcondition.getPaintFlags()
                | Paint.UNDERLINE_TEXT_FLAG);
        termsandcondition.setText("Terms and Condition");
    }

    public void init(){

        checkBox = findViewById(R.id.checkbox);
        reg_name = findViewById(R.id.edit_regName);
        reg_email = findViewById(R.id.edit_regEmail);
        reg_password = findViewById(R.id.edit_regPassword);
        reg_mobile = findViewById(R.id.edit_regMobile);
        btn_register = findViewById(R.id.btn_register);
        checkBox = findViewById(R.id.checkbox);
        checkBox.isChecked();
        termsandcondition = findViewById(R.id.termsandconditions);
        edit_referralcode=findViewById(R.id.ed_signup_referralCode);
        backimage=findViewById(R.id.back_image);

    }

    public  void setListener(){

        backimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        termsandcondition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, TermsAndConditions.class);
                startActivity(intent);
                finish();
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=reg_name.getText().toString();
                String email=reg_email.getText().toString();
                String pass=reg_password.getText().toString();
                String phone=reg_mobile.getText().toString();
                String referral_code=edit_referralcode.getText().toString();

                if (checkValidation()){
                    if (CommonMethod.isNetworkAvailable(SignupActivity.this)){
                        api_interface= Api_Utils.getAPIService();
                        Call<signup> call = api_interface.signupDetail(name,email,pass,phone,referral_code);

                        call.enqueue(new Callback<signup>() {
                            @Override
                            public void onResponse(Call<signup> call, Response<signup> response) {

                                String a =response.body().getData().getAccessToken();
                                Toast.makeText(SignupActivity.this,a,Toast.LENGTH_SHORT).show();
                                successfull();

                                }
                            @Override
                            public void onFailure(Call<signup> call, Throwable t) {

                                Log.e("TAG","Response: " + t.toString());
                            }
                        });
                    }else
                        CommonMethod.showAlert("Internet Connectivity Failure", SignupActivity.this);
                }
            }
        });

}
    private void successfull() {

        Intent intent = new Intent(SignupActivity.this,MainActivity.class);
        startActivity(intent);
    }

    private boolean checkValidation() {

        String name = reg_name.getText().toString().trim();
        String email = reg_email.getText().toString().trim();
        String pass = reg_password.getText().toString().trim();
        String phone = reg_mobile.getText().toString().trim();

        if (name.isEmpty()){
            reg_name.setError("Please enter name");
            return false;

        }else if (!NAME_PATTERN.matcher(name).matches()){
            reg_name.setError("Invalid name");
            return false;
        }

        if (email.isEmpty()){
            reg_email.setError("Enter Email");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            reg_email.setError("Invalid Email");
            return false;
        }

        if (pass.isEmpty()){
            reg_password.setError("Enter Password");
            return false;}

        if (phone.isEmpty()){
            reg_mobile.setError("Enter Mobile Number");
        }else if (!phone.matches(MobilePattern)){
            reg_mobile.setError("Invalid Phone Number");
            return false;
        }

        return true;
    }

}



