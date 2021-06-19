package de.hska.student.mvvm.todolist.viewmodel

import androidx.annotation.NonNull
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.hska.student.mvvm.todolist.datasource.NoteRepository
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailNoteViewModel @Inject constructor(private val repo: NoteRepository) : ViewModel() {

    fun onclickDelete(note: Note) {
        viewModelScope.launch { repo.delete(note) }
    }
}