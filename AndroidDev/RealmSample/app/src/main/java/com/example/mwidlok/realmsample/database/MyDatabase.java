package com.example.mwidlok.realmsample.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mwidlok.realmsample.dao.DaoAccess;
import com.example.mwidlok.realmsample.model.PersonRoom;

/**
 * Created by MWidlok on 29.09.2017.
 */

@Database(entities = {PersonRoom.class}, version = 1)
public abstract class MyDatabase extends RoomDatabase
{
    public abstract DaoAccess daoAccess();
}



