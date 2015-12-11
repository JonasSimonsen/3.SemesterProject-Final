/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Andreas & Jonas
 */
@Entity
public class FlightInstance implements Serializable {
    @ManyToOne
    @Id
    private FlightEntity flightInstances;
    private static final long serialVersionUID = 1L;
    // denne Date med tid skal gemmes som ISO 8601|| ved hjælp af Date().toISOString();
    @Temporal(TemporalType.TIME)
    private Date departureTime;
    @Temporal(TemporalType.DATE)
    private Date departureDate;
    
    private int flightTime;
    
    private Airport origin;
    
    private Airport destination;
    
    private int availSeats;
    
    private int price;
    
    //@OneToMany(mappedBy = "flightInstanceReservations")
    //private List<Reservation> reservations = new ArrayList();

    public FlightInstance(FlightEntity flightInstances, Date departureTime, Date departureDate, int flightTime, Airport origin, Airport destination, int availSeats, int price) {
        this.flightInstances = flightInstances;
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.origin = origin;
        this.destination = destination;
        this.availSeats = availSeats;
        this.price = price;
    }
        
    public FlightInstance(){}
}
