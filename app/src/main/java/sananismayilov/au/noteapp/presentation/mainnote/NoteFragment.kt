package sananismayilov.au.noteapp.presentation.mainnote

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import sananismayilov.au.noteapp.R
import sananismayilov.au.noteapp.databinding.FragmentNoteBinding

@AndroidEntryPoint
class NoteFragment : Fragment() {
    private lateinit var binding: FragmentNoteBinding
    private lateinit var viewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)


        binding.addnote.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.actionnotetoinsert)
        }

        binding.deleteallnote.setOnClickListener {
            Snackbar.make(it, "Bütün notlarınız silinəcək", Snackbar.LENGTH_SHORT)
                .setAction("Sil", View.OnClickListener {
                    viewModel.deleteallnote()
                })
                .setActionTextColor(Color.RED)
                .show()
        }


        observeNote()
        return binding.root
    }

    private fun observeNote() {
        viewModel.notelist.observe(viewLifecycleOwner, Observer {
            if (it.size == 0) {
                binding.secondlayout.visibility = View.VISIBLE
                binding.noterecyclerview.visibility = View.INVISIBLE
            } else {
                binding.secondlayout.visibility = View.INVISIBLE
                binding.noterecyclerview.visibility = View.VISIBLE
                binding.noterecyclerview.layoutManager = LinearLayoutManager(requireContext())
                noteAdapter = NoteAdapter(requireContext(), viewModel, it)
                binding.noterecyclerview.adapter = noteAdapter
            }
        })

        viewModel.deletestatus.observe(viewLifecycleOwner, Observer {
            if (it) {
                Navigation.findNavController(requireView()).navigate(R.id.refreshpage)
            }
        })

        viewModel.deleteallnotestatus.observe(viewLifecycleOwner, Observer {
            if (it) {
                Navigation.findNavController(requireView()).navigate(R.id.refreshpage)
            }
        })
    }


}