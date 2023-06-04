package com.danielcaballero.mynewcompose.add_tasks.ui

import com.danielcaballero.mynewcompose.add_tasks.ui.model.TaskModel

sealed interface TasksUiState {
    object Loading : TasksUiState
    data class Error(val throwable: Throwable) : TasksUiState
    data class Success(val tasks: List<TaskModel>) : TasksUiState
}