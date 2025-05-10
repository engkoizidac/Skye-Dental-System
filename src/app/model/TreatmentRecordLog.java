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
@Table(name = "treatment_record_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TreatmentRecordLog.findAll", query = "SELECT t FROM TreatmentRecordLog t")
    , @NamedQuery(name = "TreatmentRecordLog.findByTRLogId", query = "SELECT t FROM TreatmentRecordLog t WHERE t.tRLogId = :tRLogId")
    , @NamedQuery(name = "TreatmentRecordLog.findByTreatmentDate", query = "SELECT t FROM TreatmentRecordLog t WHERE t.treatmentDate = :treatmentDate")
    , @NamedQuery(name = "TreatmentRecordLog.findByTransDate", query = "SELECT t FROM TreatmentRecordLog t WHERE t.transDate = :transDate")
    , @NamedQuery(name = "TreatmentRecordLog.findByToothNos", query = "SELECT t FROM TreatmentRecordLog t WHERE t.toothNos = :toothNos")
    , @NamedQuery(name = "TreatmentRecordLog.findByTProcedure", query = "SELECT t FROM TreatmentRecordLog t WHERE t.tProcedure = :tProcedure")
    , @NamedQuery(name = "TreatmentRecordLog.findByDentistId", query = "SELECT t FROM TreatmentRecordLog t WHERE t.dentistId = :dentistId")
    , @NamedQuery(name = "TreatmentRecordLog.findByClinicId", query = "SELECT t FROM TreatmentRecordLog t WHERE t.clinicId = :clinicId")
    , @NamedQuery(name = "TreatmentRecordLog.findByAmountCharged", query = "SELECT t FROM TreatmentRecordLog t WHERE t.amountCharged = :amountCharged")
    , @NamedQuery(name = "TreatmentRecordLog.findByPatientId", query = "SELECT t FROM TreatmentRecordLog t WHERE t.patientId = :patientId")
    , @NamedQuery(name = "TreatmentRecordLog.findByNote", query = "SELECT t FROM TreatmentRecordLog t WHERE t.note = :note")
    , @NamedQuery(name = "TreatmentRecordLog.findByBloodPressure", query = "SELECT t FROM TreatmentRecordLog t WHERE t.bloodPressure = :bloodPressure")
    , @NamedQuery(name = "TreatmentRecordLog.findByTRId", query = "SELECT t FROM TreatmentRecordLog t WHERE t.tRId = :tRId")})
public class TreatmentRecordLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "TRLogId")
    private Integer tRLogId;
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
    @Column(name = "TRId")
    private Integer tRId;

    public TreatmentRecordLog() {
    }

    public TreatmentRecordLog(Integer tRLogId) {
        this.tRLogId = tRLogId;
    }

    public Integer getTRLogId() {
        return tRLogId;
    }

    public void setTRLogId(Integer tRLogId) {
        this.tRLogId = tRLogId;
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

    public Integer getTRId() {
        return tRId;
    }

    public void setTRId(Integer tRId) {
        this.tRId = tRId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tRLogId != null ? tRLogId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TreatmentRecordLog)) {
            return false;
        }
        TreatmentRecordLog other = (TreatmentRecordLog) object;
        if ((this.tRLogId == null && other.tRLogId != null) || (this.tRLogId != null && !this.tRLogId.equals(other.tRLogId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.TreatmentRecordLog[ tRLogId=" + tRLogId + " ]";
    }
    
}
