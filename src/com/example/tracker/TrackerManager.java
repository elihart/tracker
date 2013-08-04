package com.example.tracker;

import android.content.Context;

import com.example.tracker.data.DbHelper;
import com.example.tracker.data.TrackerDatabase;

public class TrackerManager {
	private DbHelper mDbHelper;
	private LogEntry mCurrentEntry;
	
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

}
