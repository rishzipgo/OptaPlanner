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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.driverallot.domain.solver.DriverStrengthComparator;
import org.optaplanner.examples.driverallot.domain.solver.RouteTripDifficultyComparator;

@PlanningEntity(difficultyComparatorClass = RouteTripDifficultyComparator.class)
@XStreamAlias("RouteTrip")
public class RouteTrip extends AbstractPersistable {

    private int requiredCpuPower; // in gigahertz
    private int requiredMemory; // in gigabyte RAM
    private int requiredNetworkBandwidth; // in gigabyte per hour
    private int timeStart;
    private int timeEnd;
    private int rank;

	public RouteTrip(int timeStart, int timeEnd, int rank) {
		super();
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.rank = rank;
	}

	// Planning variables: changes during planning, between score calculations.
    private Driver driver;
    
    public RouteTrip(int timeStart, int timeEnd) {
		super();
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}

	public RouteTrip(int requiredCpuPower, int requiredMemory, int requiredNetworkBandwidth, int timeStart, int timeEnd) {
		super();
		this.requiredCpuPower = requiredCpuPower;
		this.requiredMemory = requiredMemory;
		this.requiredNetworkBandwidth = requiredNetworkBandwidth;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
	}
    
    public RouteTrip() {
    	super();
    }


	public int getTimeEnd() {
		return timeEnd;
	}


	public void setTimeEnd(int timeEnd) {
		this.timeEnd = timeEnd;
	}


	public int getTimeStart() {
		return timeStart;
	}
    

	public void setTimeStart(int timeStart) {
		this.timeStart = timeStart;
	}

    public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRequiredCpuPower() {
        return requiredCpuPower;
    }

    public void setRequiredCpuPower(int requiredCpuPower) {
        this.requiredCpuPower = requiredCpuPower;
    }

    public int getRequiredMemory() {
        return requiredMemory;
    }

    public void setRequiredMemory(int requiredMemory) {
        this.requiredMemory = requiredMemory;
    }

    public int getRequiredNetworkBandwidth() {
        return requiredNetworkBandwidth;
    }

    public void setRequiredNetworkBandwidth(int requiredNetworkBandwidth) {
        this.requiredNetworkBandwidth = requiredNetworkBandwidth;
    }

    @PlanningVariable(valueRangeProviderRefs = {"driverRange"},
            strengthComparatorClass = DriverStrengthComparator.class)
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    public int getRequiredMultiplicand() {
        return requiredCpuPower * requiredMemory * requiredNetworkBandwidth;
    }

    public String getLabel() {
        return "RouteTrip " + id;
    }
    
    public String tostring() {
    	return this.getLabel() + "\t" + this.getTimeStart() + "\t" + this.getTimeEnd() + "\t" + this.getRank();
    }

}
