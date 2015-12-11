/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ZARDOZ
 */
@Entity
@Table(name="Airport")
@NamedQueries({
    @NamedQuery(name = "Airport.findAll", query="SELECT a FROM Airport a"),
        @NamedQuery(name = "Airport.findAirportByIATA", query="SELECT a FROM Airport a WHERE a.IATACode = :IATACode")
})
public class Airport implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String IATACode;

    private String name;

    private String city;

    private int timeZone;

    public Airport(String IATACode, String name, String city, int timeZone) {
        this.IATACode = IATACode;
        this.name = name;
        this.city = city;
        this.timeZone = timeZone;
    }
    
    public Airport(){}

    
}
