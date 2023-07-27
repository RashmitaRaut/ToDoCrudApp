package com.example.mvvmtodoapp.ui.theme.todo_list

import com.example.mvvmtodoapp.data.ToDo

sealed class ToDoListEvent{
    data class OnDeleteToDoClick(val todo: ToDo):ToDoListEvent()
    data class OnDoneChange(val todo: ToDo, val isDone: Boolean): ToDoListEvent()
    object OnUndoDeleteClick: ToDoListEvent()
    data class OnTodoClick(val todo: ToDo): ToDoListEvent()


    object OnAddToDoClick: ToDoListEvent()

}
