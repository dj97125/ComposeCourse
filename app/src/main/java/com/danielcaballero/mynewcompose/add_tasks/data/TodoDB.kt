package com.danielcaballero.mynewcompose.add_tasks.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [TaskEntity::class],version = 1)
abstract class TodoDB: RoomDatabase() {
    abstract fun taskDao(): TaskDao

}