package com.studio.sevenapp.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.studio.sevenapp.todolist.navigations.NavigationGraph
import com.studio.sevenapp.todolist.ui.theme.TODoListTheme

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODoListTheme {
                NavigationGraph()
            }
        }
    }
}