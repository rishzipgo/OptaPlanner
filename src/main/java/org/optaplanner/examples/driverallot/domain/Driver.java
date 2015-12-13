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

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.InverseRelationShadowVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.common.swingui.components.Labeled;
import org.optaplanner.examples.driverallot.domain.solver.DriverStrengthComparator;
import org.optaplanner.examples.driverallot.domain.solver.RouteTripDifficultyComparator;

@PlanningEntity
@XStreamAlias("Driver")
public class Driver extends AbstractPersistable implements Labeled {

    private int cpuPower; // in gigahertz
    private int memory; // in gigabyte RAM
    private int networkBandwidth; // in gigabyte per hour
    private int rank; // in euro per month
    private int timeIn;
    private int timeOut;
    private double latitude;
    private double longitude;
	private ArrayList<RouteTrip> driverTripList = new ArrayList<>();
	private ArrayList<RouteTrip> routeTripList = new ArrayList<>();
	

    public Driver(int rank, int timeIn, int timeOut) {
		super();
		this.rank = rank;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}

	public Driver(int rank, int timeIn, int timeOut, double latitude, double longitude) {
		super();
		this.rank = rank;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public Driver(int cpuPower, int memory, int networkBandwidth, int cost, int timeIn, int timeOut) {
		super();
		this.cpuPower = cpuPower;
		this.memory = memory;
		this.networkBandwidth = networkBandwidth;
		this.rank = cost;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
	}
    
    public Driver() {
    	super();
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public int getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(int timeIn) {
		this.timeIn = timeIn;
	}

	public int getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public int getCpuPower() {
        return cpuPower;
    }

    public void setCpuPower(int cpuPower) {
        this.cpuPower = cpuPower;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public int getNetworkBandwidth() {
        return networkBandwidth;
    }

    public void setNetworkBandwidth(int networkBandwidth) {
        this.networkBandwidth = networkBandwidth;
    }

    public int getCost() {
        return rank;
    }

    public void setCost(int cost) {
        this.rank = cost;
    }
    
    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
    
    public void setDriverTripList(ArrayList<RouteTrip> driverTripList) {
    	/*sort(driverTripList);
		driverTripList.clear();*/
    	this.driverTripList = driverTripList;
    	/*this.routeTripList = driverTripList;
    	this.routeTripList.addAll(driverTripList);*/
		/*System.out.println(driverTripList.size());
		for(int i = 1; i < driverTripList.size(); i++)
			driverTripList.get(i).setPreviousTrip(driverTripList.get(i-1));*/
	}
    
    
    
    private void sort(ArrayList<RouteTrip> driverTripList) {
    	driverTripList.clear();
    	
		/*for(int i = 0; i < driverTripList.size()-1; i++)
			for(int j = i+1; j < driverTripList.size(); j++)
				if(driverTripList.get(j).getTimeStart() < driverTripList.get(i).getTimeStart()) {
					RouteTrip tempi = driverTripList.get(i);
					RouteTrip tempj = driverTripList.get(j);
					driverTripList.remove(j);
					driverTripList.remove(i);
					driverTripList.add(i, tempj);
					driverTripList.add(j, tempi);
				}*/
	}

	@InverseRelationShadowVariable(sourceVariableName = "driver")
    public ArrayList<RouteTrip> getDriverTripList() {
		if(driverTripList.size() > 0) {
			driverTripList.get(0).setPreviousTrip(null);
			driverTripList.get(driverTripList.size()-1).setNextTrip(null);
		}
		for(int i = 1; i < driverTripList.size(); i++) {
			driverTripList.get(i).setPreviousTrip(driverTripList.get(i-1));
		}
		for(int i = 0; i < driverTripList.size()-1; i++) {
			driverTripList.get(i).setNextTrip(driverTripList.get(i+1));
		}
		
        return driverTripList;
    }
	
	
	public ArrayList<RouteTrip> getRouteTripList() {
        return routeTripList;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

	public int getMultiplicand() {
        return cpuPower * memory * networkBandwidth;
    }

    public String getLabel() {
        return "Driver " + id;
    }
    
    public String tostring() {
    	return this.getLabel() + "\t" + this.getTimeIn() + "\t" + this.getTimeOut() + "\t" + this.getRank() + "\t" + this.latitude + "," + this.longitude;
    }

}
