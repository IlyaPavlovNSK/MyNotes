package com.pavlovnsk.notes.components;

import android.app.Application;

import com.pavlovnsk.notes.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@dagger.Component(modules = {AppModule.class})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder withApplication(Application application);

        AppComponent build();
    }

    NoteViewModelSubComponent.Builder noteViewModelSubComponent();

    MainActivitySubComponent.Builder mainActivitySubComponent();
}
