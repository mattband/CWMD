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
@Table(name = "NEWSAGENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Newsagent.findAll", query = "SELECT n FROM Newsagent n"),
    @NamedQuery(name = "Newsagent.findByAgentid", query = "SELECT n FROM Newsagent n WHERE n.agentid = :agentid")})
public class Newsagent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "AGENTID")
    private String agentid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;

    public Newsagent() {
    }

    public Newsagent(String agentid) {
        this.agentid = agentid;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
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
        hash += (agentid != null ? agentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Newsagent)) {
            return false;
        }
        Newsagent other = (Newsagent) object;
        if ((this.agentid == null && other.agentid != null) || (this.agentid != null && !this.agentid.equals(other.agentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Newsagent[ agentid=" + agentid + " ]";
    }
    
}
