/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Andreas
 */
public class DTOReservationResponse {
    private String Origin;
    private String Destinaion;
    private Date Date;
    private int FlightTime;

    public DTOReservationResponse(String Origin, String Destinaion, Date Date, int FlightTime) {
        this.Origin = Origin;
        this.Destinaion = Destinaion;
        this.Date = Date;
        this.FlightTime = FlightTime;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    public String getDestinaion() {
        return Destinaion;
    }

    public void setDestinaion(String Destinaion) {
        this.Destinaion = Destinaion;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public int getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(int FlightTime) {
        this.FlightTime = FlightTime;
    }
}
