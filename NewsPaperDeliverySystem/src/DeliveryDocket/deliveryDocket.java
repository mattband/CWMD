package DeliveryDocket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

public class DeliveryDocket {
    private int deliverydocketId;
    private String deliveryStatus;
//    private Customer customerId;
//    private Orderbook orderBookId;
//    private Publication publicationId;
    
    public DeliveryDocket() {}
    
    public DeliveryDocket(int deliveryDocketId){
        this.deliverydocketId = deliveryDocketId;
    }
    
    public int getDeliveryDocketId(){
        return deliverydocketId;
    }

    public void setDeliverydocketid(Integer deliverydocketid) {
        this.deliverydocketId = deliverydocketid;
    }

    public String getDeliverystatus() {
        return deliveryStatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliveryStatus = deliverystatus;
    }

//    public Customer getCustomerid() {
//        return customerId;
//    }
//
//    public void setCustomerid(Customer customerid) {
//        this.customerId = customerid;
//    }
//
//    public Orderbook getOrderid() {
//        return orderBookId;
//    }
//
//    public void setOrderid(Orderbook orderid) {
//        this.orderBookId = orderid;
//    }
//
//    public Publication getPublicationid() {
//        return publicationId;
//    }
//
//    public void setPublicationid(Publication publicationid) {
//        this.publicationId = publicationid;
//    }
}

