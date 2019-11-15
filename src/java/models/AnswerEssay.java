/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ANSWER_ESSAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnswerEssay.findAll", query = "SELECT a FROM AnswerEssay a")
    , @NamedQuery(name = "AnswerEssay.findById", query = "SELECT a FROM AnswerEssay a WHERE a.id = :id")
    , @NamedQuery(name = "AnswerEssay.findByDetail", query = "SELECT a FROM AnswerEssay a WHERE a.detail = :detail")})
public class AnswerEssay implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private BigDecimal id;
    @Column(name = "DETAIL")
    private String detail;
    @JoinColumn(name = "FORM", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Form form;
    @JoinColumn(name = "QUESTION", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    public AnswerEssay() {
    }

    public AnswerEssay(BigDecimal id) {
        this.id = id;
    }

    public AnswerEssay(BigDecimal id, String detail, Form form, Question question) {
        this.id = id;
        this.detail = detail;
        this.form = form;
        this.question = question;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
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
        if (!(object instanceof AnswerEssay)) {
            return false;
        }
        AnswerEssay other = (AnswerEssay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.AnswerEssay[ id=" + id + " ]";
    }
    
}
