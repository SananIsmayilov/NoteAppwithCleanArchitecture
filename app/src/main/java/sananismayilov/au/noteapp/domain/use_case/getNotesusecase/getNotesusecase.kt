package sananismayilov.au.noteapp.domain.use_case.getNotesusecase

import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import sananismayilov.au.noteapp.domain.model.Note
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class getNotesusecase @Inject constructor(private val noteRepository: NoteRepository) {
    fun executeget_Notes() : Flow<List<Note>> = flow {
        val notes = noteRepository.getNotes()
        val note = notes.map { noteDto ->
            Note(noteDto.noteid,noteDto.notetittle,noteDto.notedate)
        }
        try {
            emit(note)
        }catch (e : Exception){

        }
    }

}