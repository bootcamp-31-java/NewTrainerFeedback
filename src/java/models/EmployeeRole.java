/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aseprudin
 */
@Entity
@Table(name = "EMPLOYEE_ROLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmployeeRole.findAll", query = "SELECT e FROM EmployeeRole e")
    , @NamedQuery(name = "EmployeeRole.findByEmployee", query = "SELECT e FROM EmployeeRole e WHERE e.employee = :employee")})
public class EmployeeRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE")
    private Integer employee;
    @JoinColumn(name = "EMPLOYEE", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private Employee employee1;
    @JoinColumn(name = "ROLE", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;

    public EmployeeRole() {
    }

    public EmployeeRole(Integer employee) {
        this.employee = employee;
    }

    public EmployeeRole(Employee employee1, Role role) {
        this.employee1 = employee1;
        this.role = role;
    }

    public Integer getEmployee() {
        return employee;
    }

    public void setEmployee(Integer employee) {
        this.employee = employee;
    }

    public Employee getEmployee1() {
        return employee1;
    }

    public void setEmployee1(Employee employee1) {
        this.employee1 = employee1;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
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
        if (!(object instanceof EmployeeRole)) {
            return false;
        }
        EmployeeRole other = (EmployeeRole) object;
        if ((this.employee == null && other.employee != null) || (this.employee != null && !this.employee.equals(other.employee))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.EmployeeRole[ employee=" + employee + " ]";
    }
    
}
