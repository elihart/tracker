package com.example.tracker;

import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ViewLogActivity extends Activity {
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_log);
		
		ListView list = (ListView) findViewById(R.id.logList);
		TrackerApplication app = (TrackerApplication)getApplication();
		TrackerManager manager = app.getManager();
		
		// set Cursor with database results
		Cursor c = manager.getLogs();
		System.out.println(c.toString());
		
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.log_list_entry, c, new String[]{"date"}, new int[]{R.id.date}, 0);
		
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
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
