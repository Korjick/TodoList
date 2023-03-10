package ru.itlab.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton floatingActionButton;
    private RecyclerView recyclerView;

    private NotesAdapter notesAdapter;

    private NotesDatabase notesDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesDatabase = NotesDatabase.getInstance(getApplication());

        floatingActionButton = findViewById(R.id.floating);
        recyclerView = findViewById(R.id.notesRecycler);

        notesAdapter = new NotesAdapter();
        notesAdapter.setOnNoteClickListener(note -> {
            notesDatabase.notesDAO().remove(note.id);
            dataUpdated();
        });
        recyclerView.setAdapter(notesAdapter);

        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddNewNoteActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dataUpdated();
    }

    private void dataUpdated(){
        notesAdapter.setData(notesDatabase.notesDAO().getNotes());
    }
}