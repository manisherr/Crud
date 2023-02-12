package com.seeksolution.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
    private EditText et_name,et_dob,et_mobile,et_email,et_password;
    private TextView error_name,error_dob,error_mobile,error_email,error_password,error_gender;
    private String name,mobile,email,password,dob,gender ="";
    private RadioButton clickedradioButton;
    private RadioGroup radioGroup;
    public static final Pattern EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
    public static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$");
    public static final Pattern MOBILE_REGEX = Pattern.compile("^[7-9][0-9]{9}$");
    public static final Pattern DOB_REGEX = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])[-/.](0[1-9]|1[012])[-/.](11|12|13|14|15|16|17|18|19|20)\\d\\d$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        et_name=(EditText)findViewById(R.id.et_name);
        et_dob=(EditText)findViewById(R.id.et_dob);
        et_mobile=(EditText)findViewById(R.id.et_mobile);
        et_email=(EditText)findViewById(R.id.et_email);
        et_password=(EditText)findViewById(R.id.et_password);
        error_name=(TextView) findViewById(R.id.error_name);
        error_dob=(TextView)findViewById(R.id.error_dob);
        error_mobile=(TextView) findViewById(R.id.error_mobile);
        error_email=(TextView) findViewById(R.id.error_email);
        error_password=(TextView) findViewById(R.id.error_password);
        radioGroup = (RadioGroup) findViewById(R.id.rg_gender);
        error_gender = (TextView)findViewById(R.id.gender_error);
    }

    public void getGender(View view) {
        int radioId = radioGroup.getCheckedRadioButtonId();
        clickedradioButton = (RadioButton)findViewById(radioId);
        gender= clickedradioButton.getText().toString();
    }
    public void submit(View view) {

        name = et_name.getText().toString();
        dob =et_dob.getText().toString();
        mobile=et_mobile.getText().toString();
        email = et_email.getText().toString();
        password=et_password.getText().toString();
        //Blank validation for Email
        validateName(name);
        validateDob(dob);
        validateMobile(mobile);
        validateEmail(email);
        validatePassword(password);
        validateGender(gender);

        if (validateName(name) && validateDob(dob) && validateMobile(mobile) && validateEmail(email) && validatePassword(password) && validateGender(gender)){
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_SHORT).show();
            goToLogin(view);
        }




    }
    public void goToLogin(View view) {
        Intent intent = new Intent(Registration.this,MainActivity.class);
        startActivity(intent);

    }
    public boolean validateName(String name){
        if(name.isEmpty()){
            error_name.setText("Name is Requried");
            et_name.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        et_name.setBackgroundResource(R.drawable.success_layout);
        error_name.setText("");
        return true;
    }
    public boolean validateDob(String dob){
        if (dob.isEmpty()){
            error_dob.setText("Date of Birth is Requried");
            et_dob.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        if (!DOB_REGEX.matcher(dob).matches()){
            error_dob.setText("Invailid Mobile");
            et_dob.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        et_dob.setBackgroundResource(R.drawable.success_layout);
        error_dob.setText("");
        return true;

    }
    public boolean validateMobile(String mobile){
        if (mobile.isEmpty()){
            error_mobile.setText("Mobile No. is Requried");
            et_mobile.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        if (!MOBILE_REGEX.matcher(mobile).matches()){
            error_mobile.setText("Invailid Mobile");
            et_mobile.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        et_mobile.setBackgroundResource(R.drawable.success_layout);
        error_mobile.setText("");
        return true;

    }
    private boolean validateEmail(String email){
        if (email.isEmpty()){
            error_email.setText("Email is Requried");
            et_email.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        if (!EMAIL_ADDRESS_REGEX.matcher(email).matches()){
            error_email.setText("Invailid Email");
            et_email.setBackgroundResource(R.drawable.error_layout);
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
            et_password.setBackgroundResource(R.drawable.error_layout);
            return false;
        }
        et_password.setBackgroundResource(R.drawable.success_layout);
        error_password.setText("");
        return true;

    }
    public boolean validateGender(String gender){
        if(gender.isEmpty()){
            error_gender.setText("Gender is Requried");
            return false;

        }
        error_gender.setText("");
        return true;
    }

}

