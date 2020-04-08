package com.pavlovnsk.notes.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Note implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "is_Done")
    private boolean isDone;

    @ColumnInfo(name = "dat_of_opening")
    private long dateOfOpening;

    @ColumnInfo(name = "date_of_closure")
    private long dateOfClosure;

    public Note(String title, String description, boolean isDone, long dateOfOpening) {
        this.title = title;
        this.description = description;
        this.isDone = isDone;
        this.dateOfOpening = dateOfOpening;
        //this.dateOfClosure = dateOfClosure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }
    
    public void setDone(boolean done) {
        isDone = done;
    }

    public long getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(long dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public long getDateOfClosure() {
        return dateOfClosure;
    }

    public void setDateOfClosure(long dateOfClosure) {
        this.dateOfClosure = dateOfClosure;
    }
}
