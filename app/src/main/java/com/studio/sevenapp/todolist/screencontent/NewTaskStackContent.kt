package com.studio.sevenapp.todolist.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.components.TaskItemList
import com.studio.sevenapp.todolist.model.Task
import com.studio.sevenapp.todolist.navigations.Screen
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme
import com.studio.sevenapp.todolist.ui.theme.Teal200

@Composable
fun NewTaskStackContent(navController: NavHostController, groupName: String) {

    val taskList: MutableList<Task> = mutableListOf()

    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.primary)
                    .padding(26.dp),
                textAlign = TextAlign.Center,
                text = "Create new task stack",
                color = Color.White
            )
        },
        content = {
            TaskItemList(taskList = taskList)
        },
        bottomBar = {
            NewTaskStackForm(navController = navController, taskList = taskList)
        }
    )
}

@Composable
fun NewTaskStackForm(navController: NavHostController, taskList: MutableList<Task>) {
    Column {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var text by remember { mutableStateOf("") }

            TextField(
                modifier = Modifier.requiredWidthIn(),
                value = text,
                onValueChange = { text = it }
            )

            IconButton(
                onClick = {
                    taskList.add(
                        Task(name = text)
                    )
                }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Check,
                    tint = Teal200,
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "voltar")
            }
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo("home") { inclusive = true }
                    }
                }
            ) {
                Text(text = "salvar")
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewNewTaskStackContent() {
    TODoListTheme {
        val navController = rememberNavController()
        NewTaskStackContent(navController, "PGroup Name")
    }
}