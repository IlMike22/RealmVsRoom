package com.example.mwidlok.realmsample.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by MWidlok on 28.09.2017.
 */

@Entity
public class PersonRoom {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String Firstname;
    private String Lastname;
    private int Age;


    public PersonRoom()
    {

    }
    public PersonRoom(String firstname, String lastname, int age)
    {
        Firstname = firstname;
        Lastname = lastname;
        Age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
