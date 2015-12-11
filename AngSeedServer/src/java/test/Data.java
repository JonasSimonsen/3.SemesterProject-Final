/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import entity.Airline;
import entity.Airport;
import entity.Flight;
import entity.FlightEntity;
import entity.FlightInstance;
import entity.Passenger;
import entity.Reservation;
//import entity.URL;
import entity.User;
import facades.UserFacade;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas
 */
public class Data {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(deploy.DeploymentConfiguration.PU_NAME);
        EntityManager em = emf.createEntityManager();
        
        int CPHGMT = 1;
        int LGWGMT = 0;
        Date deptime = new Date();
        Date depDate = new Date();
        // flyvetiden bliver gemt som minutter
        int FlightDura = 190;
        Airline airline1 = new Airline("Angular Airline", "http://angularairline-plaul.rhcloud.com/");
        //Airline airline2 = new Airline("SARS", "http://SARS.rhcloud.com/");
        FlightEntity flight1 = new FlightEntity("BD1337", 100, airline1);
        Airport CPHAirport = new Airport("CPH", "Kastrup", "Copenhagen", CPHGMT);
        Airport LGWAirport = new Airport("LGW", "Gatwick", "London", LGWGMT);
        FlightInstance firstTrip = new FlightInstance(flight1, deptime , depDate , FlightDura, CPHAirport, LGWAirport, flight1.getNumberOfSeats(), 1337);
        
        List<Passenger> passengers = new ArrayList();
        Passenger pas1 = new Passenger("Lasse", "Larsen");
        Passenger pas2 = new Passenger("Peter", "Hansen");
        passengers.add(pas1);
        passengers.add(pas2);
        //Reservation res1 = new Reservation(flight1.getFlightNumber(), 3, "Peter Hansen", "83838383", "Peter@lol.dk", passengers);
        Reservation res2 = new Reservation("Peter@lol.dk", flight1.getFlightNumber(), 3, "Peter", "11223344", "NotAFakeAccount@Lol.gg", passengers);
//        URL url1 = new URL("Angular Airline", "http://angularairline-plaul.rhcloud.com/");
//        URL url2 = new URL("SARS", "http://SARS.rhcloud.com/"
//                + "");
        
        
//        UserFacade facade = new UserFacade();
//        facade.createUser("user", "test");
        
        em.getTransaction().begin();
        em.persist(airline1);
        //em.persist(airline2);
        em.persist(flight1);
//        em.persist(url1);
//        em.persist(url2);
        em.persist(res2);
        em.persist(CPHAirport);
        em.persist(LGWAirport);
        em.persist(firstTrip);
        em.getTransaction().commit();
        em.close();
         
    }
}
