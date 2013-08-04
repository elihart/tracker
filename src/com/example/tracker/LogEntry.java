package com.example.tracker;

import java.util.ArrayList;
import java.util.Date;

import android.database.Cursor;
import android.net.Uri;

public class LogEntry {
	private int mId;
	private Date mDate;
	private String mNote;
	private ArrayList<TrackingMetric> mMetrics;
	private ArrayList<Uri> mImagePaths;
	
	public LogEntry() {
		
	}
	
	/*
	 * Create a LogEntry from a cursor that contains one row from the Entries table
	 */
	public LogEntry(Cursor cursor) {
		if(!cursor.moveToFirst()) {
			System.out.println("Error creating LogEntry. Cursor is empty");
		}
		
		int idCol = cursor.getColumnIndex("_id");
		this.mId = cursor.getInt(idCol);
		
		int dateCol = cursor.getColumnIndex("date");
		long dateInMillis = cursor.getLong(dateCol);
		this.mDate = new Date(dateInMillis);
		
		int noteCol = cursor.getColumnIndex("note");
		this.mNote = cursor.getString(noteCol);
		
		// search metric tables for metrics for this id
		
		// search image table 
	}

	public void addMetric(TrackingMetric metric){
		mMetrics.add(metric);
	}	 

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		this.mDate = date;
	}

	public String getNote() {
		return mNote;
	}

	public void setNote(String note) {
		this.mNote = note;
	}

}
