package com.example.mynotes.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.R
import com.example.mynotes.db.Note
import kotlinx.android.synthetic.main.fragment_card.view.*

class NotesAdapter(private val notes: List<Note>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(com.example.mynotes.R.layout.fragment_card,parent,false)
        )
    }

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        Log.i("RunningATest",notes[position].title + " " + notes[position].note)
        holder.itemView.text_view_title.text = notes[position].title
        holder.itemView.text_view_note.text = notes[position].note
    }

    class NoteViewHolder(view:View) : RecyclerView.ViewHolder(view)

}