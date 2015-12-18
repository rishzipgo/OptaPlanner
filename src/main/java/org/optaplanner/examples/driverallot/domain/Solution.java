package org.optaplanner.examples.driverallot.domain;

import com.google.gson.annotations.SerializedName;

public class Solution implements Comparable<Solution>{
	@SerializedName("driverTripMap")
	DriverToTrip[] driverTripMap;
		
	public DriverToTrip[] getDriverTripMap() {
		return driverTripMap;
	}

	public void setDriverTripMap(DriverToTrip[] driverTripMap) {
		this.driverTripMap = driverTripMap;
	}
	
	@Override
	public int compareTo(Solution o) {
		if(o != null && o.getDriverTripMap() != null){
			if(o.getDriverTripMap().length != this.driverTripMap.length)
				return 1;
			DriverToTrip curr, oCurr;
			for(int i=0; i<o.getDriverTripMap().length; i++ ){
				curr = this.driverTripMap[i];
				oCurr = o.getDriverTripMap()[i];
				if(oCurr.driverId != curr.driverId)
					return 1;
				if(oCurr.tripId != curr.tripId)
					return 1;
			}
			return 0;
		}
		return 1;
	}
	
	
	///////////////
	private class DriverToTrip{
		@SerializedName("driver")
		private int driverId;
		
		@SerializedName("trip")
		private int tripId;
	}
}
