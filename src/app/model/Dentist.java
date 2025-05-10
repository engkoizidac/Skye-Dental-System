/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EngkoiZidac
 */
@Entity
@Table(name = "dentist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dentist.findAll", query = "SELECT d FROM Dentist d")
    , @NamedQuery(name = "Dentist.findByDentistId", query = "SELECT d FROM Dentist d WHERE d.dentistId = :dentistId")
    , @NamedQuery(name = "Dentist.findByName", query = "SELECT d FROM Dentist d WHERE d.name = :name")
    , @NamedQuery(name = "Dentist.findByAddress", query = "SELECT d FROM Dentist d WHERE d.address = :address")
    , @NamedQuery(name = "Dentist.findByContactNo", query = "SELECT d FROM Dentist d WHERE d.contactNo = :contactNo")
    , @NamedQuery(name = "Dentist.findByEmailAddress", query = "SELECT d FROM Dentist d WHERE d.emailAddress = :emailAddress")})
public class Dentist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DentistId")
    private Integer dentistId;
    @Column(name = "Name")
    private String name;
    @Column(name = "Address")
    private String address;
    @Column(name = "ContactNo")
    private String contactNo;
    @Column(name = "EmailAddress")
    private String emailAddress;

    public Dentist() {
    }

    public Dentist(Integer dentistId) {
        this.dentistId = dentistId;
    }

    public Integer getDentistId() {
        return dentistId;
    }

    public void setDentistId(Integer dentistId) {
        this.dentistId = dentistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dentistId != null ? dentistId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dentist)) {
            return false;
        }
        Dentist other = (Dentist) object;
        if ((this.dentistId == null && other.dentistId != null) || (this.dentistId != null && !this.dentistId.equals(other.dentistId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Dentist[ dentistId=" + dentistId + " ]";
    }
    
}
