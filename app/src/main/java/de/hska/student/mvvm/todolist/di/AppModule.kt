package de.hska.student.mvvm.todolist.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.hska.student.mvvm.todolist.datasource.memory.InMemoryDao

import de.hska.student.mvvm.todolist.datasource.memory.InMemoryRepository
import javax.inject.Singleton

private const val database_name = "database_note"

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Singleton
//    @Provides
//    fun provideNoteDatabase(
//        app: Application
//    ) = Room.databaseBuilder(app, NoteDatabase::class.java, database_name)
//            .fallbackToDestructiveMigration()
//            .build()
//
//    @Provides
//    fun provideNoteDao(database: NoteDatabase) = database.noteDao()



    @Singleton
    @Provides
    fun provideInMemoryRepository() = InMemoryRepository() as InMemoryDao



}