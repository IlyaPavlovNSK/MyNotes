package com.pavlovnsk.notes;
import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.pavlovnsk.notes.data.NoteDatabase;
import com.pavlovnsk.notes.model.Note;

import java.util.List;

import javax.inject.Inject;

public class AppRepository {

//    @Inject
//    NoteDatabase noteDatabase;
//
//    @Inject
//    public AppRepository(NoteDatabase noteDatabase) {
//        this.noteDatabase = noteDatabase;
//    }

    private NoteDatabase noteDatabase;

    public AppRepository(Application application) {
        this.noteDatabase = Room.databaseBuilder(application, NoteDatabase.class, "NoteDatabase")
                .fallbackToDestructiveMigration()
                .build();
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteDatabase.getNoteDao().getAll();
    }

    public void addNote(Note note) {
        new AddNoteAsyncTask(noteDatabase).execute(note);
    }

    public void deleteNote(Note note){
        new DeleteNoteAsyncTask(noteDatabase).execute(note);
    }

    public void updateNote(Note note){
        new UpdateNoteAsyncTask(noteDatabase).execute(note);
    }



    private static class AddNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDatabase noteDatabase;

        public AddNoteAsyncTask(NoteDatabase noteDatabase) {
            this.noteDatabase = noteDatabase;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDatabase.getNoteDao().addNote(notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDatabase noteDatabase;

        public DeleteNoteAsyncTask(NoteDatabase noteDatabase) {
            this.noteDatabase = noteDatabase;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDatabase.getNoteDao().deleteNote(notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void>{

        private NoteDatabase noteDatabase;

        public UpdateNoteAsyncTask(NoteDatabase noteDatabase) {
            this.noteDatabase = noteDatabase;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDatabase.getNoteDao().updateNote(notes[0]);
            return null;
        }
    }
}

