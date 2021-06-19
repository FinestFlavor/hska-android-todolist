package de.hska.student.mvvm.todolist.datasource.local

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import de.hska.student.mvvm.todolist.datasource.INoteDao
import de.hska.student.mvvm.todolist.model.Note
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): INoteDao

    class Callback
    @Inject constructor(
        private val database: Provider<NoteDatabase>
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            val dao = database.get().noteDao()
        }
    }


}


/*companion object {
    // Singleton prevents multiple instances of database opening at the same time.
    // Its a bit redundant since we instantiate the db in NoteApplication where we already make
    // sure to prevent the usage of multiple instances.
    @Volatile
    private var INSTANCE: NoteDatabase? = null

    fun getDatabase(context: Context): NoteDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                NoteDatabase::class.java,
                "note_database"
            ).build()
            INSTANCE = instance
            // return instance
            instance
        }
    }
}
}*/
