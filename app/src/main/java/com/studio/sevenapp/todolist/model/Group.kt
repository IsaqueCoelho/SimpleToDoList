package com.studio.sevenapp.todolist.model

data class Group(
    val id: String? = null,
    val name: String = "",
    val tasks: List<Task> = emptyList()
)
