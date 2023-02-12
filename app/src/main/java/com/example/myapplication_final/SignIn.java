package com.example.myapplication_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    EditText emailAddress;
    EditText password;
    Button btn_signIn;
    TextView tv_intentToSignUp;
    String userNameStr, emailAddressStr;
    // SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailAddress = findViewById(R.id.emailAddress_signIn);
        password = findViewById(R.id.password_signIn);
        btn_signIn = findViewById(R.id.btn_signIn);
        tv_intentToSignUp = findViewById(R.id.intentToSignUp);

        //sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);


        btn_signIn.setOnClickListener(this);
        tv_intentToSignUp.setOnClickListener(this);


    }


    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        if (view == btn_signIn) {
            Intent intent_to_main_screen = new Intent(this, MainScreen.class);
            startActivity(intent_to_main_screen);
            /*SharedPreferences.Editor editor = sp.edit();

            editor.putString("name", userNameStr);
            editor.putString("email", emailAddressStr);
            editor.commit();

             */

        }
        if (view == tv_intentToSignUp) {
            Intent intent_to_sign_up = new Intent(this, SignUp.class);
            startActivity(intent_to_sign_up);
        }

    }
}