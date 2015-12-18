/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.optaplanner.examples.driverallot.persistence;

import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.optaplanner.examples.common.app.LoggingMain;
import org.optaplanner.examples.common.persistence.AbstractSolutionImporter;
import org.optaplanner.examples.common.persistence.SolutionDao;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.DriverAllot;
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.driverallot.test.DriverTestCase;

public class DriverAllotGenerator extends LoggingMain {

    private static class Price {

        private int hardwareValue;
        private String description;
        private int cost;

        private Price(int hardwareValue, String description, int cost) {
            this.hardwareValue = hardwareValue;
            this.description = description;
            this.cost = cost;
        }

        public int getHardwareValue() {
            return hardwareValue;
        }

        public String getDescription() {
            return description;
        }

        public int getCost() {
            return cost;
        }
    }

    private static final Price[] CPU_POWER_PRICES = { // in gigahertz
            new Price(3, "single core 3ghz", 110),
            new Price(4, "dual core 2ghz", 140),
            new Price(6, "dual core 3ghz", 180),
            new Price(8, "quad core 2ghz", 270),
            new Price(12, "quad core 3ghz", 400),
            new Price(16, "quad core 4ghz", 1000),
            new Price(24, "eight core 3ghz", 3000),
    };
    private static final Price[] MEMORY_PRICES = { // in gigabyte RAM
            new Price(2, "2 gigabyte", 140),
            new Price(4, "4 gigabyte", 180),
            new Price(8, "8 gigabyte", 220),
            new Price(16, "16 gigabyte", 300),
            new Price(32, "32 gigabyte", 400),
            new Price(64, "64 gigabyte", 600),
            new Price(96, "96 gigabyte", 1000),
    };
    private static final Price[] NETWORK_BANDWIDTH_PRICES = { // in gigabyte per hour
            new Price(2, "2 gigabyte", 100),
            new Price(4, "4 gigabyte", 200),
            new Price(6, "6 gigabyte", 300),
            new Price(8, "8 gigabyte", 400),
            new Price(12, "12 gigabyte", 600),
            new Price(16, "16 gigabyte", 800),
            new Price(20, "20 gigabyte", 1000),
    };
    
    private static final Driver[] DRIVER_LIST = {
    		new Driver(1, 700, 1500),
    		new Driver(2, 900, 1300),
    		new Driver(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 5000, 0, 2400)
    };
    
    private static final RouteTrip[] ROUTETRIP_LIST = {
    		new RouteTrip(950, 1100),
    		new RouteTrip(730, 830),
    		new RouteTrip(1100, 1200),
    		new RouteTrip(815, 1200),
    		new RouteTrip(0, 0),
    		new RouteTrip(0, 0)
    };

    private static final int MAXIMUM_REQUIRED_CPU_POWER = 12; // in gigahertz
    private static final int MAXIMUM_REQUIRED_MEMORY = 32; // in gigabyte RAM
    private static final int MAXIMUM_REQUIRED_NETWORK_BANDWIDTH = 12; // in gigabyte per hour

    public static void main(String[] args) {
        new DriverAllotGenerator().generate();
    }

    protected final SolutionDao solutionDao;
    protected final File outputDir;
    protected Random random;

    public DriverAllotGenerator() {
        checkConfiguration();
        solutionDao = new DriverAllotDao();
        outputDir = new File(solutionDao.getDataDir(), "unsolved");
    }

    public DriverAllotGenerator(boolean withoutDao) {
        if (!withoutDao) {
            throw new IllegalArgumentException("The parameter withoutDao (" + withoutDao + ") must be true.");
        }
        checkConfiguration();
        solutionDao = null;
        outputDir = null;
    }

    public void generate() {
        writeDriverAllot(2, 6);
        writeDriverAllot(3, 9);
        writeDriverAllot(4, 12);
//        writeCloudBalance(5, 15);
//        writeCloudBalance(6, 18);
//        writeCloudBalance(7, 21);
//        writeCloudBalance(8, 24);
//        writeCloudBalance(9, 27);
//        writeCloudBalance(10, 30);
//        writeCloudBalance(11, 33);
//        writeCloudBalance(12, 36);
//        writeCloudBalance(13, 39);
//        writeCloudBalance(14, 42);
//        writeCloudBalance(15, 45);
//        writeCloudBalance(16, 48);
//        writeCloudBalance(17, 51);
//        writeCloudBalance(18, 54);
//        writeCloudBalance(19, 57);
//        writeCloudBalance(20, 60);
        writeDriverAllot(100, 300);
        writeDriverAllot(200, 600);
        writeDriverAllot(400, 1200);
        writeDriverAllot(800, 2400);
        writeDriverAllot(1600, 4800);
    }

    private void checkConfiguration() {
        if (CPU_POWER_PRICES.length != MEMORY_PRICES.length || CPU_POWER_PRICES.length != NETWORK_BANDWIDTH_PRICES.length) {
            throw new IllegalStateException("All price arrays must be equal in length.");
        }
    }

    private void writeDriverAllot(int driverListSize, int routeTripListSize) {
        String inputId = determineInputId(driverListSize, routeTripListSize);
        File outputFile = new File(outputDir, inputId + ".xml");
        DriverAllot driverAllot = createDriverAllot(inputId, driverListSize, routeTripListSize);
        solutionDao.writeSolution(driverAllot, outputFile);
    }

    private String determineInputId(int driverListSize, int routeTripListSize) {
        return driverListSize + " drivers-" + routeTripListSize + " routeTripes";
    }

    public DriverAllot createDriverAllot(int driverListSize, int routeTripListSize) {
        return createDriverAllot(determineInputId(driverListSize, routeTripListSize),
                driverListSize, routeTripListSize);
    }

    public DriverAllot createDriverAllot(String inputId, int driverListSize, int routeTripListSize) {
        random = new Random(System.currentTimeMillis());
        DriverAllot driverAllot = new DriverAllot();
        driverAllot.setId(0L);
        createRouteTripList(driverAllot, routeTripListSize);
        createDriverList(driverAllot, driverListSize);
        //assureDriverCapacityTotalAtLeastRouteTripRequiredTotal(driverAllot);
        BigInteger possibleSolutionSize = BigInteger.valueOf(driverAllot.getDriverList().size()).pow(
                driverAllot.getRouteTripList().size());
        logger.info("DriverAllot {} has {} drivers and {} routeTripes with a search space of {}.",
                inputId, driverListSize, routeTripListSize,
                AbstractSolutionImporter.getFlooredPossibleSolutionSize(possibleSolutionSize));
        return driverAllot;
    }

    private void createDriverList(DriverAllot driverAllot, int driverListSize) {
        List<Driver> driverList = new ArrayList<Driver>(driverListSize);
        for (int i = 0; i < driverListSize; i++) {
        	driverList.add(DRIVER_LIST[i]);
        	driverList.get(i).setId((long)i);
        }
        driverAllot.setDriverList(driverList);
    }

    private int distortIndex(int referenceIndex, int length) {
        int index = referenceIndex;
        double randomDouble = random.nextDouble();
        double loweringThreshold = 0.25;
        while (randomDouble < loweringThreshold && index >= 1) {
            index--;
            loweringThreshold *= 0.10;
        }
        double heighteningThreshold = 0.75;
        while (randomDouble >= heighteningThreshold && index <= (length - 2)) {
            index++;
            heighteningThreshold = (1.0 - ((1.0 - heighteningThreshold) * 0.10));
        }
        return index;
    }

    private void createRouteTripList(DriverAllot driverAllot, int routeTripListSize) {
        List<RouteTrip> routeTripList = new ArrayList<RouteTrip>(routeTripListSize);
        for (int i = 0; i < routeTripListSize; i++) {
        	routeTripList.add(ROUTETRIP_LIST[i]);
        	routeTripList.get(i).setId((long)i);
        }
        driverAllot.setRouteTripList(routeTripList);
    }

    private int generateRandom(int maximumValue) {
        double randomDouble = random.nextDouble();
        double parabolaBase = 2000.0;
        double parabolaRandomDouble = (Math.pow(parabolaBase, randomDouble) - 1.0) / (parabolaBase - 1.0);
        if (parabolaRandomDouble < 0.0 || parabolaRandomDouble >= 1.0) {
            throw new IllegalArgumentException("Invalid generated parabolaRandomDouble (" + parabolaRandomDouble + ")");
        }
        int value = ((int) Math.floor(parabolaRandomDouble * ((double) maximumValue))) + 1;
        if (value < 1 || value > maximumValue) {
            throw new IllegalArgumentException("Invalid generated value (" + value + ")");
        }
        return value;
    }

    private void assureDriverCapacityTotalAtLeastRouteTripRequiredTotal(DriverAllot driverAllot) {
        List<Driver> driverList = driverAllot.getDriverList();
        int cpuPowerTotal = 0;
        int memoryTotal = 0;
        int networkBandwidthTotal = 0;
        for (Driver driver : driverList) {
        	if(driver != null) {
        	}
        	else {
        		cpuPowerTotal += 0;
                memoryTotal += 0;
                networkBandwidthTotal += 0;
        	}
        }
        int requiredCpuPowerTotal = 0;
        int requiredMemoryTotal = 0;
        int requiredNetworkBandwidthTotal = 0;
      
        int cpuPowerLacking = requiredCpuPowerTotal - cpuPowerTotal;
        while (cpuPowerLacking > 0) {
            Driver driver = driverList.get(random.nextInt(driverList.size()));
            int upgrade = determineUpgrade(cpuPowerLacking);
            cpuPowerLacking -= upgrade;
        }
        int memoryLacking = requiredMemoryTotal - memoryTotal;
        while (memoryLacking > 0) {
            Driver driver = driverList.get(random.nextInt(driverList.size()));
            int upgrade = determineUpgrade(memoryLacking);
            memoryLacking -= upgrade;
        }
        int networkBandwidthLacking = requiredNetworkBandwidthTotal - networkBandwidthTotal;
        while (networkBandwidthLacking > 0) {
            Driver driver = driverList.get(random.nextInt(driverList.size()));
            int upgrade = determineUpgrade(networkBandwidthLacking);
            networkBandwidthLacking -= upgrade;
        }
    }

    private int determineUpgrade(int lacking) {
        for (int upgrade : new int[] {8, 4, 2, 1}) {
            if (lacking >= upgrade) {
                return upgrade;
            }
        }
        throw new IllegalStateException("Lacking (" + lacking + ") should be at least 1.");
    }

	public DriverAllot createDriverAllot(int i) {
		DriverAllot driverAllot = new DriverAllot();
        driverAllot.setId((long)i);
        
        createRouteTripListGlobal(driverAllot, DriverTestCase.GLOBALROUTETRIPLIST[i]);
        createDriverListGlobal(driverAllot, DriverTestCase.GLOBALDRIVERLIST[i]);
        /*BigInteger possibleSolutionSize = BigInteger.valueOf(driverAllot.getDriverList().size()).pow(
                driverAllot.getRouteTripList().size());*/
        return driverAllot;
	}
	
	private void createRouteTripListGlobal(DriverAllot driverAllot, RouteTrip[] globalRoutetripListI) {
        List<RouteTrip> routeTripList = new ArrayList<RouteTrip>(globalRoutetripListI.length);
        for (int i = 0; i < globalRoutetripListI.length; i++) {
        	routeTripList.add(globalRoutetripListI[i]);
        	routeTripList.get(i).setId((long)i);
        }
        driverAllot.setRouteTripList(routeTripList);
    }
	
	private void createDriverListGlobal(DriverAllot driverAllot, Driver[] globalDriverListI) {
        List<Driver> driverList = new ArrayList<Driver>(globalDriverListI.length);
        for (int i = 0; i < globalDriverListI.length; i++) {
        	driverList.add(globalDriverListI[i]);
        	driverList.get(i).setId((long)i);
        }
        driverAllot.setDriverList(driverList);
    }

}
