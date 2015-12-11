/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Andreas
 */
public class DTOInfoResponse {
    String airlineURL;
    String flightID;
    String origin;
    String destination;
    String date;
    int traveltime;
    float totalPrice;
    int numberOfSeats;

    public DTOInfoResponse(String airlineURL, String flightID, String origin, String destination, String date, int traveltime, float totalPrice, int numberOfSeats) {
        this.airlineURL = airlineURL;
        this.flightID = flightID;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.traveltime = traveltime;
        this.totalPrice = totalPrice;
        this.numberOfSeats = numberOfSeats;
    }

    public String getAirlineURL() {
        return airlineURL;
    }

    public void setAirlineURL(String airlineURL) {
        this.airlineURL = airlineURL;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DTOInfoResponse() {
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String Origin) {
        this.origin = Origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String Destination) {
        this.destination = Destination;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
