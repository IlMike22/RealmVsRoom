package com.example.mwidlok.realmsample.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by MWidlok on 28.09.2017.
 */

public class Person extends RealmObject {

    @PrimaryKey
    private long Id;

    private int Age;
    private String FirstName;
    private String LastName;

    public Person()
    {

    }
    public Person(int id, String firstname, String lastname, int age)
    {
        Id = id;
        FirstName = firstname;
        LastName = lastname;
        Age = age;
    }

    // Getter / Setter

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFristname() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }
}
