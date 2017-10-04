package com.example.mwidlok.realmsample.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.mwidlok.realmsample.model.PersonRoom;

import java.util.List;

/**
 * Created by MWidlok on 29.09.2017.
 */

@Dao
public interface DaoAccess {
    @Insert
    void insertPerson(PersonRoom person);

    @Query("SELECT * FROM PersonRoom")
    LiveData<List<PersonRoom>> getAllPersons();

}
