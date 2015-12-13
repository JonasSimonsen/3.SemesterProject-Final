/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas & Jonas
 */
@Entity
public class FlightEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String flightNumber;
    
    private int numberOfSeats;
    @ManyToOne
    private Airline airlineFlights;
    
//    @OneToMany(mappedBy = "flightInstances")
//    List<FlightInstance> flightInstances = new ArrayList();
    
    public FlightEntity(String flightNumber, int numberOfSeats, Airline airlineFlights) {
        this.flightNumber = flightNumber;
        this.numberOfSeats = numberOfSeats;
        this.airlineFlights = airlineFlights;
    }
   
    public FlightEntity() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Airline getAirlineFlights() {
        return airlineFlights;
    }

    public void setAirlineFlights(Airline airlineFlights) {
        this.airlineFlights = airlineFlights;
    }

//    public List<FlightInstance> getFlightInstances() {
//        return flightInstances;
//    }
//
//    public void setFlightInstances(List<FlightInstance> flightInstances) {
//        this.flightInstances = flightInstances;
//    }
    
    

}
