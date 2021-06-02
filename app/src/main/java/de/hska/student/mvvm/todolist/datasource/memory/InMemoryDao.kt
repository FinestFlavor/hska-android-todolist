package de.hska.student.mvvm.todolist.datasource.memory

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.flow.Flow


interface InMemoryDao {

    suspend fun insert(note: Note)

    fun getAll(): MutableLiveData<List<Note>>

    suspend fun update(note: Note)

    suspend fun delete(note: Note)
}