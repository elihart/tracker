package com.example.tracker;

import android.content.Context;

import com.example.tracker.data.TrackerDatabase;

public class TrackerManager {
	private TrackerDatabase mDB;
	
	public TrackerManager(Context context){
		mDB = new TrackerDatabase(context);
	}

}
