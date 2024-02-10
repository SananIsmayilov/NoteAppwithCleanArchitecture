package sananismayilov.au.noteapp.presentation.mainnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.model.Note
import sananismayilov.au.noteapp.domain.use_case.deleteNote.deleteNoteusecase
import sananismayilov.au.noteapp.domain.use_case.deleteallNote.deleteallNoteusecase
import sananismayilov.au.noteapp.domain.use_case.getNotesusecase.getNotesusecase

import javax.inject.Inject
@HiltViewModel
class NoteViewModel @Inject constructor(val getNotesusecase: getNotesusecase,val deleteNoteusecase: deleteNoteusecase ,val deleteallNoteusecase: deleteallNoteusecase) : ViewModel() {

    var job : Job? = null
    val notelist = MutableLiveData<List<Note>>()
    val deletestatus = MutableLiveData<Boolean>(false)
    val deleteallnotestatus = MutableLiveData<Boolean>(false)

    init {
        getNote()
    }

    fun getNote(){

        job?.cancel()

        job = getNotesusecase.executeget_Notes().onEach {
                notelist.value = it
        }.launchIn(viewModelScope)

    }

    fun deleteNote(noteid: Int){
        job?.cancel()
        job = deleteNoteusecase.executedeleteNote(noteid).onEach {
            deletestatus.value = it
        }
            .launchIn(viewModelScope)
    }

    fun deleteallnote(){
        job?.cancel()
        job = deleteallNoteusecase.executedeleteallnote().onEach {
            deleteallnotestatus.value = it
        }.launchIn(viewModelScope)
    }



    override fun onCleared() {
        job?.cancel()
        super.onCleared()
    }
}