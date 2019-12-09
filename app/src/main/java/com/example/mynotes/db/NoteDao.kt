package com.example.mynotes.db

import androidx.room.*

@Dao
interface NoteDao {

    @Insert
    suspend fun addNode(note:Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    suspend fun getAllNodes(): List<Note>

    @Insert
    suspend fun addMultipleNotes(vararg note: Note)

    @Update
    suspend fun updateNode(note:Note)

    @Delete
    suspend fun deleteNote(note:Note)
}