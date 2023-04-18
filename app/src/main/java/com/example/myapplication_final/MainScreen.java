package com.example.myapplication_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    ListView lv_insert_lesson;
    ArrayList<Student> students_list;
    StudentAdapter adapter;
    AlertDialog.Builder builder;
    Button stam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        lv_insert_lesson = findViewById(R.id.lv_insert_lesson);
        students_list = buildList();
        stam = findViewById(R.id.button_go_to_students);
        stam.setOnClickListener(this);

        adapter = new StudentAdapter(MainScreen.this, 0, students_list);
        //click on list view
        lv_insert_lesson.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * shows the student (alert dialog)
             * @param adapterView
             * @param view
             * @param i
             * @param l
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainScreen.this, "clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        lv_insert_lesson.setAdapter(adapter);



    }

    /**
     * building list for example
     *
     * @return list
     */
    public ArrayList<Student> buildList() {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s1 = new Student("adi", 9, "-------", "1111");
        Student s2 = new Student("roni", 12, "-------", "1111");
        Student s3 = new Student("amit", 6, "--------", "1111");
        Student s4 = new Student("ori", 40, "-------", "1111");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        return list;
    }

    @Override
    public void onClick(View v) {
        Intent intent_to_show_students = new Intent(this, ShowStudents.class);
        startActivity(intent_to_show_students);
    }
}


