package org.optaplanner.examples.driverallot.test;

import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;

import javafx.util.Pair;

public class DriverTestCase {

	public static final Driver[][] GLOBALDRIVERLIST = {
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500),
				new Driver(2, 900, 1300)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500, 12, 13),
				new Driver(2, 900, 1300, 13, 14)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500, 12, 13),
				new Driver(2, 900, 1300, 13, 14)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500, 12, 13),
				new Driver(2, 810, 1300, 13, 14)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 700, 1500, 14, 15)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 630, 1500, 14.0, 15.0)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 630, 1500, 14.0, 15.0),
				new Driver(1, 630, 1500, 8.0, 9.0)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 630, 1000, 14.0, 15.0)
			},
			{
				new Driver(500000, 0, 2400),
				new Driver(1, 630, 1500, 14.0, 15.0)
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
				new RouteTrip(815, 1200, 1)
			},
			{
				new RouteTrip(950, 1100, 2),
				new RouteTrip(730, 830, 1),
				new RouteTrip(1100, 1200, 2),
				new RouteTrip(815, 1200, 2)
			},
			{
				new RouteTrip(730, 830, 1, 14.0, 15.0),
				new RouteTrip(950, 1100, 2, 12.0, 14.0),
				new RouteTrip(1100, 1200, 2, 15.0, 13.0),
				new RouteTrip(815, 1200, 2, 14.0, 15.0)
			},
			{
				new RouteTrip(730, 830, 1, 14.0, 15.0, 14.0, 15.0),
				new RouteTrip(950, 1100, 2, 12.0, 14.0, 12.0, 14.0),
				new RouteTrip(1100, 1200, 2, 15.0, 13.0, 15.0, 13.0),
				new RouteTrip(815, 1200, 2, 14.0, 15.0, 14.0, 15.0)
			},
			{
				new RouteTrip(730, 830, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(950, 1100, 2, 12.0, 14.0, 15.0, 13.0),
				new RouteTrip(1100, 1200, 2, 15.0, 13.0, 15.0, 13.0),
				new RouteTrip(815, 1200, 2, 14.0, 15.0, 14.0, 15.0)
			},
			{
				new RouteTrip(730, 810, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(950, 1100, 2, 12.0, 14.0, 15.0, 13.0),
				new RouteTrip(815, 1100, 2, 12.0, 14.0, 15.0, 13.0)
			},
			{
				new RouteTrip(700, 1000, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(800, 1100, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(900, 1200, 1, 12.0, 14.0, 14.0, 15.0),
				new RouteTrip(1030, 1400, 1, 12.0, 14.0, 14.0, 15.0)
			},
			{
				new RouteTrip(700, 1000, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(800, 1100, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(900, 1200, 1, 12.0, 14.0, 14.0, 15.0),
				new RouteTrip(1030, 1400, 1, 12.0, 14.0, 14.0, 15.0)
			},
			{
				new RouteTrip(700, 800, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(810, 910, 1, 12.0, 14.0, 14.0, 15.0),
				new RouteTrip(900, 1000, 1, 12.0, 14.0, 17.0, 18.0),
				new RouteTrip(1030, 1400, 1, 17.0, 18.0, 14.0, 15.0)
			},
			{
				new RouteTrip(700, 800, 1, 14.0, 15.0, 12.0, 14.0),
				new RouteTrip(810, 910, 1, 12.0, 14.0, 14.0, 15.0),
				new RouteTrip(900, 1000, 1, 12.0, 14.0, 17.0, 18.0),
				new RouteTrip(1030, 1400, 1, 17.0, 18.0, 14.0, 15.0)
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
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 2),
					new Pair(3, 0)
				}
			},
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
					new Pair(2, 1),
					new Pair(3, 2)
				}
			},
			{
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
			{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 0),
					new Pair(3, 1)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 2),
					new Pair(3, 1)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 1),
					new Pair(2, 0),
					new Pair(3, 0)
				}
			},
			{
				{
					new Pair(0, 1),
					new Pair(1, 0),
					new Pair(2, 1),
					new Pair(3, 1)
				}
			}
	};
}
