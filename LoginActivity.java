package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.infodart.salman.Pojo_Classes.Model_Login.Example;
import com.infodart.salman.Pojo_Classes.Model_Login.Pojo_login;
import com.infodart.salman.R;
import com.infodart.salman.Util.SharePrefrence;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import java.util.regex.Pattern;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    public EditText textInputEmail;

    public EditText textInputPassword;
    private Button login_btn;
    private TextView register;
    private TextView forgotPassword;
    private Api_Interface api_interface;
    private SharedPreferences preferencesLogin1;
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +
                    "(?=.*[a-zA-Z])" +
                    "(?=.\\S+$)" +
                    ".{6,}" +
                    "$");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        setListener();

        preferencesLogin1=getSharedPreferences("Login", Context.MODE_PRIVATE);
        String user=preferencesLogin1.getString("username","");
        String pass=preferencesLogin1.getString("password","");


        textInputEmail.setText(preferencesLogin1.getString("username",user));
        textInputPassword.setText(preferencesLogin1.getString("password",pass));


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id=textInputEmail.getText().toString();
                String pass=textInputPassword.getText().toString();

                final Pojo_login pojo_login = new Pojo_login();
                pojo_login.setUsername(id);
                pojo_login.setPassword(pass);

                if(checkDataEntered()){
                    if (CommonMethod.isNetworkAvailable(LoginActivity.this)){
                        api_interface= Api_Utils.getAPIService();
                        Call<Example> call1 = api_interface.loginDetails(pojo_login);

                        ProgressDialog();
                        call1.enqueue(new Callback<Example>() {

                            @Override
                            public void onResponse(Call<Example> call, Response<Example> response) {

                                if(response.body().getStatus().equals("200"))
                                {
                                    String token=response.body().getData().getAccessToken();
                                    SharePrefrence.setToken(LoginActivity.this,token);
                                    Toast.makeText(LoginActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    successfull();
                                } else {
                                    Toast.makeText(LoginActivity.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onFailure(Call<Example> call, Throwable t) {
                                Log.e("TAG","Response: " + t.toString());
                            }
                        });
                    }else
                        CommonMethod.showAlert("Internet Connectivity Failure", LoginActivity.this);
                }
            }
        });

    }

    private void init() {
        textInputEmail =findViewById(R.id.input_username);
        textInputPassword = findViewById(R.id.input_PASS);
        login_btn = findViewById(R.id.Login_btn);
        register = findViewById(R.id.register);
        forgotPassword= findViewById(R.id.forgotPassword);
    }

    private void successfull() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("EMAIL",textInputEmail.getText().toString().trim());
        startActivity(intent);
    }

    private boolean isEmail() {
        String emailValue = textInputEmail.getText().toString().trim();
        Log.e("TAG", "userId is -> " + emailValue);
        if (emailValue.isEmpty()){
            textInputEmail.setError("failed,can't be empty");
            return false;
        }
        else {
            textInputEmail.setError(null);
            return true;
        }
    }

    private boolean isPassword() {

        String passwordValue = textInputPassword.getText().toString().trim();

        Log.e("TAG", "password is -> " + passwordValue);

        if (passwordValue.isEmpty()){
            textInputPassword.setError("failed,can't be empty");
            return false;
        }
        else if (!PASSWORD_PATTERN.matcher(passwordValue).matches()){
            textInputPassword.setError("Weak Password");
            return false;
        }else {
            textInputPassword.setError(null);
            return true;
        }
    }

    private boolean checkDataEntered(){

        if (!isEmail() | !isPassword() ){
            return false;
        } else
            return true;
    }

    private void setListener() {

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,
                        SignupActivity.class);
                startActivity(intent);
            }
        });


    }

    private void ProgressDialog(){

         int progressStatus = 0;
         final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(LoginActivity.this);

        // Set progress dialog style spinner
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // Set the progress dialog message
        pd.setMessage("Loading...");

        // Set the progress dialog background color
        pd.getWindow().setBackgroundDrawable(new ColorDrawable
                (Color.parseColor("#FFD4D9D0")));

        //It means the "loading amount" is not measured.
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
                        Thread.sleep(20);
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
}






