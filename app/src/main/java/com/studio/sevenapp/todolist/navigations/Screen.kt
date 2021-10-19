package com.studio.sevenapp.todolist.navigations

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NewGroup : Screen("new_group")
    object NewTask : Screen("new_task")
}
