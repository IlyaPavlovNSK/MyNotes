package com.pavlovnsk.notes.screens.main.adapters;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

public class SimpleNoteTouchHelperCallback extends ItemTouchHelper.Callback{

    private NoteAdapter mAdapter;

    public SimpleNoteTouchHelperCallback(NoteAdapter adapter) {
        mAdapter = adapter;
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        int dragFlags = ItemTouchHelper.UP | ItemTouchHelper.DOWN;
        int swipeFlags = ItemTouchHelper.START | ItemTouchHelper.END;
        return makeMovementFlags(dragFlags, swipeFlags);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        mAdapter.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        return true;
    }

    @Override
    public void onSwiped(@NonNull final RecyclerView.ViewHolder viewHolder, int direction) {
        mAdapter.onItemDismissLeft(viewHolder.getAdapterPosition());
        mAdapter.removeItem();
        Snackbar snackbar = Snackbar.make(viewHolder.itemView, "Удалено: " , Snackbar.LENGTH_SHORT);
        snackbar.setAction("Отмена", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAdapter.returnItem(viewHolder.getAdapterPosition());
            }
        });
        snackbar.show();
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

}
