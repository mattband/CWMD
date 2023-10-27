/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "DELIVERYPERSON")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliveryperson.findAll", query = "SELECT d FROM Deliveryperson d"),
    @NamedQuery(name = "Deliveryperson.findByDeliverymanid", query = "SELECT d FROM Deliveryperson d WHERE d.deliverymanid = :deliverymanid"),
    @NamedQuery(name = "Deliveryperson.findByDeliverydocket", query = "SELECT d FROM Deliveryperson d WHERE d.deliverydocket = :deliverydocket"),
    @NamedQuery(name = "Deliveryperson.findByArea", query = "SELECT d FROM Deliveryperson d WHERE d.area = :area")})
public class Deliveryperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DELIVERYMANID")
    private String deliverymanid;
    @Basic(optional = false)
    @Column(name = "DELIVERYDOCKET")
    private String deliverydocket;
    @Basic(optional = false)
    @Column(name = "AREA")
    private String area;

    public Deliveryperson() {
    }

    public Deliveryperson(String deliverymanid) {
        this.deliverymanid = deliverymanid;
    }

    public Deliveryperson(String deliverymanid, String deliverydocket, String area) {
        this.deliverymanid = deliverymanid;
        this.deliverydocket = deliverydocket;
        this.area = area;
    }

    public String getDeliverymanid() {
        return deliverymanid;
    }

    public void setDeliverymanid(String deliverymanid) {
        this.deliverymanid = deliverymanid;
    }

    public String getDeliverydocket() {
        return deliverydocket;
    }

    public void setDeliverydocket(String deliverydocket) {
        this.deliverydocket = deliverydocket;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverymanid != null ? deliverymanid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliveryperson)) {
            return false;
        }
        Deliveryperson other = (Deliveryperson) object;
        if ((this.deliverymanid == null && other.deliverymanid != null) || (this.deliverymanid != null && !this.deliverymanid.equals(other.deliverymanid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Deliveryperson[ deliverymanid=" + deliverymanid + " ]";
    }
    
}
