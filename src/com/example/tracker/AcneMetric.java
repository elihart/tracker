package com.example.tracker;

import java.util.Date;

import com.example.tracker.data.DbHelper;
import com.example.tracker.data.TrackerDatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AcneMetric implements TrackingMetric {
	private int LAYOUT = R.layout.metric_list_acne;
	private int READ_ONLY_LAYOUT = R.layout.metric_acne_display;
	private EditText mNumberEntry;
	private int mNumber;

	public AcneMetric(int number) {
		mNumber = number;
	}
	
	public AcneMetric(){
		
	}

	public View getListView(Context context) {
		// get the layout inflater
		LayoutInflater inflater = LayoutInflater.from(context);

		// Create the view from our xml file using the inflater
		View view = inflater.inflate(LAYOUT, null);

		// save the input field for later
		mNumberEntry = (EditText) view.findViewById(R.id.number);

		return view;
	}

	public View getReadView(Context context) {
		// get the layout inflater
		LayoutInflater inflater = LayoutInflater.from(context);

		// Create the view from our xml file using the inflater
		View view = inflater.inflate(READ_ONLY_LAYOUT, null);

		// load the number of pimples
		TextView text = (TextView) view.findViewById(R.id.number);
		text.setText(mNumber + "");

		return view;
	}

	public void insertInDb(SQLiteDatabase mDb, long entryId) {
		// create ContentValues for this entry
		ContentValues values = new ContentValues();
		mNumber = Integer.parseInt(mNumberEntry.getText().toString());
		values.put(COL_NUM_PIMPLES, mNumber);
		values.put(COL_ENTRY_ID, entryId);
		long result = mDb.insert(TABLE_NAME, null, values);

		if (result == -1) {
			Log.e(TAG_NAME, "Error inserting into DB");
		}

	}
	
	/**
	 * Given an entry Id, returns the associated metric from the database.
	 * If one does not exist, null is returned.
	 * 
	 */
	public static AcneMetric loadFromDb(DbHelper db, int id){
		String where =  COL_ENTRY_ID +" = '"+ id+"'";
		Cursor c = db.doQuery(TABLE_NAME, where, null);
		
		if(!c.moveToFirst()) {
			return null;
		}
		
		int numCol = c.getColumnIndex(COL_NUM_PIMPLES);
		int num = c.getInt(numCol);
		
		return new AcneMetric(num);		
	}

	/****** Database Info *************/
	public static final String TAG_NAME = "AcneMetric";
	public static final String TABLE_NAME = "acne_metric";
	private static final String COL_ID = "_id";
	private static final String COL_NUM_PIMPLES = "number";
	private static final String COL_ENTRY_ID = "entry_id";
	public static final String CREATE_TABLE = "create table " + TABLE_NAME
			+ " (" + COL_ID + " integer primary key autoincrement, "
			+ COL_NUM_PIMPLES + " integer not null, " + COL_ENTRY_ID
			+ " integer not null);";

	
}
