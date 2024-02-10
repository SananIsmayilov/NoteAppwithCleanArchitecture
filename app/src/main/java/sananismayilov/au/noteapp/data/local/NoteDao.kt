package sananismayilov.au.noteapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import sananismayilov.au.noteapp.data.local.dto.NoteDto

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(notedto: NoteDto)

    @Query("DELETE FROM Note WHERE  Note.noteid = :noteid")
    suspend fun deleteNote(noteid: Int)


    @Query("SELECT * FROM Note")
    suspend fun getNotes(): List<NoteDto>

    @Query("DELETE FROM Note")
    suspend fun deleteallNote()

    @Query("SELECT * FROM Note WHERE Note.noteid = :noteid")
    suspend fun getNoteDetails(noteid: Int): NoteDto
}