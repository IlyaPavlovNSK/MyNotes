package com.pavlovnsk.notes.components;
import com.pavlovnsk.notes.screens.main.NoteViewModel;

import dagger.Subcomponent;

@Subcomponent
public interface NoteViewModelSubComponent {

    @Subcomponent.Builder
    interface Builder {
        NoteViewModelSubComponent build();
    }

    void inject(NoteViewModel noteViewModel);
}
