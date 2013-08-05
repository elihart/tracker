package com.example.tracker;

import android.content.Context;
import android.database.Cursor;

import com.example.tracker.data.DbHelper;
import com.example.tracker.data.TrackerDatabase;

public class TrackerManager {
	private DbHelper mDbHelper;
	private LogEntry mCurrentEntry;
	
	// save an entry to be viewed 
	private LogEntry mEntryToView;
	
	public TrackerManager(Context context){
		mDbHelper = new DbHelper(context);
	}

	public void saveEntry(LogEntry entry) {
		mDbHelper.addEntry(entry);		
	}

	public Cursor getLogs() {
		return mDbHelper.getLogs();
	}

	public LogEntry getEntryFromId(int id) {
		return mDbHelper.getEntryFromId(id);
	}

	public void setEntryForViewing(LogEntry entry) {
		mEntryToView = entry;
		
	}

	public LogEntry getEntryForViewing() {
		return mEntryToView;
	}

}
