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
@Table(name = "patient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Patient.findAll", query = "SELECT p FROM Patient p")
    , @NamedQuery(name = "Patient.findByPatientId", query = "SELECT p FROM Patient p WHERE p.patientId = :patientId")
    , @NamedQuery(name = "Patient.findByName", query = "SELECT p FROM Patient p WHERE p.name = :name")
    , @NamedQuery(name = "Patient.findByNickName", query = "SELECT p FROM Patient p WHERE p.nickName = :nickName")
    , @NamedQuery(name = "Patient.findByGenderID", query = "SELECT p FROM Patient p WHERE p.genderID = :genderID")
    , @NamedQuery(name = "Patient.findByCivilStatusId", query = "SELECT p FROM Patient p WHERE p.civilStatusId = :civilStatusId")
    , @NamedQuery(name = "Patient.findByAddress", query = "SELECT p FROM Patient p WHERE p.address = :address")
    , @NamedQuery(name = "Patient.findByBirthDate", query = "SELECT p FROM Patient p WHERE p.birthDate = :birthDate")
    , @NamedQuery(name = "Patient.findByReligion", query = "SELECT p FROM Patient p WHERE p.religion = :religion")
    , @NamedQuery(name = "Patient.findByOccupation", query = "SELECT p FROM Patient p WHERE p.occupation = :occupation")
    , @NamedQuery(name = "Patient.findByCompanyName", query = "SELECT p FROM Patient p WHERE p.companyName = :companyName")
    , @NamedQuery(name = "Patient.findByOfficeContactNo", query = "SELECT p FROM Patient p WHERE p.officeContactNo = :officeContactNo")
    , @NamedQuery(name = "Patient.findByOfficeAddress", query = "SELECT p FROM Patient p WHERE p.officeAddress = :officeAddress")
    , @NamedQuery(name = "Patient.findByContactNo", query = "SELECT p FROM Patient p WHERE p.contactNo = :contactNo")
    , @NamedQuery(name = "Patient.findByTransDate", query = "SELECT p FROM Patient p WHERE p.transDate = :transDate")
    , @NamedQuery(name = "Patient.findByParentGuardian", query = "SELECT p FROM Patient p WHERE p.parentGuardian = :parentGuardian")
    , @NamedQuery(name = "Patient.findByRemarks", query = "SELECT p FROM Patient p WHERE p.remarks = :remarks")
    , @NamedQuery(name = "Patient.findByOtherAllergies", query = "SELECT p FROM Patient p WHERE p.otherAllergies = :otherAllergies")
    , @NamedQuery(name = "Patient.findByPreviousExtraction", query = "SELECT p FROM Patient p WHERE p.previousExtraction = :previousExtraction")
    , @NamedQuery(name = "Patient.findByMedIntake", query = "SELECT p FROM Patient p WHERE p.medIntake = :medIntake")})
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PatientId")
    private Integer patientId;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Basic(optional = false)
    @Column(name = "NickName")
    private String nickName;
    @Column(name = "GenderID")
    private Integer genderID;
    @Column(name = "CivilStatusId")
    private Integer civilStatusId;
    @Column(name = "Address")
    private String address;
    @Column(name = "BirthDate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "Religion")
    private String religion;
    @Column(name = "Occupation")
    private String occupation;
    @Column(name = "CompanyName")
    private String companyName;
    @Column(name = "OfficeContactNo")
    private String officeContactNo;
    @Column(name = "OfficeAddress")
    private String officeAddress;
    @Column(name = "ContactNo")
    private String contactNo;
    @Column(name = "TransDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transDate;
    @Column(name = "ParentGuardian")
    private String parentGuardian;
    @Column(name = "Remarks")
    private String remarks;
    @Column(name = "OtherAllergies")
    private String otherAllergies;
    @Column(name = "PreviousExtraction")
    private String previousExtraction;
    @Column(name = "MedIntake")
    private String medIntake;

    public Patient() {
    }

    public Patient(Integer patientId) {
        this.patientId = patientId;
    }

    public Patient(Integer patientId, String name, String nickName) {
        this.patientId = patientId;
        this.name = name;
        this.nickName = nickName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGenderID() {
        return genderID;
    }

    public void setGenderID(Integer genderID) {
        this.genderID = genderID;
    }

    public Integer getCivilStatusId() {
        return civilStatusId;
    }

    public void setCivilStatusId(Integer civilStatusId) {
        this.civilStatusId = civilStatusId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOfficeContactNo() {
        return officeContactNo;
    }

    public void setOfficeContactNo(String officeContactNo) {
        this.officeContactNo = officeContactNo;
    }

    public String getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public String getParentGuardian() {
        return parentGuardian;
    }

    public void setParentGuardian(String parentGuardian) {
        this.parentGuardian = parentGuardian;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getOtherAllergies() {
        return otherAllergies;
    }

    public void setOtherAllergies(String otherAllergies) {
        this.otherAllergies = otherAllergies;
    }

    public String getPreviousExtraction() {
        return previousExtraction;
    }

    public void setPreviousExtraction(String previousExtraction) {
        this.previousExtraction = previousExtraction;
    }

    public String getMedIntake() {
        return medIntake;
    }

    public void setMedIntake(String medIntake) {
        this.medIntake = medIntake;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patient)) {
            return false;
        }
        Patient other = (Patient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.Patient[ patientId=" + patientId + " ]";
    }
    
}
