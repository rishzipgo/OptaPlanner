package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class TestCase {
	public Driver[] driverList;
	public RouteTrip[] routeTripList;
	public Pair[][] resultList;
	
	public TestCase(Driver[] driverList, RouteTrip[] routeTripList, Pair[][] resultList) {
		super();
		this.driverList = driverList;
		this.routeTripList = routeTripList;
		this.resultList = resultList;
	}

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

	public Pair[][] getResultList() {
		return resultList;
	}

	public void setResultList(Pair[][] resultList) {
		this.resultList = resultList;
	}

}
