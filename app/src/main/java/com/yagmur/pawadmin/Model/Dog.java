package com.yagmur.pawadmin.Model;

import android.graphics.Bitmap;

/**
 * Created by Yagmur on 5.2.2017. ''
 */

public class Dog {
    private String dogID, dogBreed, capturedReason, capturedRegion, generalSituation, applications;
    private int age, capturedDate;
    private boolean gender;
    private Bitmap bitmap;

    public Dog(String dogID, int age) {
        this.dogID = dogID;
        this.age = age;
    }

    public Dog(String dogID, int age, Bitmap bitmap) {
        this.dogID = dogID;
        this.age = age;
        this.bitmap = bitmap;
    }

    public String getDogID() {
        return dogID;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
