package com.parse.starter.model.courses;

import com.parse.starter.R;

public enum Day {
	Monday(0, R.string.monday),
	Tuesday(1, R.string.tuesday),
	Wednesday(2, R.string.wednesday),
	Thursday(3, R.string.thursday),
	Friday(4, R.string.friday);
	
	private final int position;
	private final int stringId;
	
	private Day(int position, int stringId) {
		this.position = position;
		this.stringId = stringId;
	}
	
	public int getPosition() {
		return this.position;
	}
	
	public int getIdOfString() {
		return this.stringId;
	}

	public static Day convertToDay(String str) {
		if(str.equals("MON")) {
			return Day.Monday;
		} else if(str.equals("TUE")) {
			return Day.Tuesday;
		} else if(str.equals("WED")) {
			return Day.Wednesday;
		} else if(str.equals("THU")) {
			return Day.Thursday;
		} else {
			return Day.Friday;
		}
	}
	
	public static Day converToDay(int position) {
		switch (position) {
			case 0:
				return Day.Monday;
			case 1:
				return Day.Tuesday;
			case 2:
				return Day.Wednesday;
			case 3:
				return Day.Thursday;
			case 4:
				return Day.Friday;
		}
		
		return Day.Monday; // Return Monday for error case.
	}
}