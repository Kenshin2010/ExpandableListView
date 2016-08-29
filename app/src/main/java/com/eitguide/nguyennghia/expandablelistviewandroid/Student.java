package com.eitguide.nguyennghia.expandablelistviewandroid;

/**
 * Created by nguyennghia on 8/29/16.
 */
public class Student {
    private String name;
    private float mediumScore;

    public Student() {
    }

    public Student(String name, float mediumScore) {
        this.name = name;
        this.mediumScore = mediumScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMediumScore() {
        return mediumScore;
    }

    public void setMediumScore(float mediumScore) {
        this.mediumScore = mediumScore;
    }
}
