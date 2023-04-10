package com.example.myapplication_final;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText userName;
    EditText emailAddress;
    EditText password;
    Button btn_signUp;
    TextView tv_intentToSignIn;
    String userNameStr, emailAddressStr;
    //SharedPreferences sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userName = findViewById(R.id.userName_signUp);
        emailAddress = findViewById(R.id.emailAddress_signUp);
        password = findViewById(R.id.password_signUp);
        btn_signUp = findViewById(R.id.btn_signUp);
        tv_intentToSignIn = findViewById(R.id.intentToSignIn);

        //sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);

        btn_signUp.setOnClickListener(this);
        tv_intentToSignIn.setOnClickListener(this);


    }

    /**
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        if (view == btn_signUp) {
            Intent intent_to_main_screen = new Intent(this, MainScreen.class);
            startActivity(intent_to_main_screen);
            userNameStr = userName.getText().toString();
            emailAddressStr = emailAddress.getText().toString();
            /*SharedPreferences.Editor editor = sp.edit();

            editor.putString("name", userNameStr);
            editor.putString("email", emailAddressStr);
            editor.commit();
             */


        }
        if ((view == tv_intentToSignIn)) {
            Intent intent_to_sign_in = new Intent(this, SignIn.class);
            startActivity(intent_to_sign_in);
        }

    }
}