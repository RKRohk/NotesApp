package com.example.mynotes.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    suspend fun addNode(note:Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNodes(): List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)
}