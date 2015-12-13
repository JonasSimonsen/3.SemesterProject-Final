package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Andreas
 */
@Entity
public class Reservation implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String airlineURL;
    private String flightID;
    private int numberOfSeats;
    @Id
    private String UserName;
    private String ReserveeName;
    private String ReservePhone;
    private String ReserveeEmail;
    private String Origin;
    private String Destination;
    
    private String Date;
    private int FlightTime;
    
    
    @OneToMany (cascade = CascadeType.PERSIST)
    private List<Passenger> Passengers;

    //private Long price;

//    @OneToMany(mappedBy = "ReservationPassenger")
//    private List<Passenger> passengers = new ArrayList();

    public Reservation(String airlineURL, String flightID, int numberOfSeats,String username, String ReserveeName, String ReserveePhone, String ReserveeEmail, List<Passenger> Passengers) {
        this.airlineURL = airlineURL;
        this.flightID = flightID;
        this.numberOfSeats = numberOfSeats;
        this.UserName = username;
        this.ReserveeName = ReserveeName;
        this.ReservePhone = ReserveePhone;
        this.ReserveeEmail = ReserveeEmail;
        this.Passengers = Passengers;
    }

    public Reservation() {
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveeName() {
        return ReserveeName;
    }

    public void setReserveeName(String ReserveeName) {
        this.ReserveeName = ReserveeName;
    }

    public String getReservePhone() {
        return ReservePhone;
    }

    public void setReservePhone(String ReserveePhone) {
        this.ReservePhone = ReserveePhone;
    }

    public String getReserveeEmail() {
        return ReserveeEmail;
    }

    public void setReserveeEmail(String ReserveeEmail) {
        this.ReserveeEmail = ReserveeEmail;
    }

    public List<Passenger> getPassengers() {
        return Passengers;
    }

    public void setPassengers(List<Passenger> Passengers) {
        this.Passengers = Passengers;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestinaion() {
        return Destination;
    }

    public void setDestinaion(String Destinaion) {
        this.Destination = Destinaion;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public int getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(int FlightTime) {
        this.FlightTime = FlightTime;
    }

    public String getAirlineURL() {
        return airlineURL;
    }

    public void setAirlineURL(String airlineURL) {
        this.airlineURL = airlineURL;
    }

    @Override
    public String toString() {
        return "Reservation{" + "airlineURL=" + airlineURL + ", flightID=" + flightID + ", numberOfSeats=" + numberOfSeats + ", ReserveeName=" + ReserveeName + ", ReserveePhone=" + ReservePhone + ", ReserveeEmail=" + ReserveeEmail + ", Origin=" + Origin + ", Destinaion=" + Destination + ", Date=" + Date + ", FlightTime=" + FlightTime + ", Passengers=" + Passengers + '}';
    }
    
    
    
}