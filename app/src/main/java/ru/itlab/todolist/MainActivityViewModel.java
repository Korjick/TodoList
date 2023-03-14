package ru.itlab.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private NotesDatabase notesDatabase;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        notesDatabase = NotesDatabase.getInstance(application);
    }

    public LiveData<List<Note>> getNotes(){
        return notesDatabase.notesDAO().getNotes();
    }

    public void remove(Note note) {
        new Thread(() -> notesDatabase.notesDAO().remove(note.id)).start();
    }
}
