package ru.itlab.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class AddNewNoteActivity extends AppCompatActivity {

    private EditText noteDescription;
    private RadioGroup radioGroup;
    private Button addNoteButton;

    private NotesDatabase notesDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_note);

        notesDatabase = NotesDatabase.getInstance(getApplication());

        noteDescription = findViewById(R.id.noteDescription);
        radioGroup = findViewById(R.id.radioGroup);
        addNoteButton = findViewById(R.id.addNote);

        addNoteButton.setOnClickListener(view -> {
            int idx = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
            notesDatabase.notesDAO().add(new Note(idx, noteDescription.getText().toString()));
            finish();
        });
    }
}