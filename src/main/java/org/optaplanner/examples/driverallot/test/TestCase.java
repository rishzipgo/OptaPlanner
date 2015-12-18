package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.driverallot.domain.Solution;

import com.google.gson.annotations.SerializedName;
import com.sun.xml.internal.ws.developer.Serialization;

import javafx.util.Pair;

public class TestCase {
    @SerializedName("tag")
	public String tag;
    
    @SerializedName("driverList")
	public Driver[] driverList;
    
    @SerializedName("routeTripList")
	public RouteTrip[] routeTripList;
    
    @SerializedName("solutions")
	public Solution[] resultList;
	

	public Driver[] getDriverList() {
		return driverList;
	}

	public void setDriverList(Driver[] driverList) {
		this.driverList = driverList;
	}

	public RouteTrip[] getRouteTripList() {
		return routeTripList;
	}

	public void setRouteTripList(RouteTrip[] routeTripList) {
		this.routeTripList = routeTripList;
	}

}
