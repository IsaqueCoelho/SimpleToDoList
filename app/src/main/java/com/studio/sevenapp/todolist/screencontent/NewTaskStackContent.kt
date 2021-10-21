package com.studio.sevenapp.todolist.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.GroupTaskViewModel
import com.studio.sevenapp.todolist.components.TaskItemList
import com.studio.sevenapp.todolist.model.Group
import com.studio.sevenapp.todolist.model.Task
import com.studio.sevenapp.todolist.navigations.Screen
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme
import com.studio.sevenapp.todolist.ui.theme.Teal200

@Composable
fun NewTaskStackContent(navController: NavHostController, groupName: String) {

    val viewModel: GroupTaskViewModel = viewModel()
    val taskList = remember { mutableStateListOf<Task>() }
    val navigateBack = viewModel.mustPopBackStack.value

    if(navigateBack){
        navController.navigate(Screen.Home.route) {
            popUpTo("home") { inclusive = true }
        }
    }

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
            val newTaskList = viewModel.taskListMS.value
            TaskItemList(taskList = newTaskList)
        },
        bottomBar = {
            NewTaskStackForm(
                navController = navController,
                taskList = taskList,
                viewModel = viewModel,
                groupName = groupName
            )
        }
    )

}

@Composable
fun NewTaskStackForm(
    navController: NavHostController,
    taskList: SnapshotStateList<Task>,
    viewModel: GroupTaskViewModel,
    groupName: String
) {
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

                    viewModel.addNewTask(
                        taskList
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
                    viewModel.addNewGroup(
                        Group(
                            name = groupName,
                            tasks = taskList.toList()
                        )
                    )
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