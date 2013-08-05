package com.example.tracker;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ViewEntryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_entry);

		// get manager
		TrackerApplication app = (TrackerApplication) getApplication();
		TrackerManager manager = app.getManager();

		// get entry to view
		LogEntry entry = manager.getEntryForViewing();

		// set title
		TextView title = (TextView) this.findViewById(R.id.title);
		title.setText(entry.getDate().toString());

		// set note
		TextView note = (TextView) this.findViewById(R.id.note);
		note.setText(entry.getNote());

		// display the tracked metrics
		ArrayList<TrackingMetric> metrics = entry.getMetrics();
		LinearLayout metricList = (LinearLayout) findViewById(R.id.metricList);
		for (int i = 0; i < metrics.size(); i++) {
			// get this metric's view
			View view = metrics.get(i).getReadView(this);

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
		getMenuInflater().inflate(R.menu.view_entry, menu);
		return true;
	}

	/*
	 * Return to the log list
	 */
	public void back(View view) {
		Intent intent = new Intent(this, ViewLogActivity.class);
		this.startActivity(intent);
	}

}
