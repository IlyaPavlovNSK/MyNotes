package com.pavlovnsk.notes.components;

import androidx.appcompat.app.AppCompatActivity;

import com.pavlovnsk.notes.AppModule;
import com.pavlovnsk.notes.screens.main.MainActivity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = {AppModule.class})
public interface MainActivitySubComponent {

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        Builder with(AppCompatActivity activity);
        MainActivitySubComponent build();
    }

    void inject(MainActivity mainActivity);
}
