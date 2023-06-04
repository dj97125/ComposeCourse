package com.danielcaballero.mynewcompose.add_tasks.di

import android.content.Context
import androidx.room.Room
import com.danielcaballero.mynewcompose.add_tasks.data.TaskDao
import com.danielcaballero.mynewcompose.add_tasks.data.TodoDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideTaskDao(todoDB: TodoDB): TaskDao = todoDB.taskDao()

    @Provides
    @Singleton
    fun provideTodoDataBase(@ApplicationContext appContext: Context): TodoDB =
        Room.databaseBuilder(appContext, TodoDB::class.java, "TaskDB").build()
}