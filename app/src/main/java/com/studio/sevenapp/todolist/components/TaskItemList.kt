package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.studio.sevenapp.todolist.model.Task

@Composable
fun TaskItemList(
    taskList: List<Task>
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(items = taskList, itemContent = {
            TaskItem(task = it)
        })
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewItemList() {
    val taskList = listOf(
        Task(name = "Task 1"),
        Task(name = "Task 2"),
        Task(name = "Task 3")
    )
    TaskItemList(taskList = taskList)
}