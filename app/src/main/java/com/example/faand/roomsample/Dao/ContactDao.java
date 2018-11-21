package com.example.faand.roomsample.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.faand.roomsample.Entities.Contact;

@Dao
public interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertContact(Contact... Contacts);

    @Query("select * from contact")
    public Contact[] loadAllContacts();
}
