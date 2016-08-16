package com.yapta.travel.core;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class FlightSegment {

    private final String flightNumber;
    private final String departureDate;
    private final String origin;
    private final String destination;

    public FlightSegment(String flightNumber, String departureDate, String origin, String destination) {

        this.flightNumber = flightNumber;
        this.departureDate = departureDate;
        this.origin = origin;
        this.destination = destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSegment that = (FlightSegment) o;
        return Objects.equal(getFlightNumber(), that.getFlightNumber()) &&
                Objects.equal(getDepartureDate(), that.getDepartureDate()) &&
                Objects.equal(getOrigin(), that.getOrigin()) &&
                Objects.equal(getDestination(), that.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getFlightNumber(), getDepartureDate(), getOrigin(), getDestination());
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("flightNumber", flightNumber)
                .add("departureDate", departureDate)
                .add("origin", origin)
                .add("destination", destination)
                .toString();
    }
}
