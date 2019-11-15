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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "FORM")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Form.findAll", query = "SELECT f FROM Form f")
    , @NamedQuery(name = "Form.findById", query = "SELECT f FROM Form f WHERE f.id = :id")})
public class Form implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @JoinColumn(name = "PARTICIPANT", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Employee participant;
    @JoinColumn(name = "SCHEDULE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Shcedule schedule;
    @OneToMany(mappedBy = "form", fetch = FetchType.LAZY)
    private List<AnswerEssay> answerEssayList;
    @OneToMany(mappedBy = "form", fetch = FetchType.LAZY)
    private List<AnswerPg> answerPgList;

    public Form() {
    }

    public Form(BigDecimal id) {
        this.id = id;
    }

    public Form(BigDecimal id, Employee participant, Shcedule schedule) {
        this.id = id;
        this.participant = participant;
        this.schedule = schedule;
    }
    

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Employee getParticipant() {
        return participant;
    }

    public void setParticipant(Employee participant) {
        this.participant = participant;
    }

    public Shcedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Shcedule schedule) {
        this.schedule = schedule;
    }

    @XmlTransient
    public List<AnswerEssay> getAnswerEssayList() {
        return answerEssayList;
    }

    public void setAnswerEssayList(List<AnswerEssay> answerEssayList) {
        this.answerEssayList = answerEssayList;
    }

    @XmlTransient
    public List<AnswerPg> getAnswerPgList() {
        return answerPgList;
    }

    public void setAnswerPgList(List<AnswerPg> answerPgList) {
        this.answerPgList = answerPgList;
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
        if (!(object instanceof Form)) {
            return false;
        }
        Form other = (Form) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Form[ id=" + id + " ]";
    }
    
}
