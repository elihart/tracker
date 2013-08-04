package com.example.tracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewLogActivity extends Activity {
	private Context mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_log);
		
		// set up manager
		TrackerApplication app = (TrackerApplication)getApplication();
		final TrackerManager manager = app.getManager();
		
		mContext = this;
		
		ListView list = (ListView) findViewById(R.id.logList);
		
		
		// set Cursor with database results
		Cursor c = manager.getLogs();
		System.out.println(c.toString());
		
		LogCursorAdapter adapter = new LogCursorAdapter(this, c, false);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int arg2,
					long arg3) {
				// create a LogEntry object based on this database entry
				int entryId = (Integer) view.getTag();
				LogEntry entry = manager.getEntryFromId(entryId);
				manager.setEntryForViewing(entry);
				
				Intent intent = new Intent(mContext, ViewEntryActivity.class);
				mContext.startActivity(intent);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view_log, menu);
		return true;
	}

}
