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

	public void saveCurrentEntry() {
		mDbHelper.addEntry(mCurrentEntry);		
	}
	
	public LogEntry getCurrentEntry(){
		return mCurrentEntry;
	}

	public void setCurrentEntry(LogEntry entry) {
		mCurrentEntry = entry;		
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
