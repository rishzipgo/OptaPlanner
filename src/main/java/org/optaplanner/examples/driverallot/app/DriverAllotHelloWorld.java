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

package org.optaplanner.examples.driverallot.app;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.DriverAllot;
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.driverallot.persistence.DriverAllotGenerator;
import org.optaplanner.examples.driverallot.test.DriverAllotTestCase;

import javafx.util.Pair;

/**
 * Examination is super optimized and a bit complex.
 * {@link CurriculumCourseApp} is arguably a better example to learn from.
 */
public class DriverAllotHelloWorld {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("sysoutfile"))));

		ArrayList<DriverAllot> DriverAllotResults = new ArrayList<>();
		int countCorrect = 0;
		int totCount = 0;
		// Build the Solver
		SolverFactory solverFactory = SolverFactory.createFromXmlResource(
				"org/optaplanner/examples/driverallot/solver/driverAllotSolverConfig.xml");
		Solver solver = solverFactory.buildSolver();

		//for(int i =0; i < DriverTestCase.GLOBALDRIVERLIST.length; i++) {
		//String filesPath = "/Users/neerajpaliwal/Desktop/zipgoplanner/demo1/";
		String filesPath = args[0];
		String locationFileName = "latlon.csv";
		String driverFileName = "driver.csv";
		String tripFileName = "trip.csv";
		String outFileName = filesPath +  "/output.csv";

		try{
			DriverAllotTestCase.readInputFiles(	filesPath + "/" + driverFileName, 
												filesPath + "/" + tripFileName, 
												filesPath +  "/" +locationFileName);
			
			DriverAllot unsolvedDriverAllot = new DriverAllotGenerator().createDriverAllot(0, DriverAllotTestCase.testCase);
		
			
			// Solve the problem
			solver.solve(unsolvedDriverAllot);
			
			DriverAllot solvedDriverAllot = (DriverAllot) solver.getBestSolution();

			DriverAllotResults.add(solvedDriverAllot);
			
			
			printResult(solvedDriverAllot, outFileName);
	
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
		/*for(int i =0; i < DriverAllotTestCase.testCaseList.length; i++) {
			//DriverAllot unsolvedDriverAllot = new DriverAllotGenerator().createDriverAllot(i);
			DriverAllot unsolvedDriverAllot = new DriverAllotGenerator().createDriverAllot(i, DriverAllotTestCase.testCaseList[i]);

			// Solve the problem
			solver.solve(unsolvedDriverAllot);
			
			DriverAllot solvedDriverAllot = (DriverAllot) solver.getBestSolution();

			DriverAllotResults.add(solvedDriverAllot);
			
			printResults(i, solvedDriverAllot);
			totCount ++;
		}
		for(int i = 0; i < DriverAllotTestCase.testCaseList.length; i++) {
			DriverAllot solvedDriverAllot = DriverAllotResults.get(i);
			boolean wrong = true;
		
			Pair[][] resultList = DriverAllotTestCase.testCaseList[i].getResultList();
			if(resultList == null)
				continue;
			for(int k = 0; k < resultList.length; k++) {
				Pair[] pairList = resultList[k];
				boolean wrongTestCaseResult = false;
				for(int j = 0; j < solvedDriverAllot.getRouteTripList().size(); j++) {
					RouteTrip routeTrip = solvedDriverAllot.getRouteTripList().get(j);
					Driver driver = routeTrip.getDriver();
					if(driver != null) {
						Integer testRouteTripId = (Integer)pairList[j].getKey();
						Integer testDriverId = (Integer)pairList[j].getValue();
						if(!(routeTrip.getId() == testRouteTripId.longValue() 
								&& driver.getId() == testDriverId.longValue() 
								&& DriverAllotTestCase.testCaseList[i].getHardScore() == solvedDriverAllot.getScore().getHardScore()
								&& DriverAllotTestCase.testCaseList[i].getSoftScore() == solvedDriverAllot.getScore().getSoftScore())
								) {
							System.out.println(DriverAllotTestCase.testCaseList[i].getHardScore() + " " + solvedDriverAllot.getScore().getHardScore());
							System.out.println(DriverAllotTestCase.testCaseList[i].getSoftScore() + " " +  solvedDriverAllot.getScore().getSoftScore());
							wrongTestCaseResult = true;
							break;
						}
					}
				}
				wrong &= wrongTestCaseResult;
			}
			if(wrong) {
				printResults(i, solvedDriverAllot);
			}
			else
				countCorrect ++;
		}
		if(totCount > 0)
			System.out.println("\n" + countCorrect + " test cases out of " + totCount + " were correct");
			*/
	}

	private static void printResults(int i, DriverAllot solvedDriverAllot) {
		System.out.println("\nTest Case #" + (i+1) + "\nSolved DriverAllot with " + solvedDriverAllot.getDriverList().size() + " drivers and " + solvedDriverAllot.getRouteTripList().size() + " routeTrips:\n"
				+ toDisplayString(solvedDriverAllot));
		
		for(Driver driver : solvedDriverAllot.getDriverList()) {
			System.out.println(driver.tostring());
			System.out.println(driver.getDriverTripList());
			System.out.println(driver.getRouteTripList());
			System.out.println(driver.getLabel() + "\t" + driver.getTimeIn() + "\t" + driver.getTimeOut());
		}
		System.out.println();
		for(RouteTrip routeTrip : solvedDriverAllot.getRouteTripList()) {
			System.out.println(routeTrip.tostring());
			System.out.println(routeTrip.getPreviousTrip());
			System.out.println(routeTrip.getLabel() + "\t" + routeTrip.getTimeStart() + "\t" + routeTrip.getTimeEnd());
		}
	}

	private static void printResult(DriverAllot solvedDriverAllot, String outputFile) throws FileNotFoundException {
		int numActualDrivers = solvedDriverAllot.getDriverList().size() - 1;
		StringBuilder displayString = new StringBuilder();
		for (RouteTrip routeTrip : solvedDriverAllot.getRouteTripList()) {
			Driver driver = routeTrip.getDriver();
			if(driver != null && driver.getType() != Driver.UNIVERSAL_DRIVER)
				displayString.append("").append(routeTrip.tostring()).append(",")
				.append(driver == null ? null : driver.tostring()).append("\n");
		}
		System.out.println("\nSolved DriverAllot with " + numActualDrivers + " drivers and " + solvedDriverAllot.getRouteTripList().size() + " routeTrips:\n"
				+ displayString.toString());
		if(outputFile != null){
			System.out.println(displayString.toString());
			System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(outputFile)), true));
			System.out.println(displayString.toString());
		}
	}
	
	public static String toDisplayString(DriverAllot solvedDriverAllot) {
		StringBuilder displayString = new StringBuilder();
		for (RouteTrip routeTrip : solvedDriverAllot.getRouteTripList()) {
			Driver driver = routeTrip.getDriver();
			if(driver != null)
				displayString.append("  ").append(routeTrip.getLabel()).append(" -> ")
				.append(driver == null ? null : driver.getLabel()).append("\n");
		}
		return displayString.toString();
	}

}
