package de.hska.student.mvvm.todolist.di

import android.app.Application
import android.app.SharedElementCallback
import android.telecom.Call
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.hska.student.mvvm.todolist.datasource.INoteDao
import de.hska.student.mvvm.todolist.datasource.NoteRepository
import de.hska.student.mvvm.todolist.datasource.local.NoteDatabase
import javax.inject.Singleton

private const val database_name = "database_note"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(
        app: Application,
        callback: NoteDatabase.Callback
    ) = Room.databaseBuilder(app, NoteDatabase::class.java, database_name)
        .fallbackToDestructiveMigration()
        .addCallback(callback)
        .build()

    @Provides
    fun provideNoteDao(database: NoteDatabase) = database.noteDao()


    @Singleton
    @Provides
    fun provideNoteRepository(dao: INoteDao) = NoteRepository(dao)


}