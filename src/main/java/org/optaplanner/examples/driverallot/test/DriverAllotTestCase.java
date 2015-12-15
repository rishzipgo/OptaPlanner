package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class DriverAllotTestCase {
	static TestCase testCase1 = new TestCase(
			new Driver[]{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			new RouteTrip[]{
				new RouteTrip(950, 1100),
				new RouteTrip(730, 830),
				new RouteTrip(1100, 1200),
				new RouteTrip(815, 1200)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 0)
				}
			}
		);


	public static TestCase[] testCaseList = {
			testCase1
	};
}
