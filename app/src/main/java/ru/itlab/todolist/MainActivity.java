package ru.itlab.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

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

    private LayoutInflater layoutInflater;
    private LinearLayoutCompat linearLayoutCompat;
    private FloatingActionButton floatingActionButton;

    @Override
    protected void onResume() {
        super.onResume();
        linearLayoutCompat.removeAllViews();
        List<Note> notes = Database.instance.getNotes();
        for (int i = 0; i < notes.size(); i++) {
            TextView note = (TextView) layoutInflater.inflate(R.layout.note, null, false);
            linearLayoutCompat.addView(note);
            note.setText(notes.get(i).text);
            switch (notes.get(i).priority) {
                case 0:
                    note.setBackgroundColor(getResources().getColor(R.color.green));
                    break;
                case 1:
                    note.setBackgroundColor(getResources().getColor(R.color.yellow));
                    break;
                case 2:
                    note.setBackgroundColor(getResources().getColor(R.color.red));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayoutCompat = findViewById(R.id.linerLayout);
        layoutInflater = getLayoutInflater();
        floatingActionButton = findViewById(R.id.floating);

        floatingActionButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AddNewNoteActivity.class);
            startActivity(intent);
        });
    }
}