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
import org.optaplanner.examples.driverallot.domain.RouteTrip;
import org.optaplanner.examples.examination.domain.Topic;

/**
 * Calculated during initialization, not modified during score calculation.
 */
public class RouteTripDistance implements Serializable, Comparable<RouteTripDistance> {


	private static final double AVG_SPEED_DRIVER = 25;
	
	private RouteTrip leftRouteTrip;
    private RouteTrip rightRouteTrip;
    private double distance;
    private double distanceInMeters;
    private double time;
    private double timeInMinutes;
    private boolean possibleToAttendBoth;

    

    public RouteTripDistance(RouteTrip leftRouteTrip, RouteTrip rightRouteTrip) {
		super();
		this.leftRouteTrip = leftRouteTrip;
		this.rightRouteTrip = rightRouteTrip;
		this.distance = GeoUtils.distance(leftRouteTrip.getEndLatitude(), leftRouteTrip.getEndLongitude(),
				rightRouteTrip.getStartLatitude(), rightRouteTrip.getStartLongitude());
		this.distanceInMeters = distance*1000;
		this.time = distance/AVG_SPEED_DRIVER;
		this.timeInMinutes = time*60;
		if(leftRouteTrip.getTimeEnd() + timeInMinutes <= rightRouteTrip.getTimeStart())
			this.possibleToAttendBoth = true;
		else
			this.possibleToAttendBoth = false;
	}

	public RouteTrip getLeftRouteTrip() {
		return leftRouteTrip;
	}

	public void setLeftRouteTrip(RouteTrip leftRouteTrip) {
		this.leftRouteTrip = leftRouteTrip;
	}

	public RouteTrip getRightRouteTrip() {
		return rightRouteTrip;
	}

	public void setRightRouteTrip(RouteTrip rightRouteTrip) {
		this.rightRouteTrip = rightRouteTrip;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getTimeInMinutes() {
		return timeInMinutes;
	}

	public void setTimeInMinutes(double timeInMinutes) {
		this.timeInMinutes = timeInMinutes;
	}

	public double getDistanceInMeters() {
		return distanceInMeters;
	}

	public void setDistanceInMeters(double distanceInMeters) {
		this.distanceInMeters = distanceInMeters;
	}

	public boolean isPossibleToAttendBoth() {
		return possibleToAttendBoth;
	}

	public void setPossibleToAttendBoth(boolean possibleToAttendBoth) {
		this.possibleToAttendBoth = possibleToAttendBoth;
	}

	public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof RouteTripDistance) {
            RouteTripDistance other = (RouteTripDistance) o;
            return new EqualsBuilder()
                    .append(leftRouteTrip, other.leftRouteTrip)
                    .append(rightRouteTrip, other.rightRouteTrip)
                    .isEquals();
        } else {
            return false;
        }
    }

    public int hashCode() {
        return new HashCodeBuilder()
                .append(leftRouteTrip)
                .append(rightRouteTrip)
                .toHashCode();
    }

    public int compareTo(RouteTripDistance other) {
        return new CompareToBuilder()
                .append(leftRouteTrip, other.leftRouteTrip)
                .append(rightRouteTrip, other.rightRouteTrip)
                .toComparison();
    }

    @Override
    public String toString() {
        return leftRouteTrip + " & " + rightRouteTrip;
    }

}
