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
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.mwidlok.realmsample.dao.DaoAccess;
import com.example.mwidlok.realmsample.database.MyDatabase;
import com.example.mwidlok.realmsample.model.PersonRoom;

import java.util.ArrayList;
import java.util.List;

public class RoomActivity extends AppCompatActivity {

    MyDatabase myDatabase;
    Button btnInsertDb;
    LiveData<List<PersonRoom>> liveDatalist;
    final PersonRoom person = new PersonRoom("Max","Mustermann",42);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btnInsertDb = findViewById(R.id.btnSaveData);
        btnInsertDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 if (myDatabase != null)
                 {
                     new AsyncTask<Void,Void,Void>()
                     {
                         @Override
                         protected Void doInBackground(Void... voids) {
                             myDatabase.daoAccess().insertPerson(person);
                             return null;
                         }
                     }.execute();
                 }
                 else
                    Log.e("Room Db","myDatabase is null");
            }
        });
        // setup database.
        // allowMainThreadQueries() möglich, aber nicht zu empfehlen.
        //myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "myDb").allowMainThreadQueries().build();

        // besser: Database Access in Worker Thread.

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "myDb").build();
        liveDatalist = myDatabase.daoAccess().getAllPersons();
        liveDatalist.observe(this, new Observer<List<PersonRoom>>() {
            @Override
            public void onChanged(@Nullable List<PersonRoom> personRooms) {
                Toast t = Toast.makeText(getApplicationContext(),"DB has changed!", Toast.LENGTH_SHORT);
                t.show();
            }
        });
    }
}
