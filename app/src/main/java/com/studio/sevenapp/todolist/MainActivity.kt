package com.studio.sevenapp.todolist

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODoListTheme {
                // A surface container using the 'background' color from the theme
                ScaffoldContent()
            }
        }
    }
}

@Composable
fun ScaffoldContent() {
    Scaffold(
        topBar = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.primary)
                    .padding(26.dp),
                textAlign = TextAlign.Center,
                text = "Stack App",
                color = Color.White
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Log.e("LOG FAB", "LOG FAB CLICK")
                },
                content = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Button"
                    )
                }
            )
        },
        floatingActionButtonPosition = FabPosition.End,
        content = {
            Greeting("Android")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewScaffoldContent() {
    ScaffoldContent()
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TODoListTheme {
        Greeting("Android")
    }
}