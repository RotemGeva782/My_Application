package com.example.myapplication_final;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.animation.AnimationUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    ImageView iv_loading;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

       // Log.d("tag", this.getLocalClassName());
        /*
         * another option:
         * new Handler()
         .postDelayed(new Runnable() {
        @Override public void run() {
        startActivity(new Intent(SplashScreen.this, SignIn.class));
        finish();
        }
        }, 1500);

         */

        /**
         * delaying splash screen
         */
        Thread splashScreenStarter = new Thread() {
            public void run() {
                try {
                    int delay = 0;
                    while (delay < 2000) {
                        sleep(150);
                        delay = delay + 100;
                    }
                    startActivity(new Intent(SplashScreen.this, SignIn.class));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }

        };
        splashScreenStarter.start();

        //loading animation
        iv_loading = findViewById(R.id.loading);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation);
        iv_loading.startAnimation(animation);

        /**
         * <data base - sqlite>
         */

     //   db = openOrCreateDatabase(Project_Utils.DATABASE_NAME, Context.MODE_PRIVATE, null);
      //  Project_Utils.createTables(db);
      //  Project_Utils.insertToTables(db);
        /**
         * </data base>
         */


    }


}