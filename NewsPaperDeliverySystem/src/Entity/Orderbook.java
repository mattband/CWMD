/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "ORDERBOOK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderbook.findAll", query = "SELECT o FROM Orderbook o"),
    @NamedQuery(name = "Orderbook.findByOrderid", query = "SELECT o FROM Orderbook o WHERE o.orderid = :orderid"),
    @NamedQuery(name = "Orderbook.findByOrderdate", query = "SELECT o FROM Orderbook o WHERE o.orderdate = :orderdate"),
    @NamedQuery(name = "Orderbook.findByTotalamount", query = "SELECT o FROM Orderbook o WHERE o.totalamount = :totalamount")})
public class Orderbook implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ORDERID")
    private String orderid;
    @Column(name = "ORDERDATE")
    @Temporal(TemporalType.DATE)
    private Date orderdate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTALAMOUNT")
    private Double totalamount;
    @JoinColumn(name = "CUSTOMERID", referencedColumnName = "CUSTOMERID")
    @ManyToOne
    private Customer customerid;
    @JoinColumn(name = "PUBLICATIONID", referencedColumnName = "PUBLICATIONID")
    @ManyToOne
    private Publication publicationid;
    @OneToMany(mappedBy = "orderid")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(mappedBy = "orderid")
    private Collection<Deliverydocket> deliverydocketCollection;

    public Orderbook() {
    }

    public Orderbook(String orderid) {
        this.orderid = orderid;
    }

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public Publication getPublicationid() {
        return publicationid;
    }

    public void setPublicationid(Publication publicationid) {
        this.publicationid = publicationid;
    }

    @XmlTransient
    public Collection<Invoice> getInvoiceCollection() {
        return invoiceCollection;
    }

    public void setInvoiceCollection(Collection<Invoice> invoiceCollection) {
        this.invoiceCollection = invoiceCollection;
    }

    @XmlTransient
    public Collection<Deliverydocket> getDeliverydocketCollection() {
        return deliverydocketCollection;
    }

    public void setDeliverydocketCollection(Collection<Deliverydocket> deliverydocketCollection) {
        this.deliverydocketCollection = deliverydocketCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderid != null ? orderid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orderbook)) {
            return false;
        }
        Orderbook other = (Orderbook) object;
        if ((this.orderid == null && other.orderid != null) || (this.orderid != null && !this.orderid.equals(other.orderid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Orderbook[ orderid=" + orderid + " ]";
    }
    
}