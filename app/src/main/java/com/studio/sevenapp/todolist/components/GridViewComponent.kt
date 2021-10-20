package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.studio.sevenapp.todolist.model.Group

@ExperimentalFoundationApi
@Composable
fun GridViewComponent(
    groupList: List<Group>
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(items = groupList, itemContent = {
                GroupTask(
                    text = it.name
                )
            })
        }
    )
}

@ExperimentalFoundationApi
@Preview(
    showBackground = true
)
@Composable
fun PreviewGridView() {
    val fakeGroupList = listOf(
        Group(name = "Personal", taskList = emptyList()),
        Group(name = "Home", taskList = emptyList()),
        Group(name = "Work", taskList = emptyList()),
        Group(name = "University", taskList = emptyList()),
        Group(name = "Study", taskList = emptyList())
    )
    GridViewComponent(groupList = fakeGroupList)
}