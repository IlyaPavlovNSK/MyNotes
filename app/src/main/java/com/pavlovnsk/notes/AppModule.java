package com.pavlovnsk.notes;


import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import com.pavlovnsk.notes.data.NoteDatabase;
import com.pavlovnsk.notes.screens.main.NoteViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

//    @Provides
//    public NoteDatabase getNoteDatabase(Application application) {
//        return Room.databaseBuilder(application, NoteDatabase.class, "NoteDatabase")
//                .fallbackToDestructiveMigration()
//                .build();
//    }
//
//    @Provides
//    public NoteViewModel getNoteViewModel(AppCompatActivity activity){
//        return ViewModelProviders.of(activity).get(NoteViewModel.class);
//    }
}
