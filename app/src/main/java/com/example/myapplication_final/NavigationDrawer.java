package com.example.myapplication_final;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NavigationDrawer extends AppCompatActivity {

    FloatingActionButton add_student;

    //data base:
    SQLiteDatabase database;

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        add_student = findViewById(R.id.add_student_fabtn);

        //creating data base
        database = openOrCreateDatabase(Project_Utils.DATABASE_NAME,
                Context.MODE_PRIVATE, null);

        //navigation bar:
        //drawerLayout = findViewById(R.id.)



        /**
         * fabtn: opening a custom dialog for adding a new student
         */
        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NavigationDrawer.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.customview_add_student, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });



    }







    /**
     * building list
     *
     * @return list

    public ArrayList<Student> buildList() {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s1 = new Student("adi", 9, "group", 3, "-------", "1111", "11111");
        Student s2 = new Student("roni", 12, "private", 4, "-------", "1111", "11111");
        Student s3 = new Student("amit", 6, "group", 2, "--------", "1111", "11111");
        Student s4 = new Student("ori", 40, "private", 3, "-------", "1111", "11111");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        return list;
    }
     */
}