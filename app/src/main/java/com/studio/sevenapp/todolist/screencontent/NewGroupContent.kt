package com.studio.sevenapp.todolist.screencontent

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.studio.sevenapp.todolist.navigations.Screen
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

@Composable
fun NewGroupContent(navController: NavHostController) {
    var groupName by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.primary)
                    .padding(26.dp),
                textAlign = TextAlign.Center,
                text = "Create New Task",
                color = Color.White
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {

                TextField(
                    value = groupName,
                    onValueChange = { groupName = it },
                    label = {
                        Text(
                            text = "Qual o nome desse grupo",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        bottomBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier.padding(16.dp),
                    onClick = {
                        navController.navigate(
                            Screen.NewTask.createRoute(groupName)
                        )
                    }
                ) {
                    Text(text = "Avan??ar")
                }
            }
        }
    )
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewNewGroupContent() {
    TODoListTheme {
        val navController = rememberNavController()
        NewGroupContent(navController)
    }
}