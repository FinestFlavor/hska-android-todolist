package de.hska.student.mvvm.todolist.datasource.memory

import android.util.Log
import androidx.lifecycle.MutableLiveData
import de.hska.student.mvvm.todolist.model.Note
import java.util.*

private const val LOG_TAG = "InMemoryRepository"

class InMemoryRepository : InMemoryDao {

    private val liveData = MutableLiveData<List<Note>>()
    private val repository = mutableListOf<Note>()

    override suspend fun insert(note: Note) {
        repository.add(note)
        liveData.value = repository
        liveData.notifyObserver()
        Log.d(LOG_TAG, "insert: $note")
    }

    override fun getAll(): MutableLiveData<List<Note>> {
        liveData.value = Collections.unmodifiableList(repository)
        Log.d(LOG_TAG, "getAll: ${liveData.value}")
        return liveData
    }

    override suspend fun update(note: Note) {
//        val old = liveData.value?.find { it == note }
//        liveData.value?.replace(old, note)
//        Log.d(LOG_TAG, "update: $note")
    }

    override suspend fun delete(note: Note) {
        repository.remove(note)
        liveData.value = repository
        liveData.notifyObserver()
        Log.d(LOG_TAG, "delete: $note")
    }

    private fun <E> Iterable<E>.replace(old: E, new: E) = map { if (it == old) new else it }
    private fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
}