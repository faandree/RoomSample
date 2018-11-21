package com.example.faand.roomsample.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey
    public int id;
    public String name;
    public String number;

}
