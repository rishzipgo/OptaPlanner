package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Cab;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class DriverAllotTestCase {
	static TestCase testCase1 = new TestCase(
			new Driver[]{
				new Driver(0, 2359, 0.0, 0.0, "Universal Driver", Driver.UNIVERSAL_DRIVER, 0, 0, 0, Cab.UNIVERSAL),
				new Driver(700, 1500, 12.914015, 77.63813, "Driver 1", Driver.NON_FIXED_DRIVER, 120, 30, 3500, Cab.TT)
			},
			new RouteTrip[]{
				new RouteTrip(1115, 1215, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 2", 13.3),
				new RouteTrip(930, 1030, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 1", 13.3)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1)
				}
			}
		);
	
	static TestCase testCase2 = new TestCase(
			new Driver[]{
				new Driver(0, 2359, 0.0, 0.0, "Universal Driver", Driver.UNIVERSAL_DRIVER, 0, 0, 0, Cab.UNIVERSAL),
				new Driver(700, 1500, 12.914015, 77.63813, "Driver 1", Driver.NON_FIXED_DRIVER, 120, 30, 3500, Cab.TT),
				new Driver(700, 1500, 12.914015, 77.63813, "Driver 2", Driver.NON_FIXED_DRIVER, 120, 30, 3500, Cab.INNOVA)
			},
			new RouteTrip[]{
				new RouteTrip(1115, 1215, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 2", 13.3),
				new RouteTrip(930, 1030, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 1", 13.3)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1)
				}
			}
		);
	
	static TestCase testCase3 = new TestCase(
			new Driver[]{
				new Driver(0, 2359, 0.0, 0.0, "Universal Driver", Driver.UNIVERSAL_DRIVER, 0, 0, 0, Cab.UNIVERSAL),
				new Driver(700, 1500, 12.914015, 77.63813, "Driver 1", Driver.FIXED_DRIVER, 40, 30, 1200, Cab.TT),
				new Driver(700, 1500, 12.914015, 77.63813, "Driver 2", Driver.NON_FIXED_DRIVER, 120, 30, 3500, Cab.TT)
			},
			new RouteTrip[]{
				new RouteTrip(1115, 1215, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 2", 13.3),
				new RouteTrip(930, 1030, 12.914015, 77.63813, 12.980984, 77.657103, "Trip 1", 13.3)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1)
				}
			}
		);


	public static TestCase[] testCaseList = {
			testCase1,
			testCase2,
			testCase3
	};
}
