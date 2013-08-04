package com.example.tracker.data;

import com.example.tracker.LogEntry;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbHelper {
	private TrackerDatabase mTrackerDatabase;
	private SQLiteDatabase mDb;
	
	public DbHelper(Context context){
		mTrackerDatabase = new TrackerDatabase(context);
		mDb = mTrackerDatabase.getWritableDatabase();
	}
	
	/*
	 * Add the LogEntry to the database
	 */
	public void addEntry(LogEntry mCurrentEntry) {
		// create ContentValues for this entry
		ContentValues values = new ContentValues();
		values.put("date", System.currentTimeMillis());
		values.put("note", mCurrentEntry.getNote());
		mDb.insert(TrackerDatabase.TABLE_ENTRIES, null, values);
		
		// insert the metrics associated with this entry
		
		
		// insert pictures associated with this entry
		
	}

	/*
	 * Return a cursor containing all rows in the Entries table, sorted by newest
	 * to oldest
	 */
	public Cursor getLogs() {
		String[] columns = new String[] {"date", "_id"};
		return mDb.query(TrackerDatabase.TABLE_ENTRIES, columns, null, null, null, null, "date DESC");
	}

	public LogEntry getEntryFromId(int id) {
		String selection = "_id = '" + id + "'";
		Cursor c = mDb.query(TrackerDatabase.TABLE_ENTRIES, null, selection, null, null, null, "date DESC");
		
		return new LogEntry(c);
	}

}
