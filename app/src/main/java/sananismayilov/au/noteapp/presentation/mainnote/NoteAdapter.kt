package sananismayilov.au.noteapp.presentation.mainnote

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import sananismayilov.au.noteapp.R
import sananismayilov.au.noteapp.R.color.deletecolor
import sananismayilov.au.noteapp.databinding.NotesuiBinding
import sananismayilov.au.noteapp.domain.model.Note

class NoteAdapter(
    val context: Context,
    val noteViewModel: NoteViewModel,
    val notelist: List<Note>
) :
    RecyclerView.Adapter<NoteAdapter.NoteHolder>() {
    val colorlist = arrayOf("#FD99FF", "#FF9E9E", "#91F48F", "#FFF599", "#9EFFFF", "#B69CFF")

    inner class NoteHolder(val binding: NotesuiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val view = NotesuiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteHolder(view)
    }

    override fun getItemCount(): Int {
        return notelist.size
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        var b = false
        val note = notelist[position]

        holder.binding.notecard.setCardBackgroundColor(Color.parseColor(colorlist[position % colorlist.size]))

        holder.binding.notetittle.text = note.notetittle
        holder.binding.notedate.text = note.notedate

        holder.binding.notecard.setOnLongClickListener {
            if (!b) {
                holder.binding.notecard.setCardBackgroundColor(Color.parseColor("#FF0000"))
                holder.binding.notetittle.visibility = View.INVISIBLE
                holder.binding.notedate.visibility = View.INVISIBLE
                holder.binding.deletebutton.visibility = View.VISIBLE
                holder.binding.deletebutton.setOnClickListener {
                    Snackbar.make(it, "Seçilmiş notunuz silinsin?", Snackbar.LENGTH_SHORT)
                        .setAction("Bəli",
                            View.OnClickListener {
                                noteViewModel.deleteNote(note.noteid)
                            }).setActionTextColor(Color.RED)
                        .show()

                }
                b = true
            } else {
                holder.binding.notecard.setCardBackgroundColor(Color.parseColor(colorlist[position % colorlist.size]))
                holder.binding.notetittle.visibility = View.VISIBLE
                holder.binding.notedate.visibility = View.VISIBLE
                holder.binding.deletebutton.visibility = View.INVISIBLE
                b = false
            }


            return@setOnLongClickListener true
        }

        holder.binding.notecard.setOnClickListener {
            val action = NoteFragmentDirections.actionnotetodetail(note.noteid)
            Navigation.findNavController(it).navigate(action)
        }

    }

}
