package org.optaplanner.examples.driverallot;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class DriverTestCase {

	public static final Driver[][] GLOBALDRIVERLIST = {
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(5000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			}
	};

	public static final RouteTrip[][] GLOBALROUTETRIPLIST = {
			{
				new RouteTrip(950, 1100),
				new RouteTrip(730, 830),
				new RouteTrip(1100, 1200),
				new RouteTrip(815, 1200),
			},
			{
				new RouteTrip(950, 1100),
				new RouteTrip(730, 830),
				new RouteTrip(1100, 1200)
			},
			{
				new RouteTrip(950, 1100),
				new RouteTrip(730, 830),
				new RouteTrip(1100, 1200),
				new RouteTrip(1200, 1500)
			},
			{
				new RouteTrip(950, 1100),
				new RouteTrip(730, 830),
				new RouteTrip(1100, 1200),
				new RouteTrip(1130, 1500)
			},
			{
				new RouteTrip(950, 1100, 2),
				new RouteTrip(730, 830, 2),
				new RouteTrip(1100, 1200, 2),
				new RouteTrip(815, 1200, 1),
			},
			{
				new RouteTrip(950, 1100, 2),
				new RouteTrip(730, 830, 1),
				new RouteTrip(1100, 1200, 2),
				new RouteTrip(815, 1200, 2),
			}
	};

	public static final Pair[][][] GLOBALRESULTLIST = {
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 0)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 1)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 2)
				},
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 2),
					new Pair(3, 1)
				}
			},
			{
				{
					new Pair(0, 2),
					new Pair(1, 0),
					new Pair(2, 2),
					new Pair(3, 1)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 1),
					new Pair(3, 0)
				}
			}
	};
}
