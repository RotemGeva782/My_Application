package com.example.myapplication_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Sqlite_Utils {
    final static String DATABASE_NAME = "db_project";
    final static String TABLE_NAME_STUDENTS = "tbl_students";
    final static String COL_NAME = "name";
    final static String COL_AGE = "age";
    final static String COL_LESSON_TYPE = "lessonType";
    final static String COL_NUM_OF_LESSONS = "numOfLessons";
    final static String COL_PARENT_NAME = "parentName";
    final static String COL_PARENT_MAIL = "parentMail";
    final static String COL_PARENT_PHONE = "parentPhone";


    public static void createTables(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_STUDENTS + "(" + COL_NAME + " TEXT," + COL_AGE + " TEXT, "
                + COL_LESSON_TYPE + " TEXT, " + COL_NUM_OF_LESSONS + " TEXT," + COL_PARENT_NAME + " TEXT, " + COL_PARENT_MAIL + " TEXT, " + COL_PARENT_PHONE + " TEXT);");
    }

    public static void insertToTables(SQLiteDatabase db) {
        ArrayList<Student> list = buildList();
        for (Student cp : list) {
            db.execSQL("INSERT INTO " + TABLE_NAME_STUDENTS + " VALUES('" + cp.getName() + "','" + cp.getAge() + "'" +
                    ",'" + cp.getLessonType() + "','" + cp.getNumOfLessons() + "','" + cp.getParentMail() + "','" + cp.getParentName() + "','" + cp.getParentPhone() + "');");
        }

    }

    public static ArrayList<Student> retriveList(SQLiteDatabase db) {
        ArrayList<Student> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_STUDENTS + "", null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                //list.add(new Student)
            }
        }
        return list;
    }


    public static ArrayList<Student> buildList() {
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
