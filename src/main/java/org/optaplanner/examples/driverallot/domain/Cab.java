package org.optaplanner.examples.driverallot.domain;

public class Cab {
	public final static int UNIVERSAL = 0;
	public final static int TT = 1;
	public final static int INNOVA = 2;
	
	
	int type;
	int seats;
	
	public Cab(int type) {
		super();
		this.type = type;
		allotSeats(type);
	}

	private void allotSeats(int type) {
		if(type == Cab.UNIVERSAL)
			this.seats = 0;
		if(type == Cab.TT)
			this.seats = 12;
		if(type == Cab.INNOVA)
			this.seats = 7;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
		allotSeats(type);
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

}
