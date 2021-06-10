package de.hska.student.mvvm.todolist.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.memory.InMemoryDao
import javax.inject.Inject

private const val LOG_TAG = "ListNoteViewModel"

@HiltViewModel
class ListNoteViewModel @Inject constructor(private val dao: InMemoryDao) : ViewModel() {
   val notes get() = dao.getAll()
}