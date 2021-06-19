package de.hska.student.mvvm.todolist.datasource

import androidx.lifecycle.asLiveData
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val  noteDao: INoteDao) {
    suspend fun insert(note: Note) {
        noteDao.insert(note)
    }

    fun getAll() : Flow<List<Note>> {
        return noteDao.getAll()
    }

    suspend fun delete(note: Note) {
        noteDao.delete(note)
    }
}