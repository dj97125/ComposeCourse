package com.danielcaballero.mynewcompose.add_tasks.domain

import com.danielcaballero.mynewcompose.add_tasks.data.TaskRepo
import com.danielcaballero.mynewcompose.add_tasks.ui.model.TaskModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(
    private val taskRepo: TaskRepo
) {
    operator fun invoke(): Flow<List<TaskModel>> = taskRepo.tasks
}