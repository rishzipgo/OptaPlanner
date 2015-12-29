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

package org.optaplanner.examples.driverallot.domain;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.drools.core.time.Interval;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.driverallot.domain.solver.DriverRouteTripDistance;
import org.optaplanner.examples.driverallot.domain.solver.RouteTripConflict;
import org.optaplanner.examples.driverallot.domain.solver.RouteTripDistance;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

@PlanningSolution
@XStreamAlias("DriverAllot")
public class DriverAllot extends AbstractPersistable implements Solution<HardSoftScore> {

	private List<Driver> driverList;

	private List<RouteTrip> routeTripList;

	@XStreamConverter(value = XStreamScoreConverter.class, types = {HardSoftScoreDefinition.class})
	private HardSoftScore score;

	@ValueRangeProvider(id = "driverRange")
	public List<Driver> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<Driver> driverList) {
		this.driverList = driverList;
	}

	@PlanningEntityCollectionProperty
	@ValueRangeProvider(id = "routeTripRange")
	public List<RouteTrip> getRouteTripList() {
		return routeTripList;
	}

	public void setRouteTripList(List<RouteTrip> routeTripList) {
		this.routeTripList = routeTripList;
	}

	public HardSoftScore getScore() {
		return score;
	}

	public void setScore(HardSoftScore score) {
		this.score = score;
	}

	// ************************************************************************
	// Complex methods
	// ************************************************************************

	public Collection<? extends Object> getProblemFacts() {
		List<Object> facts = new ArrayList<Object>();
		facts.addAll(driverList);
		facts.addAll(precalculateRouteTripConflictList());
		try {
			facts.addAll(precalculateRouteTripDistanceList());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		facts.addAll(precalculateDriverRouteTripDistance());
		// Do not add the planning entity's (routeTripList) because that will be done automatically
		return facts;
	}

	private List<DriverRouteTripDistance> precalculateDriverRouteTripDistance() {
		List<DriverRouteTripDistance> driverRouteTripDistanceList = new ArrayList<DriverRouteTripDistance>();
		for (Driver driver : driverList)
			for (RouteTrip routeTrip : routeTripList) {
				driverRouteTripDistanceList.add(new DriverRouteTripDistance(driver, routeTrip));
				System.out.println(driver + " " + routeTrip + " " + driverRouteTripDistanceList.get(driverRouteTripDistanceList.size()-1).getCostToStart() + " " + driverRouteTripDistanceList.get(driverRouteTripDistanceList.size()-1).getCostToEnd());
			}
		return driverRouteTripDistanceList;
	}

	private List<RouteTripDistance> precalculateRouteTripDistanceList() throws ParseException {
		List<RouteTripDistance> routeTripDistanceList = new ArrayList<RouteTripDistance>();
		for (RouteTrip leftRouteTrip : routeTripList) {
			for (RouteTrip rightRouteTrip : routeTripList) {
				if (leftRouteTrip.getId() < rightRouteTrip.getId()) {
					int leftStartTime = leftRouteTrip.getTimeStart();
					int leftEndTime = leftRouteTrip.getTimeEnd();
					int rightStartTime = rightRouteTrip.getTimeStart();
					int rightEndTime = rightRouteTrip.getTimeEnd();
					Interval leftInterval = new Interval(leftStartTime, leftEndTime);
					Interval rightInterval = new Interval(rightStartTime, rightEndTime);
					if(!intersects(leftInterval, rightInterval)) {
						if(leftEndTime <= rightStartTime) {
							routeTripDistanceList.add(new RouteTripDistance(leftRouteTrip, rightRouteTrip));
							System.out.print(leftRouteTrip + " " + rightRouteTrip + " ");
						}
						else {
							routeTripDistanceList.add(new RouteTripDistance(rightRouteTrip, leftRouteTrip));
							System.out.print(rightRouteTrip + " " + leftRouteTrip + " ");
						}
						System.out.println(routeTripDistanceList.get(routeTripDistanceList.size()-1).getCost() + " " + routeTripDistanceList.get(routeTripDistanceList.size()-1).getRouteTripShortRestCostDifference() + " " + routeTripDistanceList.get(routeTripDistanceList.size()-1).getRouteTripLongRestCostDifference());
					}
				}
			}
		}
		return routeTripDistanceList;
	}

	private List<RouteTripConflict> precalculateRouteTripConflictList() {
		List<RouteTripConflict> routeTripConflictList = new ArrayList<RouteTripConflict>();
		for (RouteTrip leftRouteTrip : routeTripList) {
			for (RouteTrip rightRouteTrip : routeTripList) {
				if (leftRouteTrip.getId() < rightRouteTrip.getId()) {
					int leftStartTime = leftRouteTrip.getTimeStart();
					int leftEndTime = leftRouteTrip.getTimeEnd();
					int rightStartTime = rightRouteTrip.getTimeStart();
					int rightEndTime = rightRouteTrip.getTimeEnd();
					Interval leftInterval = new Interval(leftStartTime, leftEndTime);
					Interval rightInterval = new Interval(rightStartTime, rightEndTime);
					if(intersects(leftInterval, rightInterval)) {
						routeTripConflictList.add(new RouteTripConflict(leftRouteTrip, rightRouteTrip));
						System.out.println(leftInterval.getLowerBound() + "-" + leftInterval.getUpperBound() + "\t" + 
								rightInterval.getLowerBound() + "-" + rightInterval.getUpperBound());
					}
				}
			}
		}
		return routeTripConflictList;
	}

	private boolean intersects(Interval leftInterval, Interval rightInterval) {
		if(leftInterval.getLowerBound() < rightInterval.getLowerBound()) {
			if(leftInterval.getUpperBound() > rightInterval.getLowerBound())
				return true;
		}
		else {
			if(rightInterval.getUpperBound() > leftInterval.getLowerBound())
				return true;
		}
		return false;
	}

}
