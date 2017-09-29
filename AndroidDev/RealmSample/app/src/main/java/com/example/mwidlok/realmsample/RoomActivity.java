package com.example.mwidlok.realmsample;

import android.arch.persistence.room.Room;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mwidlok.realmsample.database.MyDatabase;
import com.example.mwidlok.realmsample.model.PersonRoom;

import java.util.List;

public class RoomActivity extends AppCompatActivity {

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        // setup database.
        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "myDb").allowMainThreadQueries().build();

        // setup entity.
        PersonRoom person = new PersonRoom("Max","Mustermann",42);

        // write entity via dao in database.
        myDatabase.daoAccess().insertPerson(person);

        // getting data from database.
        List<PersonRoom> persons = myDatabase.daoAccess().getAllPersons();
    }
}
