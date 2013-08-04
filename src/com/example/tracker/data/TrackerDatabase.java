package com.example.tracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class TrackerDatabase extends SQLiteOpenHelper {
	private static final String DEBUG_TAG = "TrackerDatabase";
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "tracker_data";
    
    // Create log entry database
    public static final String TABLE_ENTRIES = "entries";
    private static final String ENTRIES_ID = "_id";
    private static final String COL_DATE = "date";
    private static final String COL_NOTE = "note";
    private static final String CREATE_TABLE_ENTRIES = "create table " + TABLE_ENTRIES
    + " (" + ENTRIES_ID + " integer primary key autoincrement, " + COL_DATE
    + " integer not null, " + COL_NOTE + " text not null);";
    private static final String DB_SCHEMA = CREATE_TABLE_ENTRIES;
	
    // create database for each metric
    
    public TrackerDatabase(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DB_SCHEMA);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENTRIES);
	    onCreate(db);		
	}

}
