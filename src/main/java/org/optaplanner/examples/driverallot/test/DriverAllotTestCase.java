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
						new Pair(0, 2),
						new Pair(1, 1),
						new Pair(2, 2),
						new Pair(3, 0)
					},
					{
						new Pair(0, 2),
						new Pair(1, 0),
						new Pair(2, 2),
						new Pair(3, 1)
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
					new Pair(0, 2),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 1)
				}
			},
			0,
			-391
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
			297
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
			-27781
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
				}
			},
			0,
			-506261
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
			-999179
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
			-545439
		);
	
	static TestCase testCase13 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 630, 1000, 14.0, 15.0, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(700, 800, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(810, 910, 1, 12.0, 14.0, 14.0, 15.0),
					new RouteTrip(900, 1000, 1, 12.0, 14.0, 17.0, 18.0),
					new RouteTrip(1030, 1400, 1, 17.0, 18.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 0),
					new Pair(3, 0)
				}
			},
			0,
			-998992
		);
	
	static TestCase testCase14 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 630, 1500, 14.0, 15.0, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(700, 800, 1, 14.0, 15.0, 12.0, 14.0),
					new RouteTrip(810, 910, 1, 12.0, 14.0, 14.0, 15.0),
					new RouteTrip(900, 1000, 1, 12.0, 14.0, 17.0, 18.0),
					new RouteTrip(1030, 1400, 1, 17.0, 18.0, 14.0, 15.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 1),
					new Pair(3, 1)
				}
			},
			0,
			-499237
		);
	
	static TestCase testCase15 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 630, 1100, 12.0, 13.0, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(745, 945, 1, 13.0, 14.0, 15.0, 14.0),
					new RouteTrip(645, 745, 2, 12.0, 13.0, 13.0, 14.0),
					new RouteTrip(745, 845, 2, 13.0, 14.0, 14.0, 15.0),
					new RouteTrip(845, 945, 2, 14.0, 15.0, 15.0, 14.0),
					new RouteTrip(945, 1045, 2, 15.0, 14.0, 12.0, 13.0)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 0),
					new Pair(3, 0),
					new Pair(4, 1)
				}
			},
			0,
			-998488
		);
	
	static TestCase testCase16 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 800, 2020, 12.914015, 77.63813, Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(800, 950, 1, 12.914015, 77.63813, 12.980984, 77.657103),
					new RouteTrip(950, 1125, 1, 12.980984, 77.657103, 12.86, 77.786),
					new RouteTrip(1130, 1330, 1, 12.86, 77.786, 12.980984, 77.657103),
					new RouteTrip(1330, 1530, 1, 12.980984, 77.657103, 12.916729, 77.608959),
					new RouteTrip(1530, 1830, 1, 12.916729, 77.608959, 12.980984, 77.657103),
					new RouteTrip(1830, 2020, 1, 12.980984, 77.657103, 12.914015, 77.63813)
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 0),
					new Pair(4, 1),
					new Pair(5, 1)
				}
			},
			0,
			-498965
		);
	
	static TestCase testCase17 = new TestCase(
			new Driver[]{
					new Driver(500000, 0, 2400, 0.0, 0.0, "0000GLOBAL", Driver.UNIVERSAL_DRIVER),
					new Driver(1, 800, 2050, 12.914015, 77.63813, "1322Siddesh", Driver.NON_FIXED_DRIVER),
					new Driver(1, 910, 2350, 12.917676, 77.573803, "2291ShivaS", Driver.NON_FIXED_DRIVER)
			},
			new RouteTrip[]{
					new RouteTrip(800, 950, 1, 12.914015, 77.63813, 12.980984, 77.657103, "HSR To Bagmane Tech Park via Koramangala 80 ft Road, EGL, CMH Road"),
					new RouteTrip(950, 1130, 1, 12.980984, 77.657103, 12.86, 77.786, "Bagmane To Sarjapur Via Cmh Road, Egl, Koramangala 80 Ft Road"),
					new RouteTrip(1130, 1330, 1, 12.86, 77.786, 12.980984, 77.657103, "Sarjapur To Bagmane Tech Park via Koramangala 80 ft Road, EGL, CMH Road"),
					new RouteTrip(1400, 1600, 1, 12.980984, 77.657103, 12.916729, 77.608959, "Short Bagmane To BTM Via Koramangala"),
					new RouteTrip(1600, 1900, 1, 12.916729, 77.608959, 12.980984, 77.657103, "Short Btm To Bagmane Via Koramangala"),
					new RouteTrip(1900, 2050, 1, 12.980984, 77.657103, 12.914015, 77.63813, "Bagmane To Hsr Via Cmh Road, Egl, Koramangala 80 Ft Road"),
					
					new RouteTrip(910, 1150, 1, 12.917676, 77.573803, 12.987573, 77.737239, "Banashankari To ITPL via Kumaraswamy Layout, Silk Board, Outer Ring Road, Kundalahalli"),
					new RouteTrip(1150, 1320, 1, 12.987573, 77.737239, 12.957711, 77.641343, "Itpl To Domlur Via Whitefield"),
					new RouteTrip(1320, 1540, 1, 12.957711, 77.641343, 12.987573, 77.737239, "Domlur To Itpl Via Whitefield"),
					new RouteTrip(1610, 1840, 1, 12.987573, 77.737239, 12.917676, 77.573803, "Itpl To Banashankari Via Kundalahalli, Outer Ring Road, Silk Board, Kumaraswamy Layout"),
					new RouteTrip(1840, 2110, 1, 12.917676, 77.573803, 12.987573, 77.737239, "Banashankari To ITPL via Kumaraswamy Layout, Silk Board, Outer Ring Road, Kundalahalli"),
					new RouteTrip(2110, 2350, 1, 12.987573, 77.737239, 12.917676, 77.573803, "Itpl To Banashankari Via Kundalahalli, Outer Ring Road, Silk Board, Kumaraswamy Layout")
			},
			new Pair[][]{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 1),
					new Pair(4, 1),
					new Pair(5, 1),
					new Pair(6, 2),
					new Pair(7, 2),
					new Pair(8, 2),
					new Pair(9, 2),
					new Pair(10, 2),
					new Pair(11, 2)
				}
			},
			0,
			4608
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
			-6277
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
			-6277
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
			-1577
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
			testCase13,
			testCase14,
			testCase15,
			testCase16,
			testCase17,
			testCase18,
			testCase19,
			testCase20
	};
}
