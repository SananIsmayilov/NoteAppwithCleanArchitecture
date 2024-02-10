package sananismayilov.au.noteapp.presentation.insertnote

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.domain.use_case.insertNoteusecase.insertNoteusecase
import javax.inject.Inject
@HiltViewModel
class InsertNoteViewModel @Inject constructor(private val insertNoteusecase: insertNoteusecase) :
    ViewModel() {
    val insertstatus = MutableLiveData<Boolean>(false)
    var job: Job? = null
    fun insertNote(notedto: NoteDto) {
        job = insertNoteusecase.executeinsertNote(notedto).onEach {
            insertstatus.value = it
        }
            .launchIn(viewModelScope)
    }


}