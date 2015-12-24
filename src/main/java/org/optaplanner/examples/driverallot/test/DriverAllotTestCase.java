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
	
	static TestCase testCase5 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(950, 1100, 2),
					new RouteTrip(730, 830, 2),
					new RouteTrip(1100, 1200, 2),
					new RouteTrip(815, 1200, 1)
			},
			new Pair[][]{
				{
					new Pair(0, 2),
					new Pair(1, 0),
					new Pair(2, 2),
					new Pair(3, 1)
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
	
	static TestCase testCase6 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, Driver.NON_FIXED_DRIVER)	
			},
			new RouteTrip[]{
					new RouteTrip(950, 1100, 2),
					new RouteTrip(730, 830, 1),
					new RouteTrip(1100, 1200, 2),
					new RouteTrip(815, 1200, 2)	
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 0)
				},
				{
					new Pair(0, 2),
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
	
	static TestCase testCase7 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, 12, 13, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, 13, 14, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(730, 830, 1, 14.0, 15.0),
					new RouteTrip(950, 1100, 2, 12.0, 14.0),
					new RouteTrip(1100, 1200, 2, 15.0, 13.0),
					new RouteTrip(815, 1200, 2, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 0),
					new Pair(1, 1),
					new Pair(2, 2),
					new Pair(3, 0)
				}
			},
			0,
			-1132245
			);
	
	static TestCase testCase8 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, 12, 13, Driver.NON_FIXED_DRIVER),
					new Driver(2, 900, 1300, 13, 14, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(730, 830, 1, 14.0, 15.0, 14.0, 15.0),
					new RouteTrip(950, 1100, 2, 12.0, 14.0, 12.0, 14.0),
					new RouteTrip(1100, 1200, 2, 15.0, 13.0, 15.0, 13.0),
					new RouteTrip(815, 1200, 2, 14.0, 15.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 0),
					new Pair(1, 1),
					new Pair(2, 2),
					new Pair(3, 0)
				}
			},
			0,
			-1020706
			);
	
	static TestCase testCase9 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, 12, 13, Driver.NON_FIXED_DRIVER),
					new Driver(2, 810, 1300, 13, 14, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(730, 830, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(950, 1100, 2, 12.0, 14.0, 15.0, 13.0),
					new RouteTrip(1100, 1200, 2, 15.0, 13.0, 15.0, 13.0),
					new RouteTrip(815, 1200, 2, 14.0, 15.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 2)
				}
			},
			0,
			-28328
			);
	
	static TestCase testCase10 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 700, 1500, 14, 15, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(730, 810, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(950, 1100, 2, 12.0, 14.0, 15.0, 13.0),
					new RouteTrip(815, 1100, 2, 12.0, 14.0, 15.0, 13.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 1)
				},
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 0)
				}
			},
			0,
			-506323
		);
	
	static TestCase testCase11 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 630, 1500, 14.0, 15.0, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(700, 1000, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(800, 1100, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(900, 1200, 1, 12.0, 14.0, 14.0, 15.0),
					new RouteTrip(1030, 1400, 1, 12.0, 14.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 0),
					new Pair(3, 1)
				}
			},
			0,
			-999727
		);
	
	static TestCase testCase12 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 630, 1500, 14.0, 15.0, Driver.NON_FIXED_DRIVER),
					new Driver(1, 630, 1500, 8.0, 9.0, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(700, 1000, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(800, 1100, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(900, 1200, 1, 12.0, 13.0, 14.0, 15.0),
					new RouteTrip(1030, 1400, 1, 12.0, 14.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 2),
					new Pair(3, 1)
				}
			},
			0,
			-546347
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
			testCase5,
			testCase6,
			testCase7,
			testCase8,
			testCase9,
			testCase10,
			testCase11,
			testCase12,
			testCase18,
			testCase19,
			testCase20
	};
}
