package com.luongddt.androidexam.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product")
public class Product {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    @ColumnInfo(name = "productName")
    public String Name;

    @ColumnInfo(name = "quantity")
    public int Quantity;

}