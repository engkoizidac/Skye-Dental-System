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
@Table(name = "medical_dental_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedicalDentalHistory.findAll", query = "SELECT m FROM MedicalDentalHistory m")
    , @NamedQuery(name = "MedicalDentalHistory.findByMDHId", query = "SELECT m FROM MedicalDentalHistory m WHERE m.mDHId = :mDHId")
    , @NamedQuery(name = "MedicalDentalHistory.findByDescription", query = "SELECT m FROM MedicalDentalHistory m WHERE m.description = :description")
    , @NamedQuery(name = "MedicalDentalHistory.findByCategoryId", query = "SELECT m FROM MedicalDentalHistory m WHERE m.categoryId = :categoryId")})
public class MedicalDentalHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MDHId")
    private Integer mDHId;
    @Basic(optional = false)
    @Column(name = "Description")
    private String description;
    @Column(name = "CategoryId")
    private Integer categoryId;

    public MedicalDentalHistory() {
    }

    public MedicalDentalHistory(Integer mDHId) {
        this.mDHId = mDHId;
    }

    public MedicalDentalHistory(Integer mDHId, String description) {
        this.mDHId = mDHId;
        this.description = description;
    }

    public Integer getMDHId() {
        return mDHId;
    }

    public void setMDHId(Integer mDHId) {
        this.mDHId = mDHId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mDHId != null ? mDHId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedicalDentalHistory)) {
            return false;
        }
        MedicalDentalHistory other = (MedicalDentalHistory) object;
        if ((this.mDHId == null && other.mDHId != null) || (this.mDHId != null && !this.mDHId.equals(other.mDHId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.MedicalDentalHistory[ mDHId=" + mDHId + " ]";
    }
    
}
