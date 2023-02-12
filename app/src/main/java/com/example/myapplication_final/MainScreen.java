package com.example.myapplication_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainScreen extends AppCompatActivity {
    ListView lv_students;
    ArrayList<Student> students_list;
    StudentAdapter adapter;
    FloatingActionButton add_student;
    AlertDialog.Builder builder;
    //data base:
    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        add_student = findViewById(R.id.add_student_fabtn);
        lv_students = findViewById(R.id.lv_students);
        students_list = buildList();
        //creating data base
        database = openOrCreateDatabase(Sqlite_Utils.DATABASE_NAME,
                Context.MODE_PRIVATE, null);


        adapter = new StudentAdapter(MainScreen.this, 0, students_list);
        //click on list view
        lv_students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * shows the student (alert dialog)
             * @param adapterView
             * @param view
             * @param i
             * @param l
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainScreen.this,"clicked!", Toast.LENGTH_SHORT).show();
            }
        });

        lv_students.setAdapter(adapter);
        builder = new AlertDialog.Builder(this);
        //long click on list view
        lv_students.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /**
             * deleting student (alert dialog)
             * @param parent
             * @param view
             * @param position
             * @param id
             * @return
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Student tmp = students_list.get(position);
                //Log.d("tag", tmp.getName());
                builder.setMessage(R.string.dialog_message);
                final  int POSITION_TO_REMOVE = position;
                builder.setCancelable(false);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //finish();
                        students_list.remove(POSITION_TO_REMOVE);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(),"deleted",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();

                    }
                });
                //Creating dialog box
                AlertDialog alert = builder.create();
                //Setting the title manually
                alert.show();

                return true;
            }
        });

        /**
         * fabtn: opening a custom dialog for adding a new student
         */
        add_student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainScreen.this);
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
     */
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
}