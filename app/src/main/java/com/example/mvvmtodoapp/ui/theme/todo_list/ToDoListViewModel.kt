package com.example.mvvmtodoapp.ui.theme.todo_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtodoapp.data.ToDo
import com.example.mvvmtodoapp.data.ToDoRepository
import com.example.mvvmtodoapp.util.Routes
import com.example.mvvmtodoapp.util.UiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ToDoListViewModel @Inject constructor(
    private val repository: ToDoRepository
): ViewModel() {

    val todos = repository.getToDos()

    private val _uiEvent = Channel<UiEvent> (  )
    val uiEvent = _uiEvent.receiveAsFlow()

    private var deleteToDo: ToDo? = null

    fun onEvent(event: ToDoListEvent){
        when(event){
            is ToDoListEvent.OnTodoClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.Add_EDIT_TODO + "?todoId=${event.todo.id}"))
            }
            is ToDoListEvent.OnAddToDoClick -> {
               sendUiEvent(UiEvent.Navigate(Routes.Add_EDIT_TODO))
            }
            is ToDoListEvent.OnUndoDeleteClick -> {
                deleteToDo?.let { toDo ->
                    viewModelScope.launch {
                        repository.insertToDo(toDo)
                    }
                }

            }
            is ToDoListEvent.OnDeleteToDoClick -> {
                viewModelScope.launch {
                    deleteToDo = event.todo
                    repository.deleteToDo(event.todo)
                    sendUiEvent(UiEvent.ShowSnackBar(
                        message = "ToDo deleted",
                        action = "Undo"
                    ))
                }
            }
            is ToDoListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    repository.insertToDo(
                        event.todo.copy(
                            isDone = event.isDone
                        )

                    )
                }
            }


        }
    }

    private fun sendUiEvent(event: UiEvent){
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}