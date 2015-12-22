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

package org.optaplanner.examples.driverallot.domain.solver;

import java.io.Serializable;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.examples.driverallot.domain.Driver;
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.examination.domain.Topic;

/**
 * Calculated during initialization, not modified during score calculation.
 */
public class DriverRouteTripDistance implements Serializable, Comparable<DriverRouteTripDistance> {

	private static final double AVG_SPEED_DRIVER = 25;

	private Driver driver;
	private RouteTrip routeTrip;
	private double distanceToStart;
	private double distanceToEnd;
	private double timeToStart;
	private double timeToEnd;
	private double timeToStartInMinutes;
	private double timeToEndInMinutes;
	private double distanceToStartInMeters;
	private double distanceToEndInMeters;



	public DriverRouteTripDistance(Driver driver, RouteTrip routeTrip) {
		super();
		this.driver = driver;
		this.routeTrip = routeTrip;
		//if(driver.getId() != 0) {
		if(driver.getType() != Driver.UNIVERSAL_DRIVER) {
			this.distanceToStart = GeoUtils.distance(driver.getLatitude(), driver.getLongitude(),
					routeTrip.getStartLatitude(), routeTrip.getStartLongitude());
			this.distanceToStartInMeters = distanceToStart*1000;
			this.distanceToEnd = GeoUtils.distance(driver.getLatitude(), driver.getLongitude(),
					routeTrip.getEndLatitude(), routeTrip.getEndLongitude());
			this.distanceToEndInMeters = distanceToEnd*1000;
			this.timeToStart = distanceToStart/AVG_SPEED_DRIVER;
			this.timeToStartInMinutes = timeToStart*60;
			this.timeToEnd = distanceToEnd/AVG_SPEED_DRIVER;
			this.timeToEndInMinutes = timeToEnd*60;
		}
		else{
			this.distanceToStart = 0;
			this.distanceToStartInMeters = 0;
			this.distanceToEnd = 0;
			this.distanceToEndInMeters = 0;
			this.timeToStart = 0;
			this.timeToEnd = 0;
		}
	}



	public Driver getDriver() {
		return driver;
	}



	public void setDriver(Driver driver) {
		this.driver = driver;
	}



	public RouteTrip getRouteTrip() {
		return routeTrip;
	}



	public void setRouteTrip(RouteTrip routeTrip) {
		this.routeTrip = routeTrip;
	}



	public double getDistanceToStart() {
		return distanceToStart;
	}



	public void setDistanceToStart(double distanceToStart) {
		this.distanceToStart = distanceToStart;
	}



	public double getDistanceToEnd() {
		return distanceToEnd;
	}



	public void setDistanceToEnd(double distanceToEnd) {
		this.distanceToEnd = distanceToEnd;
	}



	public double getDistanceToStartInMeters() {
		return distanceToStartInMeters;
	}



	public void setDistanceToStartInMeters(double distanceToStartInMeters) {
		this.distanceToStartInMeters = distanceToStartInMeters;
	}



	public double getDistanceToEndInMeters() {
		return distanceToEndInMeters;
	}



	public void setDistanceToEndInMeters(double distanceToEndInMeters) {
		this.distanceToEndInMeters = distanceToEndInMeters;
	}



	public double getTimeToStart() {
		return timeToStart;
	}



	public void setTimeToStart(double timeToStart) {
		this.timeToStart = timeToStart;
	}



	public double getTimeToEnd() {
		return timeToEnd;
	}



	public void setTimeToEnd(double timeToEnd) {
		this.timeToEnd = timeToEnd;
	}



	public double getTimeToStartInMinutes() {
		return timeToStartInMinutes;
	}



	public void setTimeToStartInMinutes(double timeToStartInMinutes) {
		this.timeToStartInMinutes = timeToStartInMinutes;
	}



	public double getTimeToEndInMinutes() {
		return timeToEndInMinutes;
	}



	public void setTimeToEndInMinutes(double timeToEndInMinutes) {
		this.timeToEndInMinutes = timeToEndInMinutes;
	}



	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else if (o instanceof DriverRouteTripDistance) {
			DriverRouteTripDistance other = (DriverRouteTripDistance) o;
			return new EqualsBuilder()
					.append(driver, other.driver)
					.append(routeTrip, other.routeTrip)
					.isEquals();
		} else {
			return false;
		}
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(driver)
				.append(routeTrip)
				.toHashCode();
	}

	public int compareTo(DriverRouteTripDistance other) {
		return new CompareToBuilder()
				.append(driver, other.driver)
				.append(routeTrip, other.routeTrip)
				.toComparison();
	}

	@Override
	public String toString() {
		return driver + " & " + routeTrip;
	}

}
