package com.example.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

public interface TrackingMetric {
	
	/**
	 * Create and return a view that displays this metric and allows
	 * it's settings to be adjusted. This will be inserted into a list
	 * of metrics on the NewEntryActivity
	 */
	public View getListView(Context context);

	public void insertInDb(SQLiteDatabase mDb, long entryId);

	/**
	 * Creates a read only view to display the data saved in this metric
	 * @param context
	 * @return A View that can be added to a layout
	 */
	public View getReadView(Context context);

	
}
