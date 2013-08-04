package com.example.tracker;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/*
	 * Launch the NewEntryActivity
	 */
	public void newEntry(View v){
		Intent intent = new Intent(this, NewEntryActivity.class);
		this.startActivity(intent);
	}
	
	/*
	 * Launch the ViewLogActivity
	 */
	public void viewLog(View v){
		Intent intent = new Intent(this, ViewLogActivity.class);
		this.startActivity(intent);
	}

}
