package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalFoundationApi
@Composable
fun GridViewLayout(
    stringList: List<String>
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(stringList.size){
                GroupTask(
                    text = stringList[it]
                )
            }
        }
    )
}

@ExperimentalFoundationApi
@Preview(
    showBackground = true
)
@Composable
fun PreviewGridView(){
    val stringList = listOf("Personal", "Home", "Work", "University", "Study")
    GridViewLayout(stringList = stringList)
}