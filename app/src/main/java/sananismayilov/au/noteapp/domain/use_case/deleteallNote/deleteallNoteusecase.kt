package sananismayilov.au.noteapp.domain.use_case.deleteallNote

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class deleteallNoteusecase @Inject constructor(val noteRepository: NoteRepository) {

    fun executedeleteallnote() : Flow<Boolean> = flow {

        try {
            noteRepository.deleteallNote()
            emit(true)
        }catch (e : Exception){
            emit(false)
        }



    }
}