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
@Table(name = "tooth_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ToothStatus.findAll", query = "SELECT t FROM ToothStatus t")
    , @NamedQuery(name = "ToothStatus.findByToothStatusId", query = "SELECT t FROM ToothStatus t WHERE t.toothStatusId = :toothStatusId")
    , @NamedQuery(name = "ToothStatus.findByCode", query = "SELECT t FROM ToothStatus t WHERE t.code = :code")
    , @NamedQuery(name = "ToothStatus.findByDescription", query = "SELECT t FROM ToothStatus t WHERE t.description = :description")
    , @NamedQuery(name = "ToothStatus.findByToothStatusTypeId", query = "SELECT t FROM ToothStatus t WHERE t.toothStatusTypeId = :toothStatusTypeId")})
public class ToothStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ToothStatusId")
    private Integer toothStatusId;
    @Column(name = "Code")
    private String code;
    @Column(name = "Description")
    private String description;
    @Column(name = "ToothStatusTypeId")
    private Integer toothStatusTypeId;

    public ToothStatus() {
    }

    public ToothStatus(Integer toothStatusId) {
        this.toothStatusId = toothStatusId;
    }

    public Integer getToothStatusId() {
        return toothStatusId;
    }

    public void setToothStatusId(Integer toothStatusId) {
        this.toothStatusId = toothStatusId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getToothStatusTypeId() {
        return toothStatusTypeId;
    }

    public void setToothStatusTypeId(Integer toothStatusTypeId) {
        this.toothStatusTypeId = toothStatusTypeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toothStatusId != null ? toothStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ToothStatus)) {
            return false;
        }
        ToothStatus other = (ToothStatus) object;
        if ((this.toothStatusId == null && other.toothStatusId != null) || (this.toothStatusId != null && !this.toothStatusId.equals(other.toothStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.model.ToothStatus[ toothStatusId=" + toothStatusId + " ]";
    }
    
}
