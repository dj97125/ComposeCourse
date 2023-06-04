package com.danielcaballero.mynewcompose.add_tasks.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcaballero.mynewcompose.add_tasks.domain.AddTaskUseCase
import com.danielcaballero.mynewcompose.add_tasks.domain.ErraseTaskUseCase
import com.danielcaballero.mynewcompose.add_tasks.domain.GetTasksUseCase
import com.danielcaballero.mynewcompose.add_tasks.domain.UpdateTaskUseCase
import com.danielcaballero.mynewcompose.add_tasks.ui.TasksUiState.*
import com.danielcaballero.mynewcompose.add_tasks.ui.model.TaskModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val erraseTaskUseCase: ErraseTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {

    val uiState: StateFlow<TasksUiState> = getTasksUseCase().map(::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog


    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTaskCreated(task: String) {
        _showDialog.value = false
        viewModelScope.launch {
            addTaskUseCase(TaskModel(task = task))
        }
    }

    fun onShowDialogClicked() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(taskModel: TaskModel) {
        viewModelScope.launch {
            updateTaskUseCase(taskModel.copy(selected = !taskModel.selected))
        }
    }

    fun onItemRemove(taskModel: TaskModel) {
        viewModelScope.launch {
            erraseTaskUseCase(taskModel)
        }
        //borrar item
//        val task = _tasks.find { it.id == taskModel.id }
//        _tasks.remove(task)
    }


}