package sananismayilov.au.noteapp.domain.use_case.deleteNote

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.repository.NoteRepository
import javax.inject.Inject

class deleteNoteusecase @Inject constructor(private val noteRepository: NoteRepository){
    fun executedeleteNote(noteid: Int) : Flow<Boolean> = flow {
       try {
           noteRepository.deleteNote(noteid)
           emit(true)

       }catch (e : Exception){
           emit(false)
       }

    }

}