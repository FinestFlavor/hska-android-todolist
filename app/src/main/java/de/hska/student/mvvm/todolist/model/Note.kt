package de.hska.student.mvvm.todolist.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.text.DateFormat
import java.util.*

@Parcelize
@Entity(tableName = "table_note")
data class Note(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val header: String,
    val body: String,
    val timestamp: Long = System.currentTimeMillis()
) : Parcelable {
    val timestampFormatted: String get() = DateFormat.getDateTimeInstance().format(timestamp)

}
