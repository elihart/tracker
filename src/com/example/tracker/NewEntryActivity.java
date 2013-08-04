package com.example.tracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class NewEntryActivity extends Activity {
	private TrackerManager mManager;
	private EditText mNote;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_entry);
		
		// get manager
		mManager = ((TrackerApplication)getApplication()).getManager();
		
		// create a new log entry to populate
		mManager.setCurrentEntry(new LogEntry());
		mNote = (EditText) this.findViewById(R.id.notes);
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
	public void cancel(View v){
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
	}
	
	/*
	 * Save this log entry and return to the main menu
	 */
	public void save(View v){
		// write the note to the entry
		mManager.getCurrentEntry().setNote(mNote.getText().toString());
		// save log in database
		mManager.saveCurrentEntry();
		
		// back to main menu
		Intent intent = new Intent(this, MainActivity.class);
		this.startActivity(intent);
	}

}
