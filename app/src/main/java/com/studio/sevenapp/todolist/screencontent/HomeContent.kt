package com.studio.sevenapp.todolist.screencontent

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.GroupTaskViewModel
import com.studio.sevenapp.todolist.components.GridViewComponent
import com.studio.sevenapp.todolist.navigations.Screen
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun HomeContent(navController: NavHostController) {

    val viewModel: GroupTaskViewModel = viewModel()
    val groupList = viewModel.groupListMS.value
    viewModel.getGroup()

    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.primary)
                    .padding(26.dp),
                textAlign = TextAlign.Center,
                text = "Stack App",
                color = Color.White
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.NewGroup.route)
                },
                content = {
                    Icon(
                        imageVector = Icons.Rounded.Add,
                        contentDescription = "Add Button",
                        tint = Color.White
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = {
            GridViewComponent(
                navController = navController,
                groupList = groupList
            )
        }
    )
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PreviewHomeContent() {
    TODoListTheme {
        val navController = rememberNavController()
        HomeContent(navController)
    }
}