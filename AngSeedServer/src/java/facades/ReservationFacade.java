/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.Passenger;
import entity.Reservation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.Persistence;
import static javax.ws.rs.client.Entity.json;

/**
 *
 * @author Andreas
 */
public class ReservationFacade {
        private EntityManagerFactory emf = Persistence.createEntityManagerFactory(deploy.DeploymentConfiguration.PU_NAME);

    //Her skal vi kontakte det airline vi vil reservere ved, som så sender et reservationResponse som
    // vi skal hive info ud fra, og tilføje til vores Reservation-objekt, som efterfølgende skal gemmes i DB.
    public void makeReservation(Reservation newReservation) throws MalformedURLException, ProtocolException, IOException {

        EntityManager em = emf.createEntityManager();

       Gson gson = new Gson();
       
       //URL på det airline som der skal bestilles hos..
        String url = newReservation.getAirlineURL();

        //Vi laver et json objekt som inderholder info til det airline vi vil bestille hos
        JsonObject jsonObj = new JsonObject();
        jsonObj.addProperty("flightID", newReservation.getFlightID());
        jsonObj.addProperty("numberOfSeats", newReservation.getNumberOfSeats());
        jsonObj.addProperty("ReserveeName", newReservation.getReserveeName());
        jsonObj.addProperty("ReservePhone", newReservation.getReservePhone());
        jsonObj.addProperty("ReserveeEmail", newReservation.getReserveeEmail());
        JsonArray jsonPassengers = new JsonArray();

        //Et array af passengers oprettes
        for (int i = 0; i < newReservation.getPassengers().size(); i++) {
            JsonObject pas = new JsonObject();
            pas.addProperty("firstName", newReservation.getPassengers().get(i).getFirstName());
            pas.addProperty("lastName", newReservation.getPassengers().get(i).getLastName());
            jsonPassengers.add(pas);

        }
        //JsonArrayet tilføjes til json-objektet.
        JsonElement array = gson.toJsonTree(jsonPassengers);
        jsonObj.add("Passengers", array);

        //Det endelige request er klar
        String jsonRequest = gson.toJson(jsonObj);

        //Her laves en http-connection til det givne airlines url,
        // samt json-objektet sendes med som en string
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestProperty("Content-Type", "application/json;");
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Method", "POST");
        con.setDoOutput(true);
        System.out.println(jsonRequest);
        PrintWriter pw = new PrintWriter(con.getOutputStream());
        try (OutputStream os = con.getOutputStream()) {
            os.write(jsonRequest.getBytes("UTF-8"));
        }
        int HttpResult = con.getResponseCode();
        InputStreamReader is = HttpResult < 400 ? new InputStreamReader(con.getInputStream(), "utf-8")
                : new InputStreamReader(con.getErrorStream(), "utf-8");
        Scanner responseReader = new Scanner(is);
        String response = "";
        while (responseReader.hasNext()) {
            response += responseReader.nextLine() + System.getProperty("line.separator");
        }
        System.out.println(response);
        System.out.println(con.getResponseCode());
        System.out.println(con.getResponseMessage());
        
        Reservation ResserRes = gson.fromJson(response, Reservation.class);
        
        newReservation.setOrigin(ResserRes.getOrigin());
        newReservation.setDestinaion(ResserRes.getDestinaion());
        newReservation.setFlightTime(ResserRes.getFlightTime());
        newReservation.setDate(ResserRes.getDate());
        if(con.getResponseCode() == 200){
        try {
            em.getTransaction().begin();
            em.persist(newReservation);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        }else{
            System.out.println("couldnt save your Reservation at this time: " + con.getResponseMessage());
        }
        //Her skal returneres 
    }


    public static void main(String[] args) throws ProtocolException, IOException {

        ReservationFacade rf = new ReservationFacade();
        List<Passenger> passengers = new ArrayList();
        Passenger p1 = new Passenger("Hanne", "Mis");
        Passenger p2 = new Passenger("Lotte", "Lim");
        passengers.add(p1);
        passengers.add(p2);
        Reservation r = new Reservation("http://angularairline-plaul.rhcloud.com/api/flightreservation", "COL2216x100x2016-01-04T15:00:00.000Z", 3, "John Doe", "88888888", "hej@lol.dk", passengers);

        rf.makeReservation(r);
    }

    //Her hentes infoen om reservationen op fra db, og sendes til REST'en, som returnerer det som et Json-object..
//    public DTOInfoResponse reservationResponse(String reserveeName) {
//
//        EntityManager em = emf.createEntityManager();
//
//        Query query = em.createNativeQuery("SELECT * FROM RESERVATION WHERE reserveename = '" + reserveeName + "'");
//        Reservation r;
//        r = (Reservation) query.getSingleResult();
//
//        return r;
//
//        //DTOInfoResponse response = em.find(Reservation.class, reserveeName);
//    }
}
