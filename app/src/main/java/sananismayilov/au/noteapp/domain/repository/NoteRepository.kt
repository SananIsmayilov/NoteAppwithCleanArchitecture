package sananismayilov.au.noteapp.domain.repository


import sananismayilov.au.noteapp.data.local.dto.NoteDto

interface NoteRepository {

    suspend fun insertNote(notedto: NoteDto)

    suspend fun deleteNote(noteid: Int)

    suspend fun getNotes(): List<NoteDto>

    suspend fun deleteallNote()

    suspend fun getNoteDetails(noteid: Int): NoteDto

}