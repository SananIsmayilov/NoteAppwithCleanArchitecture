package sananismayilov.au.noteapp.presentation.notedetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.use_case.getNoteDetails.getNoteDetailusecase
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(val getNoteDetailsUseCase : getNoteDetailusecase) : ViewModel() {
    val note = MutableLiveData<NoteDto>()
    var job : Job? = null
    

    fun getNoteDetail(noteid : Int ){
        job?.cancel()
        job = getNoteDetailsUseCase.executegetNoteDetails(noteid).onEach {
            note.value = it
        }.launchIn(viewModelScope)
    }

}