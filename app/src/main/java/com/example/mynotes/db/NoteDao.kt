package com.example.mynotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun addNode(note:Note)

    @Query("SELECT * FROM note")
    fun getAllNodes(): List<Note>

    @Insert
    fun addMultipleNotes(vararg note: Note)
}