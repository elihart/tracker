package com.example.tracker;

import android.app.Application;

public class TrackerApplication extends Application {
	private TrackerManager mManager;
	@Override
	public void onCreate() {
		super.onCreate();

		// init manager
		mManager = new TrackerManager(this.getApplicationContext());
	}
	
	public TrackerManager getManager() {
		return mManager;
	}
}
