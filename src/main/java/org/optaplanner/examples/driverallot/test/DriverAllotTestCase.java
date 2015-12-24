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
	

	static TestCase testCase21 = new TestCase(
			new Driver[]{

					new Driver(500000, 0, 2400, Driver.UNIVERSAL_DRIVER),
					new Driver(1, 950, 2020, 12.914015, 77.63813, Driver.NON_FIXED_DRIVER),
					new Driver(2, 700, 2120, 12.8420, 77.6631, Driver.NON_FIXED_DRIVER),
					new Driver(3, 700, 2020, 12.9365, 77.5447, Driver.NON_FIXED_DRIVER)

			},
			new RouteTrip[]{
				
				new RouteTrip(1000, 1250, 1, 12.914015, 77.63813, 13.0426, 77.620, "HSR To Manyata"),
				new RouteTrip(1300, 1430, 1, 13.0426, 77.620, 12.9413, 77.62103, "Manyata To Kor"),
				new RouteTrip(1500, 1820, 1, 12.9413, 77.62103, 13.0426, 77.62, "Kor To Manyata"),
				new RouteTrip(1830, 2010, 1, 13.0426, 77.620, 12.914015, 77.63813, "Manyata To HSR"),

				new RouteTrip(710, 820, 1, 12.8420, 77.6631, 12.9365, 77.5447, "Electronic City To Banashankari"),
				new RouteTrip(830, 1050, 1, 12.9365, 77.5447, 13.0426, 77.620, "Banashankari To Manyata "),
				new RouteTrip(1100, 1350, 1, 13.0426, 77.620, 12.9413, 77.62103, "Manyata To Koramangala "),
				new RouteTrip(1400, 1650, 1, 12.9413, 77.62103, 13.0426, 77.620, "Koramangala To Manyata "),
				new RouteTrip(1810, 1950, 1, 13.0426, 77.620, 12.9365, 77.5447, "Manyata To Banashankari"),
				new RouteTrip(2010, 2100, 1, 12.9365, 77.5447, 12.8420, 77.6631, "Banashankari To Electronic City"),

				new RouteTrip(700, 930, 1, 12.9365, 77.5447, 12.987, 77.737, "Banashankari To ITPL"),
				new RouteTrip(940, 1150, 1, 12.987, 77.737, 12.9365, 77.5447, "Itpl To Banashankari"),
				new RouteTrip(1200, 1410, 1, 12.9365, 77.5447, 12.987, 77.737, "Banashankari To ITPL "),
				new RouteTrip(1440, 1600, 1, 12.987, 77.737, 12.96, 77.64, "Itpl To Domlur "),
				new RouteTrip(1610, 1710, 1, 12.96, 77.64, 12.987, 77.737, "Domlur To Itpl "),
				new RouteTrip(1730, 2010, 1, 12.987, 77.737, 12.9365, 77.5447, "Itpl To Banashankari"),
				new RouteTrip(650, 850, 1, 12.9365, 77.5447, 12.987, 77.737, "Banashankari To ITPL"),
				new RouteTrip(900, 1250, 1, 12.987, 77.737, 12.9365, 77.5447, "Itpl To Banashankari")
			},
			new Pair[][]{
				{
				new Pair(0, 1),
				new Pair(1, 1),
				new Pair(2, 1),
				new Pair(3, 1),
				new Pair(4, 2),
				new Pair(5, 2),
				new Pair(6, 2),
				new Pair(7, 2),
				new Pair(8, 2),
				new Pair(9, 2),
				new Pair(10, 3),
				new Pair(11, 3),
				new Pair(12, 3),
				new Pair(13, 3),
				new Pair(14, 3),
				new Pair(15, 3),
				new Pair(16, 0),
				new Pair(17, 0)
			}
			},
			0,
			0
		);
	
	public static TestCase[] testCaseList = {
			//testCase1,
			//testCase2,
			//testCase3,
			//testCase4,
			//testCase18,
			//testCase19,
			testCase20,
			testCase21
	};
}
