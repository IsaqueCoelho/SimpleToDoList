package com.studio.sevenapp.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.components.GridViewComponent
import com.studio.sevenapp.todolist.components.NewTaskForm
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODoListTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "home" ){
                    composable(route = "home"){
                        ScaffoldContent(navController)
                    }
                    composable(route = "new_task"){
                        NewTaskForm()
                    }
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
fun ScaffoldContent(navController: NavHostController) {
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
                    navController.navigate("new_task")
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
            GridViewComponent(emptyList())
        }
    )
}

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PreviewScaffoldContent() {
    TODoListTheme {
        val navController = rememberNavController()
        ScaffoldContent(navController)
    }
}