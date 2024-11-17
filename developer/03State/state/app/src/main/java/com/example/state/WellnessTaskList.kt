package com.example.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier


@Composable
fun WellnessTaskList(
        modifier: Modifier = Modifier, list: List<WellnessTask> = remember { getWellnessTasks() }) {
    LazyColumn(modifier = modifier) { 
        items(list) { task -> WellnessTaskItem(taskName = task.label, modifier = modifier)}
    }
}
fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task #$i") }