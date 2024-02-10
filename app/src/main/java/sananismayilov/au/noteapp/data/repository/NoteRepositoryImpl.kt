package sananismayilov.au.noteapp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import sananismayilov.au.noteapp.data.local.NoteDao
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(val noteDao: NoteDao) : NoteRepository {
    override suspend fun insertNote(notedto: NoteDto) =
        withContext(Dispatchers.IO)
        { noteDao.insertNote(notedto) }

    override suspend fun deleteNote(noteid: Int) {
        withContext(Dispatchers.IO) {
            noteDao.deleteNote(noteid)
        }
    }


    override suspend fun getNotes(): List<NoteDto> =
        withContext(Dispatchers.IO) {
            noteDao.getNotes()
        }

    override suspend fun deleteallNote() {
        withContext(Dispatchers.IO) {
            noteDao.deleteallNote()
        }
    }

    override suspend fun getNoteDetails(noteid: Int): NoteDto =
        withContext(Dispatchers.IO) {
            noteDao.getNoteDetails(noteid)
        }

}