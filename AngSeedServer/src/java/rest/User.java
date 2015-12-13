package rest;

import com.google.gson.Gson;
import entity.Reservation;
import facades.ReservationFacade;
import facades.UserFacade;
import java.io.IOException;
import java.net.ProtocolException;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("reservation")
@RolesAllowed("User")
public class User {
  
ReservationFacade rf = new ReservationFacade();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String checkLoggedIn() {
        return "{\"message\" : \"Logged in as user!\"}";
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String makeReservation(String htmlBody) throws ProtocolException, IOException {

        System.out.println("From REST: " + htmlBody);
        Gson gson = new Gson();
        Reservation newReservation = gson.fromJson(htmlBody, Reservation.class);
        System.out.println("After making Reservation-object in REST: " + newReservation.toString());
        rf.makeReservation(newReservation);
        return "";
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/getTickets/{username}")
    public String GetMyTickets(@PathParam("username") String username) {
        UserFacade uf = new UserFacade();
        Gson gson = new Gson();

        return gson.toJson(uf.getMyReservations(username));

    }
 
}