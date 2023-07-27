package com.example.mvvmtodoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {         //Dao stands for Data Access Object

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(toDo:ToDo)

    @Delete
    suspend fun deleteToDo(toDo:ToDo)

    @Query("Select * FROM todo WHERE id = :id")
    suspend fun getToDoById(id: Int): ToDo?

    @Query("SELECT * FROM todo")
    fun getToDos(): Flow<List<ToDo>>

/*    getToDos(): This function is defined with the return type Flow<List<ToDo>>.
    It means that the function will return a Flow of lists of ToDo objects.
    The Flow will emit new lists of ToDo objects whenever there are changes to the database
    that affect the result of the query.*/
}

/*
The primary purpose of a DAO is to abstract the database operations,
such as insertion, deletion, and querying, from the rest of the application.*/

/*The suspend modifier in the function signature indicates that the insertToDo
function is a suspending function, which means it can be safely called from a
coroutine or another suspending function. Suspended functions are designed to perform
long-running or asynchronous tasks without blocking the main thread.*/

/*The function signature you provided indicates that getToDos returns a Flow<List<ToDo>>.
In Kotlin, Flow is a reactive streams implementation that represents a sequence of values
that can be asynchronously collected and consumed. Using Flow in conjunction with Room
allows you to observe changes to the database and receive updates in real-time.*/
