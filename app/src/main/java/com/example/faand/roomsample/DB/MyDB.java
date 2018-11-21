package com.example.faand.roomsample.DB;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.example.faand.roomsample.Dao.ContactDao;
import com.example.faand.roomsample.Entities.Contact;

@Database(entities = {Contact.class}, version=1)
public abstract class MyDB extends RoomDatabase {

    private static MyDB INSTANCE;

    public abstract ContactDao daoAcess();


}
