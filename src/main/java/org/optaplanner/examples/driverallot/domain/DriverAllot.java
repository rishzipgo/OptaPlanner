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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

import org.drools.core.time.Interval;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.impl.score.buildin.hardsoft.HardSoftScoreDefinition;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.driverallot.domain.solver.RouteTripConflict;
import org.optaplanner.examples.examination.domain.Student;
import org.optaplanner.examples.examination.domain.Topic;
import org.optaplanner.examples.examination.domain.solver.TopicConflict;
import org.optaplanner.persistence.xstream.impl.score.XStreamScoreConverter;

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
        // Do not add the planning entity's (routeTripList) because that will be done automatically
        return facts;
    }
    
    private List<RouteTripConflict> precalculateRouteTripConflictList() {
        List<RouteTripConflict> routeTripConflictList = new ArrayList<RouteTripConflict>();
        for (RouteTrip leftRouteTrip : routeTripList) {
            for (RouteTrip rightRouteTrip : routeTripList) {
                if (leftRouteTrip.getId() < rightRouteTrip.getId()) {
                    /*if(leftRouteTrip.getDriver() != null &&
                    		rightRouteTrip.getDriver() != null && 
                    		leftRouteTrip.getDriver().getId() == rightRouteTrip.getDriver().getId())*/ {
                    	int leftStartTime = leftRouteTrip.getTimeStart();
                    	int leftEndTime = leftRouteTrip.getTimeEnd();
                    	int rightStartTime = rightRouteTrip.getTimeStart();
                    	int rightEndTime = rightRouteTrip.getTimeEnd();
                    	Interval leftInterval = new Interval(leftStartTime, leftEndTime);
                    	Interval rightInterval = new Interval(rightStartTime, rightEndTime);
                    	if(intersects(leftInterval, rightInterval))
                    		routeTripConflictList.add(new RouteTripConflict(leftRouteTrip, rightRouteTrip));
                    }
                }
            }
        }
        return routeTripConflictList;
    }

	private boolean intersects(Interval leftInterval, Interval rightInterval) {
		System.out.println(leftInterval.getLowerBound() + "-" + leftInterval.getUpperBound() + "\t" + 
		rightInterval.getLowerBound() + "-" + rightInterval.getUpperBound());
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
