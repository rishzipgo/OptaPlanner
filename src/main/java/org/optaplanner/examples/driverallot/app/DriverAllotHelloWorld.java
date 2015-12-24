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

import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScoreHolder;
import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.api.solver.event.BestSolutionChangedEvent;
import org.optaplanner.core.api.solver.event.SolverEventListener;
import org.optaplanner.core.impl.score.director.ScoreDirector;
import org.optaplanner.examples.curriculumcourse.app.CurriculumCourseApp;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.DriverAllot;
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.driverallot.persistence.DriverAllotGenerator;
import org.optaplanner.examples.driverallot.test.DriverAllotTestCase;
import org.optaplanner.examples.driverallot.test.DriverTestCase;

import javafx.util.Pair;

/**
 * Examination is super optimized and a bit complex.
 * {@link CurriculumCourseApp} is arguably a better example to learn from.
 */
public class DriverAllotHelloWorld {

	public static void main(String[] args) throws FileNotFoundException {
		
		//System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("sysoutfile"))));

		ArrayList<DriverAllot> DriverAllotResults = new ArrayList<>();
		int countCorrect = 0;
		// Build the Solver
		SolverFactory solverFactory = SolverFactory.createFromXmlResource(
				"org/optaplanner/examples/driverallot/solver/driverAllotSolverConfig.xml");
		Solver solver = solverFactory.buildSolver();

		//for(int i =0; i < 17/*DriverTestCase.GLOBALDRIVERLIST.length*/; i++) {
		for(int i =0; i < DriverAllotTestCase.testCaseList.length; i++) {
			DriverAllot unsolvedDriverAllot = new DriverAllotGenerator().createDriverAllot(i, DriverAllotTestCase.testCaseList[i]);

			// Solve the problem
			solver.solve(unsolvedDriverAllot);
			

			/*solver.addEventListener(new SolverEventListener<DriverAllot>() {

			@Override
			public void bestSolutionChanged(BestSolutionChangedEvent<DriverAllot> event) {
				// TODO Auto-generated method stub
				//if (event.isNewBestSolutionInitialized()
	            //        && event.getNewBestSolution().getScore().isFeasible()) {
					System.out.println("We have a feasible solution");
				//}
			}

        	});*/


			DriverAllot solvedDriverAllot = (DriverAllot) solver.getBestSolution();

			DriverAllotResults.add(solvedDriverAllot);
			
			printResults(i, solvedDriverAllot);
		}
		for(int i = 0; i < DriverAllotResults.size(); i++) {
			DriverAllot solvedDriverAllot = DriverAllotResults.get(i);
			boolean wrong = true;
			Pair[][] resultList = DriverAllotTestCase.testCaseList[i].getResultList();
			for(int k = 0; k < resultList.length; k++) {
				Pair[] pairList = resultList[k];
				boolean wrongTestCaseResult = false;
				for(int j = 0; j < solvedDriverAllot.getRouteTripList().size(); j++) {
					RouteTrip routeTrip = solvedDriverAllot.getRouteTripList().get(j);
					Driver driver = routeTrip.getDriver();
					if(driver != null) {
						Integer testRouteTripId = (Integer)pairList[j].getKey();
						Integer testDriverId = (Integer)pairList[j].getValue();
						if(!(routeTrip.getId() == testRouteTripId.longValue() && driver.getId() == testDriverId.longValue())) {
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
		System.out.println("\n" + countCorrect + " test cases out of " + DriverTestCase.GLOBALDRIVERLIST.length + " were correct");
	}

	private static void printResults(int i, DriverAllot solvedDriverAllot) {
		System.out.println("\nTest Case #" + (i+1) + "\nSolved DriverAllot with " + solvedDriverAllot.getDriverList().size() + " drivers and " + solvedDriverAllot.getRouteTripList().size() + " routeTrips:\n"
				+ toDisplayString(solvedDriverAllot));
		
		for(Driver driver : solvedDriverAllot.getDriverList()) {
			System.out.println(driver.tostring());
			System.out.println(driver.getDriverTripList());
			//System.out.println(driver.getRouteTripList());
			//System.out.println(driver.getLabel() + "\t" + driver.getTimeIn() + "\t" + driver.getTimeOut());
		}
		System.out.println();
		for(RouteTrip routeTrip : solvedDriverAllot.getRouteTripList()) {
			System.out.println(routeTrip.tostring());
			System.out.println(routeTrip.getPreviousTrip());
			//System.out.println(routeTrip.getLabel() + "\t" + routeTrip.getTimeStart() + "\t" + routeTrip.getTimeEnd());
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
