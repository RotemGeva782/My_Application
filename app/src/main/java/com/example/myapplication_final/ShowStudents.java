package com.example.myapplication_final;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class ShowStudents extends AppCompatActivity {
    ListView lv_students_list;
    FloatingActionButton add_student;
    ArrayList<Student> students_list;
    StudentAdapter adapter;
    AlertDialog.Builder builder;
    Dialog dialog;
    EditText et_studentName_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_students);

        // assigning ID of the toolbar to a variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // using toolbar as ActionBar
        setSupportActionBar(toolbar);
        add_student = findViewById(R.id.add_student_fabtn);
        lv_students_list = findViewById(R.id.lv_students_list);
        students_list = buildList();
        adapter = new StudentAdapter(ShowStudents.this, 0, students_list);



        //click on list view
        lv_students_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * shows the student (custom dialog)
             * @param adapterView
             * @param view
             * @param i
             * @param l
             */
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Student tmp = students_list.get(i);

                Toast.makeText(ShowStudents.this, "clicked!", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(ShowStudents.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.customview_show_student,
                        viewGroup, false);
                ImageView editImg = dialogView.findViewById(R.id.iv_editStudent);
                editImg.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        openEditDialog(tmp);
                    }
                });
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();


            }
        });

        lv_students_list.setAdapter(adapter);
        builder = new AlertDialog.Builder(this);
        //long click on list view
        lv_students_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
                final int POSITION_TO_REMOVE = position;
                builder.setCancelable(false);
                builder.setPositiveButton("כן", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        //finish();
                        students_list.remove(POSITION_TO_REMOVE);
                        adapter.notifyDataSetChanged();
                        Toast.makeText(getApplicationContext(), "לא",
                                Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("לא", new DialogInterface.OnClickListener() {
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
                AlertDialog.Builder builder = new AlertDialog.Builder(ShowStudents.this);
                ViewGroup viewGroup = findViewById(android.R.id.content);
                View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.customview_add_student, viewGroup, false);
                builder.setView(dialogView);
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

    }
    /*
    public void createRegisterDialog()
    {
        d= new Dialog(this);
        d.setContentView(R.layout.register_layout);
        d.setTitle("Register");
        d.setCancelable(true);
        etEmail=(EditText)d.findViewById(R.id.etEmail);
        etPass=(EditText)d.findViewById(R.id.etPass);
        btnReg=(Button)d.findViewById(R.id.btnRegister);
        btnReg.setOnClickListener(this);
        d.show();

    }

     */
    private void openEditDialog(Student tmp) {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.customview_add_student);

        et_studentName_add = dialog.findViewById(R.id.et_studentName_add);
        //complete other elements...

        et_studentName_add.setText(tmp.getName());
    }

    /**
     * <searchView>
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu with items using MenuInflator
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        // Initialise menu item search bar
        // with id and take its object
        MenuItem searchViewItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) searchViewItem.getActionView();


        // attach setOnQueryTextListener
        // to search view defined above
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            // Override onQueryTextSubmit method which is call when submit query is searched
            @Override
            public boolean onQueryTextSubmit(String query) {
                // If the list contains the search query than filter the adapter
                // using the filter method with the query as its argument
                if (students_list.contains(query)) {
                    Toast.makeText(ShowStudents.this, "true", Toast.LENGTH_SHORT).show();
                    adapter.getFilter().filter(query);
                } else {
                    // Search query not found in List View
                    Toast.makeText(ShowStudents.this, "Not found", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            // This method is overridden to filter the adapter according
            // to a search query when the user is typing search
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }




    /**
     * </searchView>
     */


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
}