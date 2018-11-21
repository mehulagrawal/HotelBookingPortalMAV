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
@Table(name = "rooms", catalog = "hbsmav", schema = "")
@NamedQueries({
    @NamedQuery(name = "Rooms.findAll", query = "SELECT r FROM Rooms r"),
    @NamedQuery(name = "Rooms.findByRating", query = "SELECT r FROM Rooms r WHERE r.rating = :rating"),
    @NamedQuery(name = "Rooms.findByRoomID", query = "SELECT r FROM Rooms r WHERE r.roomID = :roomID"),
    @NamedQuery(name = "Rooms.findByRoomType", query = "SELECT r FROM Rooms r WHERE r.roomType = :roomType"),
    @NamedQuery(name = "Rooms.findByWaitingList", query = "SELECT r FROM Rooms r WHERE r.waitingList = :waitingList"),
    @NamedQuery(name = "Rooms.findByHotelName", query = "SELECT r FROM Rooms r WHERE r.hotelName = :hotelName")})
public class Rooms implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Rating")
    private int rating;
    @Id
    @Basic(optional = false)
    @Column(name = "RoomID")
    private Integer roomID;
    @Basic(optional = false)
    @Column(name = "RoomType")
    private int roomType;
    @Basic(optional = false)
    @Column(name = "WaitingList")
    private int waitingList;
    @Column(name = "Hotel_Name")
    private String hotelName;

    public Rooms() {
    }

    public Rooms(Integer roomID) {
        this.roomID = roomID;
    }

    public Rooms(Integer roomID, int rating, int roomType, int waitingList) {
        this.roomID = roomID;
        this.rating = rating;
        this.roomType = roomType;
        this.waitingList = waitingList;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        int oldRating = this.rating;
        this.rating = rating;
        changeSupport.firePropertyChange("rating", oldRating, rating);
    }

    public Integer getRoomID() {
        return roomID;
    }

    public void setRoomID(Integer roomID) {
        Integer oldRoomID = this.roomID;
        this.roomID = roomID;
        changeSupport.firePropertyChange("roomID", oldRoomID, roomID);
    }

    public int getRoomType() {
        return roomType;
    }

    public void setRoomType(int roomType) {
        int oldRoomType = this.roomType;
        this.roomType = roomType;
        changeSupport.firePropertyChange("roomType", oldRoomType, roomType);
    }

    public int getWaitingList() {
        return waitingList;
    }

    public void setWaitingList(int waitingList) {
        int oldWaitingList = this.waitingList;
        this.waitingList = waitingList;
        changeSupport.firePropertyChange("waitingList", oldWaitingList, waitingList);
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        String oldHotelName = this.hotelName;
        this.hotelName = hotelName;
        changeSupport.firePropertyChange("hotelName", oldHotelName, hotelName);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomID != null ? roomID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rooms)) {
            return false;
        }
        Rooms other = (Rooms) object;
        if ((this.roomID == null && other.roomID != null) || (this.roomID != null && !this.roomID.equals(other.roomID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mav.Rooms[ roomID=" + roomID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
