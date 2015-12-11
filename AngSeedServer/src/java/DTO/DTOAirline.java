/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author Andreas
 */
public class DTOAirline {
   String airline;
    List<DTOInfoResponse> flights;
    String airlineURL;

    public DTOAirline(String name, List<DTOInfoResponse> recievedFlights, String airlineURL) {
        this.airline = name;
        this.flights = recievedFlights;
        this.airlineURL = airlineURL;
    }

    public String getName() {
        return airline;
    }

    public void setName(String name) {
        this.airline = name;
    }

    public List<DTOInfoResponse> getRecievedFlights() {
        return flights;
    }

    public void setModtagetbilletter(List<DTOInfoResponse> modtagetbilletter) {
        this.flights = modtagetbilletter;
    }

    public String getAirlineURL() {
        return airlineURL;
    }

    public void setAirlineURL(String airlineURL) {
        this.airlineURL = airlineURL;
    }

    @Override
    public String toString() {
        return "DTOAirline{" + "airline=" + airline + ", flights=" + flights + ", airlineURL=" + airlineURL + '}';
    } 
}
