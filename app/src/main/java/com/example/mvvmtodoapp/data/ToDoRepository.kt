package com.example.mvvmtodoapp.data

import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    suspend fun insertToDo(toDo:ToDo)

    suspend fun deleteToDo(toDo:ToDo)

    suspend fun getToDoById(id: Int): ToDo?

    fun getToDos(): Flow<List<ToDo>>

}