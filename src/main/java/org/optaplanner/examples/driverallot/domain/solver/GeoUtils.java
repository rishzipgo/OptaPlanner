package org.optaplanner.examples.driverallot.domain.solver;

public class GeoUtils {
	private static final double EARTH_RADIUS_IN_KM = 6371.0088;
    private static final double KM_TO_METERS = 1000;


    /**
     * Calculate a distance between two points on a map
     * (see Haversine formula)
     *
     * @param latitudeA  latitude of point A
     * @param longitudeA longitude of point A
     * @param latitudeB  latitude of point B
     * @param longitudeB longitude of point B
     * @return distance in kilometers
     */
    public static double distance(
            double latitudeA, double longitudeA,
            double latitudeB, double longitudeB) {
        latitudeA = Math.toRadians(latitudeA);
        longitudeA = Math.toRadians(longitudeA);
        latitudeB = Math.toRadians(latitudeB);
        longitudeB = Math.toRadians(longitudeB);
        return 2 * EARTH_RADIUS_IN_KM * Math.asin(Math.sqrt(
        		Math.pow(Math.sin((latitudeB - latitudeA) / 2), 2) +
        		Math.cos(latitudeA) * Math.cos(latitudeB) *
        		Math.pow((Math.sin((longitudeB - longitudeA) / 2)), 2)));
    }

    /**
     * Calculate a distance between two points on a map
     * (see Haversine formula)
     *
     * @param latitudeA  latitude of point A
     * @param longitudeA longitude of point A
     * @param latitudeB  latitude of point B
     * @param longitudeB longitude of point B
     * @return distance in kilometers
     */
    public static double distance(
            double latitudeA, double longitudeA,
            double latitudeB, double longitudeB,
            boolean inMeters) {
        latitudeA = Math.toRadians(latitudeA);
        longitudeA = Math.toRadians(longitudeA);
        latitudeB = Math.toRadians(latitudeB);
        longitudeB = Math.toRadians(longitudeB);
        double distance = 2 * EARTH_RADIUS_IN_KM * Math.asin(Math.sqrt(
        		Math.pow(Math.sin((latitudeB - latitudeA) / 2), 2) +
                Math.cos(latitudeA) * Math.cos(latitudeB) *
                Math.pow((Math.sin((longitudeB - longitudeA) / 2)), 2)));
        if (inMeters) {
            return distance * KM_TO_METERS;
        }
        return distance;
    }

    /**
     * Convert kilometers into meters
     *
     * @param km kilometers
     */
    public static double kmToMeters(double km) {
        return km * KM_TO_METERS;
    }

    /**
     * Convert meters into kilometers
     *
     * @param meters meters
     */
    public static double metersToKm(double meters) {
        return meters / KM_TO_METERS;
    }
}
