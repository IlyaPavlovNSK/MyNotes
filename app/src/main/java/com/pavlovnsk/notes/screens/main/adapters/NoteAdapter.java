package com.pavlovnsk.notes.screens.main.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pavlovnsk.notes.R;
import com.pavlovnsk.notes.model.Note;
import com.pavlovnsk.notes.screens.main.NoteViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> implements NoteTouchHelperAdapter{

    private List<Note> notes;
    private Note tempNote;
    private int keyPosition;
    private NoteViewModel noteViewModel;

    //@Inject
    public NoteAdapter(NoteViewModel noteViewModel) {
        this.noteViewModel = noteViewModel;
        this.notes = new ArrayList<>();
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NoteViewHolder(view, noteViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = notes.get(position);
        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public void setItems(List<Note> list) {
        notes = list;
        notifyDataSetChanged();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(notes, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(notes, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onItemDismissLeft(int position) {
        tempNote = notes.get(position);
        keyPosition = position;
        notes.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onItemDismissRight(int position) {

    }

    @Override
    public void returnItem(int position) {
        noteViewModel.addNote(tempNote);
        notes.add(keyPosition, tempNote);
        notifyDataSetChanged();
    }

    @Override
    public void removeItem() {
        noteViewModel.deleteNote(tempNote);
        notifyDataSetChanged();
    }
}
