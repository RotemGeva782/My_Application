package com.example.myapplication_final;

import android.content.*;
import android.view.*;
import android.widget.*;

import java.util.*;

public class StudentAdapter extends ArrayAdapter<Student> {
    Context context;
    ArrayList<Student> students;

    public StudentAdapter(Context context, int resource, ArrayList<Student> students) {
        super(context, resource, students);
        this.context = context;
        this.students = students;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Student student_tmp = students.get(position);
        View view = LayoutInflater.from(context).inflate(R.layout.row_showall, null);

        TextView tv_name = view.findViewById(R.id.student_name_main);
        TextView tv_lessonType = view.findViewById(R.id.student_lessonType);
        TextView tv_age = view.findViewById(R.id.student_age);

        tv_name.setText(student_tmp.getName());
        tv_lessonType.setText(student_tmp.getLessonType());
        tv_age.setText(String.valueOf(student_tmp.getAge()));

        return view;
    }



}
