package com.seeksolution.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private EditText et_email,et_password;
    private TextView error_email,error_password;
    private String email,password;
    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    public static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_email=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_password);
        error_email=(TextView) findViewById(R.id.error_email);
        error_password=(TextView) findViewById(R.id.error_password);
    }

    public void submit(View view) {


        email = et_email.getText().toString();
        password=et_password.getText().toString();
        //Blank validation for Email
        if(validateEmail(email) | validatePassword(password)){
            if(email.equals("admin@gmail.com") && password.equals("Password@123")){
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
                et_password.setBackgroundResource(R.drawable.success_layout);
                et_email.setBackgroundResource(R.drawable.success_layout);
                goToDashboard(view);
            }
            else {
                Toast.makeText(this, "Invalid Email or Password", Toast.LENGTH_SHORT).show();
                et_email.setBackgroundResource(R.drawable.error_layout);
                et_password.setBackgroundResource(R.drawable.error_layout);
            }

        }
    }
    private boolean validateEmail(String email){
        if (email.isEmpty()){
            error_email.setText("Email is Requried");
            et_email.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        if (!EMAIL_ADDRESS_REGEX.matcher(email).matches()){
            error_email.setText("Invailid Email");
            return false;
        }
        et_email.setBackgroundResource(R.drawable.success_layout);
        error_email.setText("");
        return true;
    }
    private boolean validatePassword(String password){
        if (password.isEmpty()){
            error_password.setText("Password is Requried");
            et_password.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        if (!PASSWORD_REGEX.matcher(password).matches()){
            error_password.setText("Invailid Password");
            return false;
        }
        et_password.setBackgroundResource(R.drawable.success_layout);
        error_password.setText("");
        return true;

    }

    public void goToRegister(View view) {
        Intent intent = new Intent(MainActivity.this,Registration.class);
        startActivity(intent);

    }
    public void goToDashboard(View view) {
        Intent intent = new Intent(MainActivity.this,Dashboard_Navigation.class);
        startActivity(intent);
        finish();

    }
}

