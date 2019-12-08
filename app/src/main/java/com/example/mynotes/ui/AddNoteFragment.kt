package com.example.mynotes.ui


import android.os.AsyncTask
import android.os.Bundle
import android.renderscript.Script
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.mynotes.R
import com.example.mynotes.db.Note
import com.example.mynotes.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class AddNoteFragment : Basefragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        button_save.setOnClickListener{

            val noteTitle = edit_text_title.text.toString().trim()
            val nodeBody = edit_text_note.text.toString().trim()

            if(noteTitle.isEmpty()){
                edit_text_title.error = "title required"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            launch {
                val note = Note(noteTitle,nodeBody)
                context?.let {
                    NoteDatabase(it).getNoteDao().addNode(note)
                    it.toast("Note Saved")
                }
            }

        }
    }


}
