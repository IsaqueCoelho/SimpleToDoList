package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.model.Group

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun GridViewComponent(
    groupList: List<Group>,
    navController: NavController
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(items = groupList, itemContent = {
                GroupTask(
                    groupId = it.id,
                    text = it.name,
                    navController = navController
                )
            })
        }
    )
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Preview(
    showBackground = true
)
@Composable
fun PreviewGridView() {
    val fakeGroupList = listOf(
        Group(name = "Personal", tasks = emptyList()),
        Group(name = "Home", tasks = emptyList()),
        Group(name = "Work", tasks = emptyList()),
        Group(name = "University", tasks = emptyList()),
        Group(name = "Study", tasks = emptyList())
    )
    val navController = rememberNavController()

    GridViewComponent(
        groupList = fakeGroupList,
        navController = navController
    )
}