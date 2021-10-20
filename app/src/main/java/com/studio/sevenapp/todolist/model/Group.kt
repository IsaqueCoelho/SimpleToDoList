package com.studio.sevenapp.todolist.model

data class Group(
    val name: String,
    val taskList: List<Task> = emptyList()
)
