package com.example.myapplication_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainScreen extends AppCompatActivity implements View.OnClickListener {
    ListView lv_insert_lesson;
    ArrayList<Student> students_list;
    StudentAdapter adapter;

    TextView datePicker;
    AlertDialog.Builder builder;

    //stam us used in order to go to ShowStudents activity for a while
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
             * shows the student
             * it is important, because if two students will have the same name and last name
             * the user wont be able to recognizance them in this activity
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


        /**
         * <date picker>
         */



        // on below line we are initializing our variables.

        datePicker = findViewById(R.id.date_picker_main);
        Date date = new Date();

        // on below line we are adding click listener for our pick date button
        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // the instance of our calendar.
                final Calendar c = Calendar.getInstance();

                // on below line we are getting
                // our day, month and year.
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);


                // on below line we are creating a variable for date picker dialog.
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        // on below line we are passing context.

                        MainScreen.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        // on below line we are setting date to our text view.
                        date.setDate(dayOfMonth);
                        date.setMonth(monthOfYear);
                        date.setYear(year);
                        datePicker.setText(date.getDay() + "-" + (date.getMonth() + 1) +
                                "-" + date.getYear());

                    }
                },
                        // on below line we are passing year,
                        // month and day for selected date in our date picker.
                        year, month, day);

                // at last we are calling show to
                // display our date picker dialog.

                datePickerDialog.show();
            }
        });

        /**
         * </date picker>
         */

    }//endOf_onCreate

    public void onDateSet(DatePicker datePicker, int nYear, int nMonth, int nDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy");
        Calendar.getInstance().set(nYear, nMonth, nDay);
        String dateString = sdf.format(Calendar.getInstance().getTime());
        //datePicker.setText(dateString);
        Toast.makeText(this, ""+dateString, Toast.LENGTH_SHORT).show();
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


