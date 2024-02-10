package sananismayilov.au.noteapp.domain.use_case.getNoteDetails

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class getNoteDetailusecase @Inject constructor(val noteRepository: NoteRepository) {
    fun executegetNoteDetails(noteid : Int) : Flow<NoteDto> = flow{
        try {
            val notedto = noteRepository.getNoteDetails(noteid)
            emit(notedto)
        }catch (e : Exception){

        }
    }

}