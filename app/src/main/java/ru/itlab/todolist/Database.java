package ru.itlab.todolist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Database {

    public static Database instance;

    private List<Note> notes;
    private Random random;

    static {
        instance = new Database();
    }

    private Database() {
        notes = new ArrayList<>();
        random = new Random();
        for (int i = 0; i < 5; i++) {
            notes.add(new Note(random.nextInt(3),
                    "Note: " + i));
        }
    }

    public void addNote(int priority, String description){
        // new Note()
        // finish()
    }

    public List<Note> getNotes(){
        return new ArrayList<>(notes);
    }
}
