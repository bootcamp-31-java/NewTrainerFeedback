/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Aseprudin
 */
@Entity
@Table(name = "MATERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materi.findAll", query = "SELECT m FROM Materi m")
    , @NamedQuery(name = "Materi.findById", query = "SELECT m FROM Materi m WHERE m.id = :id")
    , @NamedQuery(name = "Materi.findByTitle", query = "SELECT m FROM Materi m WHERE m.title = :title")})
public class Materi implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "TITLE")
    private String title;
    @OneToMany(mappedBy = "title", fetch = FetchType.LAZY)
    private List<Shcedule> shceduleList;

    public Materi() {
    }

    public Materi(BigDecimal id) {
        this.id = id;
    }

    public Materi(BigDecimal id, String title) {
        this.id = id;
        this.title = title;
    }
    
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlTransient
    public List<Shcedule> getShceduleList() {
        return shceduleList;
    }

    public void setShceduleList(List<Shcedule> shceduleList) {
        this.shceduleList = shceduleList;
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
        if (!(object instanceof Materi)) {
            return false;
        }
        Materi other = (Materi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Materi[ id=" + id + " ]";
    }
    
}
