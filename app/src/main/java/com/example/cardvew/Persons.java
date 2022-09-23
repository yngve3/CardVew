package com.example.cardvew;

public class Persons {
    private final String name;
    private final int age;
    private final int photoId;

    public Persons(String name, int age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPhotoId() {
        return photoId;
    }
}
