package com.example.mvvmtodoapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


/*These classes are part of the Room persistence library,
which is used for local data storage in Android applications.*/

@Entity
data class ToDo(
    val title: String,
    val description: String?,
    val isDone: Boolean,

    @PrimaryKey val id: Int? = null
)

/*
@Entity and @PrimaryKey are annotations provided by the Android Room persistence library.
They are used to define the structure of a database table and its primary key in an Android app
that uses Room for local data storage.*/

/*The ToDo data class is marked as an entity using @Entity.
It will be used to represent a table in the database.
The properties title, description, and isDone will become columns in the table.
The id property is also marked with @PrimaryKey,
indicating that it will be the primary key for the table, and its values will uniquely identify.*/

/*
In the provided code snippet,
the id property of the ToDo data class is marked as the primary key using @PrimaryKey.
This means that each ToDo object will have a unique id, and Room will use this property to
identify rows in the corresponding table.*/
