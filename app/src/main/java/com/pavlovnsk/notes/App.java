package com.pavlovnsk.notes;

import android.app.Application;

import com.pavlovnsk.notes.components.AppComponent;

import com.pavlovnsk.notes.components.DaggerAppComponent;
import com.pavlovnsk.notes.components.NoteViewModelSubComponent;

public class App extends Application {
//    private AppComponent appComponent;
//    private NoteViewModelSubComponent noteViewModelSubComponent;
//
//    @Override
//    public void onCreate() {
//        super.onCreate();
//
//        appComponent = DaggerAppComponent
//                .builder()
//                .withApplication(this)
//                .build();
//
//        noteViewModelSubComponent = appComponent
//                .noteViewModelSubComponent()
//                .build();
//    }
//
//    public AppComponent getAppComponent() {
//        return appComponent;
//    }
//
//    public NoteViewModelSubComponent getNoteViewModelSubComponent() {
//        return noteViewModelSubComponent;
//    }
}
