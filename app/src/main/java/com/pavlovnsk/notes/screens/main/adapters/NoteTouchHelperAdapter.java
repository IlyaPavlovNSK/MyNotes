package com.pavlovnsk.notes.screens.main.adapters;

public interface NoteTouchHelperAdapter {
    void onItemMove(int fromPosition, int toPosition);
    void onItemDismissLeft(int position);
    void onItemDismissRight(int position);
    void returnItem(int position);
    void removeItem();
}
