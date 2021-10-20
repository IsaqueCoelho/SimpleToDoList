package com.studio.sevenapp.todolist.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.navigations.Screen

@ExperimentalMaterialApi
@Composable
fun GroupTask(
    groupId: String,
    text: String = "",
    navController: NavController
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(150.dp)
            .padding(8.dp),
        shape = MaterialTheme.shapes.small,
        elevation = 4.dp,
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .wrapContentWidth()
                        .padding(16.dp),
                    text = text,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        onClick = {
            navController.navigate(
                Screen.Group.createRoute(groupId = groupId)
            )
        },
    )
}

@ExperimentalMaterialApi
@Preview(
    showBackground = true
)
@Composable
fun PreviewGroupTask() {

    val navController = rememberNavController()
    GroupTask(
        groupId = "FakeGroupId",
        text = "Pessoal",
        navController = navController
    )
}