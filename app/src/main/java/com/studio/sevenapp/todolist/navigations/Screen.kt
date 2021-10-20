package com.studio.sevenapp.todolist.navigations

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object NewGroup : Screen("new_group")
    object NewTask : Screen("{group_name}/new_task"){
        fun createRoute(groupName: String) = "$groupName/new_task"
    }
}
