package com.example.myapplication_final;

public class Student {

    private String name;
    private int age;
    private String lessonType;
    private int numOfLessons;
    private String parentName;
    private String parentMail;
    private String parentPhone;


    public Student(String name, int age, String lessonType, int numOfLessons, String parentName, String parentMail, String parentPhone) {
        this.name = name;
        this.age = age;
        this.lessonType = lessonType;
        this.numOfLessons = numOfLessons;
        this.parentName = parentName;
        this.parentMail = parentMail;
        this.parentPhone = parentPhone;
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

    public int getNumOfLessons() {
        return numOfLessons;
    }

    public void setNumOfLessons(int numOfLessons) {
        this.numOfLessons = numOfLessons;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentMail() {
        return parentMail;
    }

    public void setParentMail(String parentMail) {
        this.parentMail = parentMail;
    }

    public String getParentPhone() {
        return parentPhone;
    }

    public void setParentPhone(String parentPhone) {
        this.parentPhone = parentPhone;
    }


}
