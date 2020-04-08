package com.pavlovnsk.notes.screens.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.pavlovnsk.notes.App;
import com.pavlovnsk.notes.R;
import com.pavlovnsk.notes.Utils;
import com.pavlovnsk.notes.model.Note;

import java.util.Date;

public class DetailNotes extends AppCompatActivity {

    EditText editTitle;
    EditText editDescription;
    FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notes);

        editTitle = findViewById(R.id.et_note_item_title);
        editDescription = findViewById(R.id.et_note_item_description);
        addButton = findViewById(R.id.btn_floatingActionButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTitle.getText().toString();
                String description = editDescription.getText().toString();
                Note note = new Note(title, description, false, new Date().getTime());

                Intent intent = new Intent();
                intent.putExtra("note", note);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
