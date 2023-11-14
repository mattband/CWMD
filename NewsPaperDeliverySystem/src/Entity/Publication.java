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
@Table(name = "PUBLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publication.findAll", query = "SELECT p FROM Publication p"),
    @NamedQuery(name = "Publication.findByPublicationid", query = "SELECT p FROM Publication p WHERE p.publicationid = :publicationid"),
    @NamedQuery(name = "Publication.findByTitle", query = "SELECT p FROM Publication p WHERE p.title = :title"),
    @NamedQuery(name = "Publication.findByPrice", query = "SELECT p FROM Publication p WHERE p.price = :price"),
    @NamedQuery(name = "Publication.findByStockquantity", query = "SELECT p FROM Publication p WHERE p.stockquantity = :stockquantity"),
    @NamedQuery(name = "Publication.findByFrequency", query = "SELECT p FROM Publication p WHERE p.frequency = :frequency")})
public class Publication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PUBLICATIONID")
    private Integer publicationid;
    @Basic(optional = false)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private double price;
    @Basic(optional = false)
    @Column(name = "STOCKQUANTITY")
    private int stockquantity;
    @Basic(optional = false)
    @Column(name = "FREQUENCY")
    private String frequency;
    @OneToMany(mappedBy = "publicationid")
    private Collection<Orderbook> orderbookCollection;
    @OneToMany(mappedBy = "publication")
    private Collection<Customer> customerCollection;
    @OneToMany(mappedBy = "publicationid")
    private Collection<Invoice> invoiceCollection;
    @OneToMany(mappedBy = "publicationid")
    private Collection<Deliverydocket> deliverydocketCollection;

    public Publication() {
    }

    public Publication(Integer publicationid) {
        this.publicationid = publicationid;
    }

    public Publication(Integer publicationid, String title, double price, int stockquantity, String frequency) {
        this.publicationid = publicationid;
        this.title = title;
        this.price = price;
        this.stockquantity = stockquantity;
        this.frequency = frequency;
    }

    public Integer getPublicationid() {
        return publicationid;
    }

    public void setPublicationid(Integer publicationid) {
        this.publicationid = publicationid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStockquantity() {
        return stockquantity;
    }

    public void setStockquantity(int stockquantity) {
        this.stockquantity = stockquantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @XmlTransient
    public Collection<Orderbook> getOrderbookCollection() {
        return orderbookCollection;
    }

    public void setOrderbookCollection(Collection<Orderbook> orderbookCollection) {
        this.orderbookCollection = orderbookCollection;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
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
        hash += (publicationid != null ? publicationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publication)) {
            return false;
        }
        Publication other = (Publication) object;
        if ((this.publicationid == null && other.publicationid != null) || (this.publicationid != null && !this.publicationid.equals(other.publicationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Publication[ publicationid=" + publicationid + " ]";
    }
    
}
