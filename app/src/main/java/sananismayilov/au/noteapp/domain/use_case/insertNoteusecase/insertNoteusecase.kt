package sananismayilov.au.noteapp.domain.use_case.insertNoteusecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class insertNoteusecase @Inject constructor(val noteRepository: NoteRepository) {

    fun executeinsertNote(notedto: NoteDto): Flow<Boolean> = flow {

        try {
            noteRepository.insertNote(notedto)
            emit(true)
        } catch (e: Exception) {
        }
        emit(false)
    }
}