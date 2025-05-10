/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "patient_attachment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PatientAttachment.findAll", query = "SELECT p FROM PatientAttachment p")
    , @NamedQuery(name = "PatientAttachment.findByAttachmentId", query = "SELECT p FROM PatientAttachment p WHERE p.attachmentId = :attachmentId")
    , @NamedQuery(name = "PatientAttachment.findByTransDate", query = "SELECT p FROM PatientAttachment p WHERE p.transDate = :transDate")
    , @NamedQuery(name = "PatientAttachment.findByAttachDescription", query = "SELECT p FROM PatientAttachment p WHERE p.attachDescription = :attachDescription")
    , @NamedQuery(name = "PatientAttachment.findByPatientId", query = "SELECT p FROM PatientAttachment p WHERE p.patientId = :patientId")})
public class PatientAttachment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "AttachmentId")
    private Integer attachmentId;
    @Basic(optional = false)
    @Column(name = "TransDate")
    @Temporal(TemporalType.DATE)
    private Date transDate;
    @Basic(optional = false)
    @Column(name = "AttachDescription")
    private String attachDescription;
    @Basic(optional = false)
    @Column(name = "PatientId")
    private int patientId;

    public PatientAttachment() {
    }

    public PatientAttachment(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public PatientAttachment(Integer attachmentId, Date transDate, String attachDescription, int patientId) {
        this.attachmentId = attachmentId;
        this.transDate = transDate;
        this.attachDescription = attachDescription;
        this.patientId = patientId;
    }

    public Integer getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Integer attachmentId) {
        this.attachmentId = attachmentId;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getAttachDescription() {
        return attachDescription;
    }

    public void setAttachDescription(String attachDescription) {
        this.attachDescription = attachDescription;
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
        hash += (attachmentId != null ? attachmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PatientAttachment)) {
            return false;
        }
        PatientAttachment other = (PatientAttachment) object;
        if ((this.attachmentId == null && other.attachmentId != null) || (this.attachmentId != null && !this.attachmentId.equals(other.attachmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.PatientAttachment[ attachmentId=" + attachmentId + " ]";
    }
    
}
