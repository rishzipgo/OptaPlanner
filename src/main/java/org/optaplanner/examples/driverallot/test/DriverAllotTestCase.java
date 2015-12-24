package org.optaplanner.examples.driverallot.test;

import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.examples.driverallot.domain.Cab;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class DriverAllotTestCase {
	static TestCase testCase1 = new TestCase(
				new Driver[]{
						new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
						new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
						new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)
				},
				new RouteTrip[]{
						new RouteTrip(950, 1100),
						new RouteTrip(730, 830),
						new RouteTrip(1100, 1200),
						new RouteTrip(815, 1200)
				},
				new Pair[][] {
					{
						new Pair(0, 1),
						new Pair(1, 1),
						new Pair(2, 1),
						new Pair(3, 0)
					},
					{
						new Pair(0, 2),
						new Pair(1, 1),
						new Pair(2, 2),
						new Pair(3, 0)
					}
				},
				0,
				-498848
			);
	
	static TestCase testCase2 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(950, 1100),
					new RouteTrip(730, 830),
					new RouteTrip(1100, 1200)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1)
				},
				{
					new Pair(0, 2),
					new Pair(1, 1),
					new Pair(2, 2)
				}
			},
			0,
			1152
			);
	
	static TestCase testCase3 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(950, 1100),
					new RouteTrip(730, 830),
					new RouteTrip(1100, 1200),
					new RouteTrip(1200, 1500)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 1)
				}
			},
			0,
			297
			);
	
	static TestCase testCase4 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(950, 1100, 1),
					new RouteTrip(730, 830, 1),
					new RouteTrip(1101, 1200, 1),
					new RouteTrip(1130, 1500, 1)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 2),
					new Pair(3, 1)
				}
			},
			0,
			-78
			);
	
	static TestCase testCase18 = new TestCase(
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
			},
			0,
			-9965
		);
	
	static TestCase testCase19 = new TestCase(
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
			},
			0,
			-9965
		);
	
	static TestCase testCase20 = new TestCase(
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
			},
			0,
			-2965
		);


	public static TestCase[] testCaseList = {
			testCase1,
			testCase2,
			testCase3,
			testCase4,
			testCase18,
			testCase19,
			testCase20
	};
}
