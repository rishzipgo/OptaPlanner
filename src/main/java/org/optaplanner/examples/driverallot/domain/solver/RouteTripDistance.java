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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.joda.time.Minutes;
import org.optaplanner.examples.driverallot.domain.Constants;
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
    private double cost;
    private boolean possibleToAttendBoth;
    private double routeTripTimeDifferenceInMinutes;
    private double routeTripCostDifference;

    

    public RouteTripDistance(RouteTrip leftRouteTrip, RouteTrip rightRouteTrip) throws ParseException {
		super();
		this.leftRouteTrip = leftRouteTrip;
		this.rightRouteTrip = rightRouteTrip;
		this.distance = GeoUtils.distance(leftRouteTrip.getEndLatitude(), leftRouteTrip.getEndLongitude(),
				rightRouteTrip.getStartLatitude(), rightRouteTrip.getStartLongitude());
		this.distanceInMeters = distance*Constants.METERS_IN_KILOMETERS;
		this.time = distance/AVG_SPEED_DRIVER;
		this.timeInMinutes = time*Constants.MINUTES_IN_HOUR;
		this.cost = this.distance*Constants.COST_PER_KM;
		if(leftRouteTrip.getTimeEnd() + timeInMinutes <= rightRouteTrip.getTimeStart())
			this.possibleToAttendBoth = true;
		else
			this.possibleToAttendBoth = false;
		
		
		this.routeTripTimeDifferenceInMinutes = timeDifferenceMilitaryFormat(leftRouteTrip.getTimeEnd(), rightRouteTrip.getTimeStart());
		this.routeTripCostDifference = (this.routeTripTimeDifferenceInMinutes/Constants.MINUTES_IN_HOUR)*Constants.AVG_SPEED_DRIVER*Constants.COST_PER_KM;
	}

	private double timeDifferenceMilitaryFormat(int timeEnd, int timeStart) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("hhmm");
		String timeEndString = String.valueOf(timeEnd);
		if(timeEndString.length() < 4)
			timeEndString = "0" + timeEndString;
		Date startDate = format.parse(timeEndString);
		String timeStartString = String.valueOf(timeStart);
		if(timeStartString.length() < 4)
			timeStartString = "0" + timeStartString;
		Date endDate = format.parse(timeStartString);
		DateTime jdStartDate = new DateTime(startDate);
		DateTime jdEndDate = new DateTime(endDate);
		int hours = Hours.hoursBetween(jdStartDate, jdEndDate).getHours();
		if(hours < 0)
			hours = Hours.hoursBetween(jdEndDate, jdStartDate).getHours();
		//System.out.println(hours);
		hours = hours%Constants.HOURS_IN_DAY;
		int minutes = Minutes.minutesBetween(jdStartDate, jdEndDate).getMinutes();
		if(minutes < 0)
			minutes = Minutes.minutesBetween(jdEndDate, jdStartDate).getMinutes();
		//System.out.println(minutes);
		minutes = minutes % Constants.MINUTES_IN_HOUR;
		
		//System.out.println(timeEndString + " " + timeStartString + " " + hours + " " + minutes);
		
		return hours*Constants.MINUTES_IN_HOUR + minutes;
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

	public double getRouteTripTimeDifferenceInMinutes() {
		return routeTripTimeDifferenceInMinutes;
	}

	public void setRouteTripTimeDifferenceInMinutes(double routeTripTimeDifferenceInMinutes) {
		this.routeTripTimeDifferenceInMinutes = routeTripTimeDifferenceInMinutes;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getRouteTripCostDifference() {
		return routeTripCostDifference;
	}

	public void setRouteTripCostDifference(double routeTripCostDifference) {
		this.routeTripCostDifference = routeTripCostDifference;
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
