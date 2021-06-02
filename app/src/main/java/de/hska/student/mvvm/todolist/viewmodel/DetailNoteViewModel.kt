package de.hska.student.mvvm.todolist.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.memory.InMemoryDao
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailNoteViewModel @Inject constructor(private val dao: InMemoryDao) : ViewModel() {

    fun onclickDelete(note: Note) {
        viewModelScope.launch { dao.delete(note) }
    }
}