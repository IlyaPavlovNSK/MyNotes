package com.pavlovnsk.notes.screens.main;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.pavlovnsk.notes.App;
import com.pavlovnsk.notes.AppRepository;
import com.pavlovnsk.notes.model.Note;

import java.util.List;

import javax.inject.Inject;

public class NoteViewModel extends AndroidViewModel {

    private LiveData<List<Note>> notes;
    private AppRepository appRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
        notes = appRepository.getAllNotes();
    }

//    @Inject
//    AppRepository appRepository;
//
//    @Inject
//    public NoteViewModel(@NonNull Application application) {
//        super(application);
//
//        ((App) application)
//                .getNoteViewModelSubComponent()
//                .inject(this);
//
//        notes = appRepository.getAllNotes();
//    }

    public LiveData<List<Note>> getAllNotes() {
        return notes;
    }

    public void addNote(Note note) {
        appRepository.addNote(note);
    }

    public void updateNote(Note note) {
        appRepository.updateNote(note);
    }

    public void deleteNote(Note note) {
        appRepository.deleteNote(note);
    }
}
