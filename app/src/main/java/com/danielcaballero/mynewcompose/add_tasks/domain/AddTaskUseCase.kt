package com.danielcaballero.mynewcompose.add_tasks.domain

import com.danielcaballero.mynewcompose.add_tasks.data.TaskRepo
import com.danielcaballero.mynewcompose.add_tasks.ui.model.TaskModel
import javax.inject.Inject

class AddTaskUseCase @Inject constructor(private val taskRepo: TaskRepo) {

    suspend operator fun invoke(taskModel: TaskModel) = taskRepo.add(taskModel)
}