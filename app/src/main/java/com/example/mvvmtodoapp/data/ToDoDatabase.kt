package com.example.mvvmtodoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ToDo::class],           //entities: This parameter is an array of entity classes
                version = 1             /*version: This parameter specifies the version of the database.
                                         If you need to make changes to the database schema in the future,
                                         you can increment this version number.*/
)
abstract class ToDoDatabase: RoomDatabase() {
    abstract val dao: ToDoDao
}