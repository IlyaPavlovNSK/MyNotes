package com.pavlovnsk.notes.screens.main;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pavlovnsk.notes.App;
import com.pavlovnsk.notes.R;
import com.pavlovnsk.notes.model.Note;
import com.pavlovnsk.notes.screens.detail.DetailNotes;
import com.pavlovnsk.notes.screens.main.adapters.NoteAdapter;
import com.pavlovnsk.notes.screens.main.adapters.SimpleNoteTouchHelperCallback;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 1;

//    @Inject
//    NoteAdapter adapter;
//    @Inject
//    NoteViewModel noteViewModel;

    private NoteAdapter adapter;
    private NoteViewModel noteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        ((App) getApplication())
//                .getAppComponent()
//                .mainActivitySubComponent()
//                .with(this)
//                .build()
//                .inject(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        adapter = new NoteAdapter(noteViewModel);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        ItemTouchHelper.Callback callback = new SimpleNoteTouchHelperCallback(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setItems(notes);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, DetailNotes.class), REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE: {
                    Note note = (Note) data.getSerializableExtra("note");
                    noteViewModel.addNote(note);
                }
            }
        }
    }
}
