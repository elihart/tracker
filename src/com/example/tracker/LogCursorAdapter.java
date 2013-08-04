package com.example.tracker;

import java.util.Date;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class LogCursorAdapter extends CursorAdapter {
	
	public LogCursorAdapter(Context context, Cursor cursor, boolean autoRequery) {
		super(context, cursor, autoRequery);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		// get date from database and convert from millis to readable form
		int dateCol = cursor.getColumnIndex("date");
		long dateInMillis = cursor.getLong(dateCol);
		String date = (new Date(dateInMillis)).toString();
		
		// store the id of the entry with the view
		int idCol = cursor.getColumnIndex("_id");
		int id = cursor.getInt(idCol);
		view.setTag(id);
		
		// set list item to show date in textview
		TextView dateDisplay = (TextView) view.findViewById(R.id.date);
		if (dateDisplay != null) {
			dateDisplay.setText(date);
		}

	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		View v = inflater.inflate(R.layout.log_list_entry, parent, false);
		bindView(v, context, cursor);
		return v;
	}

}
