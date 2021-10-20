package com.studio.sevenapp.todolist.navigations

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.screencontent.GroupTaskStackContent
import com.studio.sevenapp.todolist.screencontent.HomeContent
import com.studio.sevenapp.todolist.screencontent.NewGroupContent
import com.studio.sevenapp.todolist.screencontent.NewTaskStackContent

@ExperimentalMaterialApi
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
        composable(route = Screen.NewTask.route){ backStackEntry ->
            val groupName = backStackEntry.arguments?.getString("group_name")
            requireNotNull(groupName) { "Group Name parameter wasn't found. Please make sure it's set!" }
            NewTaskStackContent(navController = navController, groupName)
        }
        composable(route = Screen.Group.route){ backStackEntry ->
            val groupId = backStackEntry.arguments?.getString("group_id")
            requireNotNull(groupId) { "Group Name parameter wasn't found. Please make sure it's set!" }
            GroupTaskStackContent(navController = navController, groupId)
        }
    }
}