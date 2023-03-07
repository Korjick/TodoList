package ru.itlab.todolist;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int priority;
    public String text;

    public Note(int id, int priority, String text) {
        this.id = id;
        this.priority = priority;
        this.text = text;
    }
}
