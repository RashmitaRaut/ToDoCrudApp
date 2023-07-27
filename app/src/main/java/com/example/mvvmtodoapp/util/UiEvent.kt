package com.example.mvvmtodoapp.util

sealed class UiEvent{
    object PopBackStack: UiEvent()          //request to pop the back stack (i.e., go back to the previous screen) in a navigation scenario.
    data class Navigate(val route: String): UiEvent()
    data class ShowSnackBar(
        val message: String,
        val action: String? = null
    ): UiEvent()
}


/*
data class Navigate(val route: String): UiEvent() -->
This line defines another subclass of
UiEvent called Navigate. It's a data class,
meaning it's used to hold data. In this case,
it holds a single property route, which represents
the destination route for navigation.*/

/*data class ShowSnackBar(...) : UiEvent(): -->
This line defines a third subclass of UiEvent called ShowSnackBar.
Similar to the Navigate class, it's also a data class, and it's used to hold data for
    showing a SnackBar (a type of message or notification) on the UI.
It has two properties: message, which represents the text of the SnackBar,
and action, which represents an optional action text for the SnackBar.*/
