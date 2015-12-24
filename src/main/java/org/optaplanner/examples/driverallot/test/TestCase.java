package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class TestCase {
	public Driver[] driverList;
	public RouteTrip[] routeTripList;
	public Pair[][] resultList;
	int hardScore;
	int softScore;
	
	public TestCase(Driver[] driverList, RouteTrip[] routeTripList, Pair[][] resultList) {
		super();
		this.driverList = driverList;
		this.routeTripList = routeTripList;
		this.resultList = resultList;
	}

	public TestCase(Driver[] driverList, RouteTrip[] routeTripList, Pair[][] resultList, int hardScore, int softScore) {
		super();
		this.driverList = driverList;
		this.routeTripList = routeTripList;
		this.resultList = resultList;
		this.hardScore = hardScore;
		this.softScore = softScore;
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

	public int getHardScore() {
		return hardScore;
	}

	public void setHardScore(int hardScore) {
		this.hardScore = hardScore;
	}

	public int getSoftScore() {
		return softScore;
	}

	public void setSoftScore(int softScore) {
		this.softScore = softScore;
	}

}
