package com.danielcaballero.mynewcompose.add_tasks.data

import com.danielcaballero.mynewcompose.add_tasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepo @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TaskModel>> =
        taskDao.getTasks().map { items -> items.map { TaskModel(it.id, it.task, it.selected) } }

    suspend fun add(taskModel: TaskModel) {
        taskDao.addTask(TaskEntity(taskModel.id, taskModel.task, taskModel.selected))
    }

    suspend fun update(taskModel: TaskModel) {
        taskDao.updateTask(TaskEntity(taskModel.id, taskModel.task, taskModel.selected))
    }

    suspend fun errase(taskModel: TaskModel) {
        taskDao.errase(TaskEntity(taskModel.id, taskModel.task, taskModel.selected))
    }
}