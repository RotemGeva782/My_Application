package com.example.myapplication_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Project_Utils {
    //lesson types
    final static String PRIVATE_LESSON = "פרטי";
    final static String GROUP_LESSON = "קבוצתי";
    final static String THERAPY = "טיפולי";
    final static String WORKOUT = "אימון";
    final static String BASIC = "מתחילים";
    final static String MACCABI = "מכבי";
    final static String BOARDING_SCHOOL = "פנימייה" ;


    //sqlite
    final static String DATABASE_NAME = "db_project";
    final static String TABLE_NAME_STUDENTS = "tbl_students";
    final static String COL_NAME = "name";
    final static String COL_AGE = "age";
    final static String COL_LESSON_TYPE = "lessonType";
    final static String COL_PARENT_NAME = "parentName";
    final static String COL_PARENT_PHONE = "parentPhone";

    /**
     *
     * @param db
     */
    public static void createTables(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_STUDENTS + "("
                + COL_NAME + " TEXT," + COL_AGE + " TEXT, " + COL_LESSON_TYPE + " TEXT,"
                + COL_PARENT_NAME + " TEXT, " + COL_PARENT_PHONE + " TEXT);");
        //another different table in the same database
    }

    /**
     *
     * @param db
     */
    public static void insertToTables(SQLiteDatabase db) {
        ArrayList<Student> list = buildList();
        for (Student cp : list) {
            db.execSQL("INSERT INTO " + TABLE_NAME_STUDENTS + " VALUES('" + cp.getName() + "','"
                    + cp.getAge() + "'" + ",'" + cp.getLessonType()
                    + "','" + cp.getParentName() + "','" + cp.getParentPhone() + "');");
        }

    }

    public static ArrayList<Student> retrive_Students_List(SQLiteDatabase db) {
        ArrayList<Student> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_STUDENTS, null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                list.add(new Student(c.getString(0), c.getInt(1),c.getString(2), c.getString(3), c.getString(4)));
            }
        }
        return list;
    }


    public static ArrayList<Student> buildList() {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s1 = new Student("adi", 9,
                "group",
                "-------", "1111");
        Student s2 = new Student("roni",
                12, "private", "-------",
                "1111");
        Student s3 = new Student("amit", 6, "group", "--------", "1111");
        Student s4 = new Student("ori", 40, "private",
              "-------", "1111");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        return list;

    }

}
