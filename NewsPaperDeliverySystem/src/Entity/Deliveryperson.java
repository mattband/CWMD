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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Deliveryperson.findByDeliveryphonenumber", query = "SELECT d FROM Deliveryperson d WHERE d.deliveryphonenumber = :deliveryphonenumber"),
    @NamedQuery(name = "Deliveryperson.findByArea", query = "SELECT d FROM Deliveryperson d WHERE d.area = :area")})
public class Deliveryperson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DELIVERYMANID")
    private String deliverymanid;
    @Basic(optional = false)
    @Column(name = "DELIVERYPHONENUMBER")
    private String deliveryphonenumber;
    @Basic(optional = false)
    @Column(name = "AREA")
    private String area;
    @JoinColumn(name = "DELIVERYDOCKET", referencedColumnName = "DELIVERYDOCKETID")
    @ManyToOne
    private Deliverydocket deliverydocket;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;

    public Deliveryperson() {
    }

    public Deliveryperson(String deliverymanid) {
        this.deliverymanid = deliverymanid;
    }

    public Deliveryperson(String deliverymanid, String deliveryphonenumber, String area) {
        this.deliverymanid = deliverymanid;
        this.deliveryphonenumber = deliveryphonenumber;
        this.area = area;
    }

    public String getDeliverymanid() {
        return deliverymanid;
    }

    public void setDeliverymanid(String deliverymanid) {
        this.deliverymanid = deliverymanid;
    }

    public String getDeliveryphonenumber() {
        return deliveryphonenumber;
    }

    public void setDeliveryphonenumber(String deliveryphonenumber) {
        this.deliveryphonenumber = deliveryphonenumber;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Deliverydocket getDeliverydocket() {
        return deliverydocket;
    }

    public void setDeliverydocket(Deliverydocket deliverydocket) {
        this.deliverydocket = deliverydocket;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
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
