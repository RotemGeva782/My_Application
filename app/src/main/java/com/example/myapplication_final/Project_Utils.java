package com.example.myapplication_final;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.w3c.dom.Text;

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
    //table 1: students
    final static String TABLE_NAME_STUDENTS = "tbl_students";
    final static String COL_ID_ST = "idSt";
    final static String COL_NAME = "name";
    final static String COL_AGE = "age";
    final static String COL_PARENT_NAME = "parentName";
    final static String COL_PARENT_PHONE = "parentPhone";

    //table 2: general lesson
    final static String TABLE_NAME_GENERAL_LESSONS = "tbl_general_lesson";
    final static String COL_ID_LE = "idLeGeneral";
    final static String COL_TYPE = "type";
    final static String COL_PRICE = "price";

    //table 3: attendance
    final static String TABLE_NAME_LESSONS = "tbl_attendance";
    final static String COL_ID_AT = "idAt";
    final static String COL_ID_STUDENT = "idSt";
    final static String COL_ID_GENERAL_LESSON = "idGeneral_lesson";
    final static String COL_DATE = "date";
    final static String COL_MISSING = "missing";
    final static String COL_NUM_OF_LESSONS = "numOfLessons";


    /**
     *
     * @param db
     * create tables
     */
    public static void createTables(SQLiteDatabase db) {

        //table 1: students
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_STUDENTS + "("+ COL_ID_ST + "INTEGER,"
                + COL_NAME + " TEXT," + COL_AGE + " INTEGER, "
                + COL_PARENT_NAME + " TEXT, " + COL_PARENT_PHONE + " TEXT);");
        //table 2: general lesson
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_GENERAL_LESSONS + "("+ COL_ID_LE + "INTEGER,"
                + COL_TYPE + " TEXT," + COL_PRICE + " TEXT);");
        //table 3: attendance
        db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME_LESSONS + "("+ COL_ID_AT + "INTEGER,"
                + COL_ID_STUDENT + " INTEGER," + COL_ID_GENERAL_LESSON + " INTEGER, "
                + COL_DATE + " TEXT, " + COL_MISSING + " BIT," + COL_NUM_OF_LESSONS + " INTEGER);");

    }

    /**
     *
     * @param db
     * insert the students from the array list to the student table
     *
     * הפעולה לא צריכה לקבל ? ArrayList
     */
    public static void insertToTables(SQLiteDatabase db) {
        ArrayList<Student> list = buildList();
        for (Student cp : list) {
            db.execSQL("INSERT INTO " + TABLE_NAME_STUDENTS + " VALUES('" + cp.getName() + "','"
                    + cp.getAge() + "','" + cp.getParentName() + "','" + cp.getParentPhone() + "');");
        }

    }

    /**
     *
     * @param db
     * @return an array list of students from the students table
     */
    public static ArrayList<Student> retrive_Students_List(SQLiteDatabase db) {
        ArrayList<Student> list = new ArrayList<>();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_NAME_STUDENTS, null);
        if (c.getCount() != 0) {
            while (c.moveToNext()) {
                list.add(new Student(c.getString(0), c.getInt(1),c.getString(2), c.getString(3)));
            }
        }
        return list;
    }

    /**
     *
     * @return an array list for example
     */

    public static ArrayList<Student> buildList() {
        ArrayList<Student> list = new ArrayList<Student>();
        Student s1 = new Student("adi", 9,
                "-------", "1111");
        Student s2 = new Student("roni",
                12, "-------",
                "1111");
        Student s3 = new Student("amit", 6, "--------", "1111");
        Student s4 = new Student("ori", 40,
              "-------", "1111");

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        return list;

    }

}
