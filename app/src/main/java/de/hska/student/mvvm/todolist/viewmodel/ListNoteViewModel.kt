package de.hska.student.mvvm.todolist.viewmodel

import android.util.Log
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.memory.InMemoryDao
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val LOG_TAG = "ListNoteViewModel"

@HiltViewModel
class ListNoteViewModel @Inject constructor(private val dao: InMemoryDao) : ViewModel() {
   val notes get() = dao.getAll()
}