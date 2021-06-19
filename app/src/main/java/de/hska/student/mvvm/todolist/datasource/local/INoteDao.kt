package de.hska.student.mvvm.todolist.datasource

import androidx.room.*
import de.hska.student.mvvm.todolist.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface INoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Query("SELECT * FROM table_note")
    fun getAll() : Flow<List<Note>>

    @Delete
    suspend fun delete(note: Note)
}
