package com.example.myapplication_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SignIn extends AppCompatActivity implements View.OnClickListener {
    EditText et_emailAddress;
    EditText et_password;
    Button btn_signIn;
    TextView tv_intentToSignUp;
    String userNameStr, emailAddressStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        et_emailAddress = findViewById(R.id.emailAddress_signIn);
        et_password = findViewById(R.id.password_signIn);
        btn_signIn = findViewById(R.id.btn_signIn);
        tv_intentToSignUp = findViewById(R.id.intentToSignUp);
        btn_signIn.setOnClickListener(this);
        tv_intentToSignUp.setOnClickListener(this);


    }

    /**
     * onResume
     * shardPreference
     */
    @Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("SharedPref_for_user_info", MODE_PRIVATE);
        String email = sh.getString("email", "");
        String password = sh.getString("password", "");

        // Setting the fetched data in the EditTexts
        et_emailAddress.setText(email);
        et_password.setText(String.valueOf(password));
    }
    /**
     * onPause
     * shardPreference
     */
    @Override
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("SharedPref_for_user_info", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putString("email", et_emailAddress.getText().toString());
        myEdit.putString("password", et_password.getText().toString());
        myEdit.apply();
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