package com.example.mwidlok.realmsample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.mwidlok.realmsample.dao.DaoAccess;
import com.example.mwidlok.realmsample.database.MyDatabase;
import com.example.mwidlok.realmsample.model.PersonRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        // setup database.
        // allowMainThreadQueries() möglich, aber nicht zu empfehlen.
        //myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "myDb").allowMainThreadQueries().build();

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "myDb").build();

        LiveData<List<PersonRoom>> liveDatalist = myDatabase.daoAccess().getAllPersons();
        liveDatalist.observe(this, new Observer<List<PersonRoom>>() {
            @Override
            public void onChanged(@Nullable List<PersonRoom> personRooms) {
                Log.i("Room Database","Data was updated.!");
            }
        });

        // Database Access in Worker Thread.

//        new AsyncTask<Void,Void,List<PersonRoom>>()
//        {
//            @Override
//            protected List<PersonRoom> doInBackground(Void... voids) {
//                return myDatabase.daoAccess().getAllPersons();
//
//            }
//        }.execute();

//        new AsyncTask<Void,Void,Boolean>()
//        {
//            final PersonRoom person = new PersonRoom("Max","Mustermann",42);
//            @Override
//            protected Boolean doInBackground(Void... voids) {
//                myDatabase.daoAccess().insertPerson(person);
//                return true;
//            }
//        }.execute();
    }
}
