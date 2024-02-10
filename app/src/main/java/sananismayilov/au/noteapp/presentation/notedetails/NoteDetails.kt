package sananismayilov.au.noteapp.presentation.notedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import sananismayilov.au.noteapp.R
import sananismayilov.au.noteapp.databinding.FragmentNoteDetailsBinding

@AndroidEntryPoint
class NoteDetails : Fragment() {
    private lateinit var binding: FragmentNoteDetailsBinding
    private lateinit var viewmodel: NoteDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_note_details, container, false)
        viewmodel = ViewModelProvider(this).get(NoteDetailsViewModel::class.java)

        arguments.let {
            val noteid = it?.getInt("noteid")
            if (noteid != null) {
                viewmodel.getNoteDetail(noteid)
            }
        }

        observeNoteDetail()
        return binding.root
    }

    fun observeNoteDetail() {
        viewmodel.note.observe(viewLifecycleOwner, Observer {
            binding.note = it
        })
    }

}