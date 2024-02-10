package sananismayilov.au.noteapp.data.local.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import sananismayilov.au.noteapp.domain.model.Note

@Entity("Note")
data class NoteDto(
    @ColumnInfo("noteid")
    @PrimaryKey(autoGenerate = true)
    val noteid : Int = 0,


    @ColumnInfo("notetittle")
    val notetittle : String,

    @ColumnInfo("note")
    val note : String,

    @ColumnInfo("notedate")
    val notedate : String,

    @ColumnInfo("importanttype")
    val importanttype : Boolean
)




