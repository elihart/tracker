package com.example.tracker;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

public class NewEntryActivity extends Activity {
	private TrackerManager mManager;
	private LogEntry mEntry;
	private EditText mNote;
	private ArrayList<TrackingMetric> mMetrics;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_entry);

		// get manager
		mManager = ((TrackerApplication) getApplication()).getManager();

		// create a fresh log entry
		mEntry = new LogEntry();

		// get the notes textView
		mNote = (EditText) this.findViewById(R.id.notes);

		// display the default metrics
		mMetrics = mEntry.getMetrics();
		LinearLayout metricList = (LinearLayout) findViewById(R.id.metricList);
		for (int i = 0; i < mMetrics.size(); i++) {
			// get this metric's view
			View view = mMetrics.get(i).getListView(this);

			// add layout params
			view.setLayoutParams(new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.MATCH_PARENT,
					LinearLayout.LayoutParams.MATCH_PARENT));
			// add the view to the metric linear layout
			metricList.addView(view);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_entry, menu);
		return true;
	}

	/*
	 * Return to the main menu without saving
	 */
	public void cancel(View v) {
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
	}

	/*
	 * Save this log entry and return to the main menu
	 */
	public void save(View v) {
		// write the note to the entry
		mEntry.setNote(mNote.getText().toString());
		
		// save log in database
		mManager.saveEntry(mEntry);

		// back to main menu
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
	}

}
