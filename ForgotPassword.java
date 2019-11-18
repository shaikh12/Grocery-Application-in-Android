package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.infodart.salman.Pojo_Classes.Model_ForgotPassword.Pojo_forgot_password;
import com.infodart.salman.Pojo_Classes.Model_ForgotPassword.forgot;
import com.infodart.salman.R;
import com.infodart.salman.controllers.Api_Interface;
import com.infodart.salman.controllers.Api_Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {

    private Button submit_btn;
    private EditText forget_email;
    private ImageView forgot_password_Image;

    private Api_Interface api_interface;

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(ForgotPassword.this,LoginActivity.class);
        startActivity(intent);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forget_email=findViewById(R.id.forget_email);

        forgot_password_Image=findViewById(R.id.back_image);
        forgot_password_Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ForgotPassword.this,
                        LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        submit_btn = findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = forget_email.getText().toString();

                final Pojo_forgot_password pojo_forgot_password = new Pojo_forgot_password();
                pojo_forgot_password.setEmail(Email);

                if (checkDataEntered()){
                    if (CommonMethod.isNetworkAvailable(ForgotPassword.this)){

                        api_interface = Api_Utils.getAPIService();
                        Call<forgot> forgot = api_interface.forgot(pojo_forgot_password);

                        forgot.enqueue(new Callback<forgot>() {
                            @Override
                            public void onResponse(Call<forgot> call, Response<forgot> response) {

                                if (response.body().getStatus().equals("200")){
                                    ProgressDialog();
                                    successful();
                                }else {
                                    Toast.makeText(ForgotPassword.this, ""+response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                            @Override
                            public void onFailure(Call<forgot> call, Throwable t) {
                                Log.e("TAG","Response: " + t.toString());
                            }
                        });

                    }else
                        CommonMethod.showAlert("Internet Connectivity Failure", ForgotPassword.this);
                }
            }
        });

    }

    private void successful() {

        Intent intent = new Intent(ForgotPassword.this, MainActivity.class);
        startActivity(intent);
    }
    private boolean isEmail() {

        String emailValue = forget_email.getText().toString().trim();
        Log.e("TAG", "userId is -> " + emailValue);

        if (emailValue.isEmpty()) {
            forget_email.setError("failed,can't be empty");
            return false;

        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailValue).matches()) {
            forget_email.setError("Please Enter valid email address");
            return false;

        } else {
            forget_email.setError(null);
            return true;
        }

    }
    private boolean checkDataEntered() {

        if (!isEmail()){
            return false;
        }
        else {
            return true;
        }
    }
    private void ProgressDialog(){

        int progressStatus = 0;
        final Handler handler = new Handler();

        final ProgressDialog pd = new ProgressDialog(ForgotPassword.this);

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