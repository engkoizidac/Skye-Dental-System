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
@Table(name = "patient_mdh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientMdh.findAll", query = "SELECT p FROM PatientMdh p")
    , @NamedQuery(name = "PatientMdh.findByPatientMDHId", query = "SELECT p FROM PatientMdh p WHERE p.patientMDHId = :patientMDHId")
    , @NamedQuery(name = "PatientMdh.findByMDHId", query = "SELECT p FROM PatientMdh p WHERE p.mDHId = :mDHId")
    , @NamedQuery(name = "PatientMdh.findByPatientId", query = "SELECT p FROM PatientMdh p WHERE p.patientId = :patientId")})
public class PatientMdh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PatientMDHId")
    private Integer patientMDHId;
    @Basic(optional = false)
    @Column(name = "MDHId")
    private int mDHId;
    @Basic(optional = false)
    @Column(name = "PatientId")
    private int patientId;

    public PatientMdh() {
    }

    public PatientMdh(Integer patientMDHId) {
        this.patientMDHId = patientMDHId;
    }

    public PatientMdh(Integer patientMDHId, int mDHId, int patientId) {
        this.patientMDHId = patientMDHId;
        this.mDHId = mDHId;
        this.patientId = patientId;
    }

    public Integer getPatientMDHId() {
        return patientMDHId;
    }

    public void setPatientMDHId(Integer patientMDHId) {
        this.patientMDHId = patientMDHId;
    }

    public int getMDHId() {
        return mDHId;
    }

    public void setMDHId(int mDHId) {
        this.mDHId = mDHId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientMDHId != null ? patientMDHId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientMdh)) {
            return false;
        }
        PatientMdh other = (PatientMdh) object;
        if ((this.patientMDHId == null && other.patientMDHId != null) || (this.patientMDHId != null && !this.patientMDHId.equals(other.patientMDHId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.controller.PatientMdh[ patientMDHId=" + patientMDHId + " ]";
    }
    
}
