package com.pavlovnsk.notes.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.pavlovnsk.notes.model.Note;

import java.util.List;

@Dao
public interface NoteDao {

    @Query("SELECT * FROM note")
    LiveData<List<Note>> getAll();

    @Query("SELECT * FROM note Where id LIKE :id")
    LiveData<Note> getNote(long id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNote(Note note);

    @Delete
    void deleteNote(Note note);

    @Update
    void updateNote(Note note);
}
