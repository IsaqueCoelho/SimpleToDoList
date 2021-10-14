package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskItemList(
    taskList: List<String>
){
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(items = taskList, itemContent = {
            TaskItem(text = it)
        })
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewItemList(){
    val taskList = listOf("Task 1", "Task 2", "Task 3")
    TaskItemList(taskList = taskList)
}