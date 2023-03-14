package ru.itlab.todolist;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class AddNoteActivityViewModel extends AndroidViewModel {
    private NotesDatabase notesDatabase;
    private MutableLiveData<Boolean> addNoteLiveData;

    public AddNoteActivityViewModel(@NonNull Application application) {
        super(application);
        notesDatabase = NotesDatabase.getInstance(application);
        addNoteLiveData = new MutableLiveData<>(false);
    }

    public LiveData<Boolean> getAddNoteLiveData(){
        return addNoteLiveData;
    }

    public void add(Note note){
        new Thread(() -> {
            notesDatabase.notesDAO().add(note);
            addNoteLiveData.postValue(true);
        }).start();
    }
}
