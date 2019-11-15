/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aseprudin
 */
@Entity
@Table(name = "ANSWER_PG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerPg.findAll", query = "SELECT a FROM AnswerPg a")
    , @NamedQuery(name = "AnswerPg.findById", query = "SELECT a FROM AnswerPg a WHERE a.id = :id")
    , @NamedQuery(name = "AnswerPg.findByScala", query = "SELECT a FROM AnswerPg a WHERE a.scala = :scala")
    , @NamedQuery(name = "AnswerPg.findByNote", query = "SELECT a FROM AnswerPg a WHERE a.note = :note")})
public class AnswerPg implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "SCALA")
    private BigInteger scala;
    @Column(name = "NOTE")
    private String note;
    @JoinColumn(name = "FORM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;
    @JoinColumn(name = "QUESTION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public AnswerPg() {
    }

    public AnswerPg(BigDecimal id) {
        this.id = id;
    }

    public AnswerPg(BigDecimal id, BigInteger scala, String note, Form form, Question question) {
        this.id = id;
        this.scala = scala;
        this.note = note;
        this.form = form;
        this.question = question;
    }
    
    
    
    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigInteger getScala() {
        return scala;
    }

    public void setScala(BigInteger scala) {
        this.scala = scala;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
        if (!(object instanceof AnswerPg)) {
            return false;
        }
        AnswerPg other = (AnswerPg) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AnswerPg[ id=" + id + " ]";
    }
    
}
