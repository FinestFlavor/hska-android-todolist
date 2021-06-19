package de.hska.student.mvvm.todolist.viewmodel

import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.NoteRepository
import javax.inject.Inject

private const val LOG_TAG = "ListNoteViewModel"

@HiltViewModel
class ListNoteViewModel @Inject constructor(private val repo: NoteRepository) : ViewModel() {
   private val _notes get() = repo.getAll()
   val notes get() = _notes.asLiveData()
}