package com.example.myapplication_final;

public class Student {
    private static int idSt = 2;
    private String name;
    private int age;
    private String lessonType; //project_Utils
    private String parentName;
    private String parentPhone;

    /**
     * student cursor
     * @param name
     * @param age
     * @param lessonType
     * @param parentName
     * @param parentPhone
     */
    public Student(String name, int age, String lessonType, String parentName,
                   String parentPhone) {
        idSt+=1;
        this.name = name;
        this.age = age;
        this.lessonType = lessonType;
        this.parentName = parentName;
        this.parentPhone = parentPhone;
    }



    public static int getIdSt() {
        return idSt;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }



    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }


    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }


}
