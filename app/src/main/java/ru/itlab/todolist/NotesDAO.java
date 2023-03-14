package ru.itlab.todolist;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface NotesDAO {

    @Query("SELECT * FROM notes")
    LiveData<List<Note>> getNotes();

    @Insert
    void add(Note note);

    @Query("DELETE FROM notes WHERE id=:id")
    void remove(int id);
}
