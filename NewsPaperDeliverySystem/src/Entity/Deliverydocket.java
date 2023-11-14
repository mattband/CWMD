/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "DELIVERYDOCKET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deliverydocket.findAll", query = "SELECT d FROM Deliverydocket d"),
    @NamedQuery(name = "Deliverydocket.findByDeliverydocketid", query = "SELECT d FROM Deliverydocket d WHERE d.deliverydocketid = :deliverydocketid"),
    @NamedQuery(name = "Deliverydocket.findByDeliverystatus", query = "SELECT d FROM Deliverydocket d WHERE d.deliverystatus = :deliverystatus")})
public class Deliverydocket implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "DELIVERYDOCKETID")
    private Integer deliverydocketid;
    @Basic(optional = false)
    @Column(name = "DELIVERYSTATUS")
    private String deliverystatus;
    @OneToMany(mappedBy = "deliverydocket")
    private Collection<Deliveryperson> deliverypersonCollection;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne
    private Customer customerid;
    @JoinColumn(name = "ORDERID", referencedColumnName = "ORDERID")
    @ManyToOne
    private Orderbook orderid;
    @JoinColumn(name = "PUBLICATIONID", referencedColumnName = "PUBLICATIONID")
    @ManyToOne
    private Publication publicationid;

    public Deliverydocket() {
    }

    public Deliverydocket(Integer deliverydocketid) {
        this.deliverydocketid = deliverydocketid;
    }

    public Deliverydocket(Integer deliverydocketid, String deliverystatus) {
        this.deliverydocketid = deliverydocketid;
        this.deliverystatus = deliverystatus;
    }

    public Integer getDeliverydocketid() {
        return deliverydocketid;
    }

    public void setDeliverydocketid(Integer deliverydocketid) {
        this.deliverydocketid = deliverydocketid;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    @XmlTransient
    public Collection<Deliveryperson> getDeliverypersonCollection() {
        return deliverypersonCollection;
    }

    public void setDeliverypersonCollection(Collection<Deliveryperson> deliverypersonCollection) {
        this.deliverypersonCollection = deliverypersonCollection;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Orderbook getOrderid() {
        return orderid;
    }

    public void setOrderid(Orderbook orderid) {
        this.orderid = orderid;
    }

    public Publication getPublicationid() {
        return publicationid;
    }

    public void setPublicationid(Publication publicationid) {
        this.publicationid = publicationid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deliverydocketid != null ? deliverydocketid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deliverydocket)) {
            return false;
        }
        Deliverydocket other = (Deliverydocket) object;
        if ((this.deliverydocketid == null && other.deliverydocketid != null) || (this.deliverydocketid != null && !this.deliverydocketid.equals(other.deliverydocketid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Deliverydocket[ deliverydocketid=" + deliverydocketid + " ]";
    }
    
}
