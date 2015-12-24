package org.optaplanner.examples.driverallot.domain;

import org.joda.time.Interval;

public class TimeSlot {
	public final static int MORNINGPEAK = 0;
	public final static int AFTERNOON = 1;
	public final static int EVENINGPEAK = 2;
	
	private final static Interval MORNINGPEAKINTERVAL = new Interval(0000, 1059);
	private final static Interval AFTERNOONINTERVAL = new Interval(1100, 1600);
	private final static Interval EVENINGPEAKINTERVAL = new Interval(1600, 2359);
	
	int percentOccupancy;
	Interval interval;
	int type;
	
	TimeSlot(int timeStart, int timeEnd) {
		this.interval = new Interval(timeStart, timeEnd);
		if(interval.overlaps(TimeSlot.MORNINGPEAKINTERVAL)) {
			this.type = TimeSlot.MORNINGPEAK;
			this.percentOccupancy = 70;
		}
		if(interval.overlaps(TimeSlot.AFTERNOONINTERVAL)) {
			this.type = TimeSlot.AFTERNOON;
			this.percentOccupancy = 20;
		}
		if(interval.overlaps(TimeSlot.EVENINGPEAKINTERVAL)) {
			this.type = TimeSlot.EVENINGPEAK;
			this.percentOccupancy = 70;
		}
	}

	public int getPercentOccupancy() {
		return percentOccupancy;
	}

	public void setPercentOccupancy(int percentOccupancy) {
		this.percentOccupancy = percentOccupancy;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
