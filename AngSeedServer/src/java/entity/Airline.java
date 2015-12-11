/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas & Jonas
 */
@Entity
public class Airline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    
    private String URL;

    
//    @OneToMany(mappedBy = "airlineFlights")
//    List<FlightEntity> flights = new ArrayList();
    
    public Airline(String Name, String URL){
    this.name = Name;
    this.URL = URL;
    }
    
    public Airline(){}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}