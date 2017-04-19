package com.yagmur.pawadmin.Model;

/**
 * Created by Yagmur on 5.2.2017. ''
 */

public class Dog {
    private String dogID, dogBreed, capturedReason, capturedRegion, generalSituation, applications;
    private int age, capturedDate;
    private boolean gender;

    public Dog(String dogID, int age) {
        this.dogID = dogID;
        this.age = age;
    }

    public String getDogID() {
        return dogID;
    }
}
