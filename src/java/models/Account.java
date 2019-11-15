/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aseprudin
 */
@Entity
@Table(name = "ACCOUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a")
    , @NamedQuery(name = "Account.findByEmployee", query = "SELECT a FROM Account a WHERE a.employee = :employee")
    , @NamedQuery(name = "Account.findByPassword", query = "SELECT a FROM Account a WHERE a.password = :password")
    , @NamedQuery(name = "Account.findByToken", query = "SELECT a FROM Account a WHERE a.token = :token")
    , @NamedQuery(name = "Account.findByExpiredDate", query = "SELECT a FROM Account a WHERE a.expiredDate = :expiredDate")})
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE")
    private Integer employee;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "EXPIRED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expiredDate;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee1;
    @JoinColumn(name = "STATUS", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Status status;

    public Account() {
    }

    public Account(Integer employee, String password, String token, Date expiredDate, Status status) {
        this.employee = employee;
        this.password = password;
        this.token = token;
        this.expiredDate = expiredDate;
        this.status = status;
    }
    

    public Account(Integer employee) {
        this.employee = employee;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employee != null ? employee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Account)) {
            return false;
        }
        Account other = (Account) object;
        if ((this.employee == null && other.employee != null) || (this.employee != null && !this.employee.equals(other.employee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Account[ employee=" + employee + " ]";
    }
    
}
