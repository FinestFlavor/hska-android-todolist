package de.hska.student.mvvm.todolist.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.memory.InMemoryDao
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val LOG_TAG = "CreateNoteViewModel"

@HiltViewModel
class CreateNoteViewModel @Inject constructor(private val dao: InMemoryDao) : ViewModel() {

    var noteHeader: String = ""
    var noteBody: String = ""

    fun onClickSave() {
        create(note = Note(header = noteHeader, body = noteBody))
    }

    private fun create(note: Note) = viewModelScope.launch {
        Log.d(LOG_TAG, "create: $note")
//        dao.insert(note)
//        datasource.inMemoryDao().insert(note)
        dao.insert(note)
        Log.d(LOG_TAG, "getAll: $note")
        dao.getAll()
    }

}