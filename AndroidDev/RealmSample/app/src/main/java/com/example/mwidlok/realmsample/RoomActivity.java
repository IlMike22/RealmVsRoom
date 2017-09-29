package com.example.mwidlok.realmsample;

import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        new AsyncTask<Void,Void,Boolean>()
        {
            final PersonRoom person = new PersonRoom("Max","Mustermann",42);
            @Override
            protected Boolean doInBackground(Void... voids) {
                myDatabase.daoAccess().insertPerson(person);
                return true;
            }

            protected void onPostExecute()
            {
                // getting data from database.
                List<PersonRoom> persons = myDatabase.daoAccess().getAllPersons();
            }

        }.execute();
        // setup entity.


        // write entity via dao in database.



    }
}
