package com.studio.sevenapp.todolist.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.screencontent.HomeContent
import com.studio.sevenapp.todolist.screencontent.NewGroupContent
import com.studio.sevenapp.todolist.screencontent.NewTaskStackContent

@ExperimentalFoundationApi
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeContent(navController = navController)
        }
        composable(route = Screen.NewGroup.route) {
            NewGroupContent(navController = navController)
        }
        composable(route = Screen.NewTask.route){
            NewTaskStackContent(navController = navController)
        }
    }
}