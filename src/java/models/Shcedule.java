/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aseprudin
 */
@Entity
@Table(name = "SHCEDULE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shcedule.findAll", query = "SELECT s FROM Shcedule s")
    , @NamedQuery(name = "Shcedule.findById", query = "SELECT s FROM Shcedule s WHERE s.id = :id")
    , @NamedQuery(name = "Shcedule.findByEventDate", query = "SELECT s FROM Shcedule s WHERE s.eventDate = :eventDate")
    , @NamedQuery(name = "Shcedule.findByExpiredDate", query = "SELECT s FROM Shcedule s WHERE s.expiredDate = :expiredDate")})
public class Shcedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private String id;
    @Column(name = "EVENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date eventDate;
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @JoinColumn(name = "TRAINER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee trainer;
    @JoinColumn(name = "TITLE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Materi title;
    @JoinColumn(name = "ROOM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Room room;
    @OneToMany(mappedBy = "schedule", fetch = FetchType.LAZY)
    private List<Form> formList;

    public Shcedule() {
    }

    public Shcedule(String id) {
        this.id = id;
    }

    public Shcedule(String id, Date eventDate, Date expiredDate, Employee trainer, Materi title, Room room) {
        this.id = id;
        this.eventDate = eventDate;
        this.expiredDate = expiredDate;
        this.trainer = trainer;
        this.title = title;
        this.room = room;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Employee getTrainer() {
        return trainer;
    }

    public void setTrainer(Employee trainer) {
        this.trainer = trainer;
    }

    public Materi getTitle() {
        return title;
    }

    public void setTitle(Materi title) {
        this.title = title;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @XmlTransient
    public List<Form> getFormList() {
        return formList;
    }

    public void setFormList(List<Form> formList) {
        this.formList = formList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shcedule)) {
            return false;
        }
        Shcedule other = (Shcedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Shcedule[ id=" + id + " ]";
    }
    
}
