package com.pavlovnsk.notes.screens.main.adapters;

import android.graphics.Paint;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavlovnsk.notes.R;
import com.pavlovnsk.notes.Utils;
import com.pavlovnsk.notes.model.Note;
import com.pavlovnsk.notes.screens.main.NoteViewModel;

import java.util.Date;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;
    private TextView dateOfOpening;
    private TextView dateOfClosure;
    private CheckBox checkBox;

    private Note note;

    NoteViewHolder(@NonNull View itemView, final NoteViewModel noteViewModel) {
        super(itemView);

        title = itemView.findViewById(R.id.tv_title);
        description = itemView.findViewById(R.id.tv_description);
        dateOfOpening = itemView.findViewById(R.id.tv_dateOfOpening);
        dateOfClosure = itemView.findViewById(R.id.tv_dateOfClosure);
        checkBox = itemView.findViewById(R.id.checkbox);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {
                    note.setDone(checked);
                    noteViewModel.updateNote(note);
                }else {
                    note.setDone(checked);
                    noteViewModel.updateNote(note);
                }
            }
        });
    }

    public void bind(Note note) {
        this.note = note;

        getTitle().setText(note.getTitle());
        getDescription().setText(note.getDescription());
        getDateOfOpening().setText(Utils.dateFormat.format(new Date(note.getDateOfOpening())));

        if (note.getDateOfClosure() == 0) {
            getDateOfClosure().setText("");
        } else {
            getDateOfClosure().setText(Utils.dateFormat.format(new Date(note.getDateOfClosure())));
        }

        getCheckBox().setChecked(note.isDone());
        updateStrokeOut();
    }

    private void updateStrokeOut() {
        if (note.isDone()) {
            title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            dateOfClosure.setText(Utils.dateFormat.format(new Date()));
        } else {
            title.setPaintFlags(title.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
            dateOfClosure.setText("");
        }
    }

    public TextView getTitle() {
        return title;
    }

    public TextView getDescription() {
        return description;
    }

    public TextView getDateOfOpening() {
        return dateOfOpening;
    }

    public TextView getDateOfClosure() {
        return dateOfClosure;
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }
}
