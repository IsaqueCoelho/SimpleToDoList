package com.studio.sevenapp.todolist

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.studio.sevenapp.todolist.model.Group
import com.studio.sevenapp.todolist.model.Task
import kotlinx.coroutines.launch

class GroupTaskViewModel : ViewModel() {

    val groupListMS = mutableStateOf<List<Group>>(listOf())
    val groupByIdMS = mutableStateOf<Group?>(null)
    val taskListMS = mutableStateOf<List<Task>>(listOf())

    private val db = Firebase.firestore

    init {
        viewModelScope.launch {
            getGroup()
        }
    }

    private fun getGroup() {
        val transitoryData = mutableListOf<Group>()

        db.collection("stack")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    transitoryData.add(
                        document.toObject<Group>().copy(id = document.id)
                    )
                }
                groupListMS.value = transitoryData.toList()
            }
            .addOnFailureListener { exception ->
                Log.e("HomeContent", "Error getting documents.", exception)
            }
    }

    fun getGroupById(groupId: String) {
        db.collection("stack")
            .document(groupId)
            .get()
            .addOnSuccessListener { result ->
                val group = result.toObject<Group>()
                groupByIdMS.value = group
            }
            .addOnFailureListener { exception ->
                Log.e("HomeContent", "Error getting documents.", exception)
            }
    }

    fun addNewTask(task: SnapshotStateList<Task>) {
        taskListMS.value = task.toList()
    }

}