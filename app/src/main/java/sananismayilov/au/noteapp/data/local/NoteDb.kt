package sananismayilov.au.noteapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import sananismayilov.au.noteapp.data.local.dto.NoteDto

@Database(entities = arrayOf( NoteDto::class), version = 1)
abstract class NoteDb : RoomDatabase() {
    abstract fun getDao() : NoteDao
}