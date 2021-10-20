package com.studio.sevenapp.todolist.model

data class Task(
    val done: Boolean = false,
    val doneDate: String? = null,
    val name: String
)
