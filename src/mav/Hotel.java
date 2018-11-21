/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mav;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Mehul
 */
@Entity
@Table(name = "hotel", catalog = "hbsmav", schema = "")
@NamedQueries({
    @NamedQuery(name = "Hotel.findAll", query = "SELECT h FROM Hotel h"),
    @NamedQuery(name = "Hotel.findByHotelID", query = "SELECT h FROM Hotel h WHERE h.hotelID = :hotelID"),
    @NamedQuery(name = "Hotel.findByName", query = "SELECT h FROM Hotel h WHERE h.name = :name"),
    @NamedQuery(name = "Hotel.findByLocation", query = "SELECT h FROM Hotel h WHERE h.location = :location"),
    @NamedQuery(name = "Hotel.findByAddress", query = "SELECT h FROM Hotel h WHERE h.address = :address"),
    @NamedQuery(name = "Hotel.findByRating", query = "SELECT h FROM Hotel h WHERE h.rating = :rating")})
public class Hotel implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Hotel_ID")
    private Integer hotelID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "Location")
    private String location;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Rating")
    private float rating;

    public Hotel() {
    }

    public Hotel(Integer hotelID) {
        this.hotelID = hotelID;
    }

    public Hotel(Integer hotelID, String name, String location, String address, float rating) {
        this.hotelID = hotelID;
        this.name = name;
        this.location = location;
        this.address = address;
        this.rating = rating;
    }

    public Integer getHotelID() {
        return hotelID;
    }

    public void setHotelID(Integer hotelID) {
        Integer oldHotelID = this.hotelID;
        this.hotelID = hotelID;
        changeSupport.firePropertyChange("hotelID", oldHotelID, hotelID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        String oldLocation = this.location;
        this.location = location;
        changeSupport.firePropertyChange("location", oldLocation, location);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        float oldRating = this.rating;
        this.rating = rating;
        changeSupport.firePropertyChange("rating", oldRating, rating);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hotelID != null ? hotelID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hotel)) {
            return false;
        }
        Hotel other = (Hotel) object;
        if ((this.hotelID == null && other.hotelID != null) || (this.hotelID != null && !this.hotelID.equals(other.hotelID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mav.Hotel[ hotelID=" + hotelID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
