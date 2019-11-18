
package com.infodart.salman.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.infodart.salman.R;

import java.util.Objects;
import java.util.regex.Pattern;

public class CreatePassword extends AppCompatActivity {

    private TextInputLayout forgot_newPassword;
    private TextInputLayout forgot_confirmPassword;
    private Button btn_forgot_savePassword;
    private ImageView back_image;

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
        setContentView(R.layout.activity_create_password);

        forgot_newPassword=findViewById(R.id.forgot_newPassword);
        forgot_confirmPassword=findViewById(R.id.forgot_confirmPassword);

        back_image = (ImageView)findViewById(R.id.back_image);
        back_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreatePassword.this, ForgotPassword.class);
                startActivity(intent);
                finish();
            }
        });

        btn_forgot_savePassword= findViewById(R.id.btn_forgot_SavePassword);
        btn_forgot_savePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                checkDataEntered();
            }
        });
    }


    private boolean isPassword() {

        String passwordValue = Objects.requireNonNull(forgot_newPassword.getEditText()).getText().toString().trim();

        if (passwordValue.isEmpty()) {
            forgot_newPassword.setError("failed,can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordValue).matches()) {
            forgot_newPassword.setError("Weak Password");
            return false;
        } else {
            forgot_newPassword.setError(null);
            return true;
        }
    }


    private boolean confirmPassword() {

        String passwordValue1 = Objects.requireNonNull(forgot_confirmPassword.getEditText()).getText().toString().trim();

        if (passwordValue1.isEmpty()) {
            forgot_confirmPassword.setError("failed,can't be empty");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordValue1).matches()) {
            forgot_confirmPassword.setError("Weak Password");
            return false;
        } else {
            forgot_confirmPassword.setError(null);
            return true;
        }
    }

    private void checkDataEntered() {

        String passwordValue = Objects.requireNonNull(forgot_newPassword.getEditText()).getText().toString().trim();
        String passwordValue1 = Objects.requireNonNull(forgot_confirmPassword.getEditText()).getText().toString().trim();

        if (!passwordValue.equals(passwordValue1)){
            forgot_confirmPassword.setError("Password does not match");
        }
        else if (!isPassword() | !confirmPassword() ){
            return;
        }
        else {
            Toast.makeText(this,"New Password Created",
                    Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(CreatePassword.this, LoginActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
