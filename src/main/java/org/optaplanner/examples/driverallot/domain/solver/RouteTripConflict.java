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
public class RouteTripConflict implements Serializable, Comparable<RouteTripConflict> {

    private RouteTrip leftRouteTrip;
    private RouteTrip rightRouteTrip;

    

    public RouteTripConflict(RouteTrip leftRouteTrip, RouteTrip rightRouteTrip) {
		super();
		this.leftRouteTrip = leftRouteTrip;
		this.rightRouteTrip = rightRouteTrip;
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

	public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o instanceof RouteTripConflict) {
            RouteTripConflict other = (RouteTripConflict) o;
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

    public int compareTo(RouteTripConflict other) {
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
