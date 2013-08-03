package com.example.tracker;

import java.util.ArrayList;
import java.util.Date;

import android.net.Uri;

public class LogEntry {
	private int id;
	private Date date;
	private String note;
	private ArrayList<TrackingMetric> metrics;
	private ArrayList<Uri> imagePaths;
	
	public LogEntry() {
		
	}
	
	public void addMetric(TrackingMetric metric){
		metrics.add(metric);
	}	 

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
