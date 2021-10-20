package com.studio.sevenapp.todolist.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import com.studio.sevenapp.todolist.components.TaskItemList
import com.studio.sevenapp.todolist.model.Group
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

@Composable
fun GroupTaskStackContent(navController: NavHostController, groupId: String){

    val viewModel: GroupTaskViewModel = viewModel()
    viewModel.getGroupById(groupId = groupId)

    val group = viewModel.groupByIdMS

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
            group.value?.let {
                TaskListContent(it)
            }
        },
        bottomBar = {
            Button(
                modifier = Modifier.padding(16.dp),
                onClick = { navController.popBackStack() }
            ) {
                Text(text = "voltar")
            }
        }
    )
}

@Composable
fun TaskListContent(group: Group) {
    Column {
        Text(text = group.name)
        TaskItemList(taskList = group.taskList)
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewGroupTaskStackContent() {
    TODoListTheme {
        val navController = rememberNavController()
        GroupTaskStackContent(navController, "fakeIdGroup")
    }
}