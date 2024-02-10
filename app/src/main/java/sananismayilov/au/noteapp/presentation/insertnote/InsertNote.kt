package sananismayilov.au.noteapp.presentation.insertnote

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint
import sananismayilov.au.noteapp.R
import sananismayilov.au.noteapp.data.local.dto.NoteDto
import sananismayilov.au.noteapp.databinding.FragmentInsertNoteBinding
import java.util.Calendar

@AndroidEntryPoint
class InsertNote : Fragment() {
    private lateinit var binding: FragmentInsertNoteBinding
    private lateinit var viewModel: InsertNoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInsertNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(InsertNoteViewModel::class.java)

        binding.savebutton.setOnClickListener {
            insertNote()
        }

        binding.backbutton.setOnClickListener {
            backmainNote()
        }


        observeInsertNote()
        return binding.root
    }

    private fun insertNote() {
        val notetittle = binding.notetittle.text.toString()
        val notecontent = binding.notecontent.text.toString()
        val calendar = Calendar.getInstance()

        val date =
            "${calendar.get(Calendar.DAY_OF_MONTH)}" + "." + "${calendar.get(Calendar.MONTH) + 1}" + "." + "${
                calendar.get(Calendar.YEAR)
            }"
        if (!TextUtils.isEmpty(notetittle) && !TextUtils.isEmpty(notecontent)) {
            val notedto = NoteDto(0, notetittle, notecontent, date, false)
            viewModel.insertNote(notedto)
        }
    }

    private fun observeInsertNote() {
        viewModel.insertstatus.observe(viewLifecycleOwner, Observer {
            if (it) {
                Navigation.findNavController(requireView()).navigate(R.id.actioninserttonote)
            }
        })
    }

    private fun backmainNote() {
        Navigation.findNavController(requireView()).navigate(R.id.actioninserttonote)
    }

}