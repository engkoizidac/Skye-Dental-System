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
@Table(name = "treatment_record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreatmentRecord.findAll", query = "SELECT t FROM TreatmentRecord t")
    , @NamedQuery(name = "TreatmentRecord.findByTRId", query = "SELECT t FROM TreatmentRecord t WHERE t.tRId = :tRId")
    , @NamedQuery(name = "TreatmentRecord.findByTreatmentDate", query = "SELECT t FROM TreatmentRecord t WHERE t.treatmentDate = :treatmentDate")
    , @NamedQuery(name = "TreatmentRecord.findByTransDate", query = "SELECT t FROM TreatmentRecord t WHERE t.transDate = :transDate")
    , @NamedQuery(name = "TreatmentRecord.findByToothNos", query = "SELECT t FROM TreatmentRecord t WHERE t.toothNos = :toothNos")
    , @NamedQuery(name = "TreatmentRecord.findByTProcedure", query = "SELECT t FROM TreatmentRecord t WHERE t.tProcedure = :tProcedure")
    , @NamedQuery(name = "TreatmentRecord.findByDentistId", query = "SELECT t FROM TreatmentRecord t WHERE t.dentistId = :dentistId")
    , @NamedQuery(name = "TreatmentRecord.findByClinicId", query = "SELECT t FROM TreatmentRecord t WHERE t.clinicId = :clinicId")
    , @NamedQuery(name = "TreatmentRecord.findByAmountCharged", query = "SELECT t FROM TreatmentRecord t WHERE t.amountCharged = :amountCharged")
    , @NamedQuery(name = "TreatmentRecord.findByPatientId", query = "SELECT t FROM TreatmentRecord t WHERE t.patientId = :patientId")
    , @NamedQuery(name = "TreatmentRecord.findByNote", query = "SELECT t FROM TreatmentRecord t WHERE t.note = :note")
    , @NamedQuery(name = "TreatmentRecord.findByBloodPressure", query = "SELECT t FROM TreatmentRecord t WHERE t.bloodPressure = :bloodPressure")})
public class TreatmentRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRId")
    private Integer tRId;
    @Column(name = "TreatmentDate")
    @Temporal(TemporalType.DATE)
    private Date treatmentDate;
    @Column(name = "TransDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Column(name = "ToothNos")
    private String toothNos;
    @Column(name = "TProcedure")
    private String tProcedure;
    @Column(name = "DentistId")
    private Integer dentistId;
    @Column(name = "ClinicId")
    private Integer clinicId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AmountCharged")
    private Double amountCharged;
    @Column(name = "PatientId")
    private Integer patientId;
    @Column(name = "Note")
    private String note;
    @Column(name = "BloodPressure")
    private String bloodPressure;

    public TreatmentRecord() {
    }

    public TreatmentRecord(Integer tRId) {
        this.tRId = tRId;
    }

    public Integer getTRId() {
        return tRId;
    }

    public void setTRId(Integer tRId) {
        this.tRId = tRId;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getToothNos() {
        return toothNos;
    }

    public void setToothNos(String toothNos) {
        this.toothNos = toothNos;
    }

    public String getTProcedure() {
        return tProcedure;
    }

    public void setTProcedure(String tProcedure) {
        this.tProcedure = tProcedure;
    }

    public Integer getDentistId() {
        return dentistId;
    }

    public void setDentistId(Integer dentistId) {
        this.dentistId = dentistId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Double getAmountCharged() {
        return amountCharged;
    }

    public void setAmountCharged(Double amountCharged) {
        this.amountCharged = amountCharged;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tRId != null ? tRId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreatmentRecord)) {
            return false;
        }
        TreatmentRecord other = (TreatmentRecord) object;
        if ((this.tRId == null && other.tRId != null) || (this.tRId != null && !this.tRId.equals(other.tRId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.TreatmentRecord[ tRId=" + tRId + " ]";
    }
    
}
