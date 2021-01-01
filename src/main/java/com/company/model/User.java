package com.company.model;

import com.company.helper.DBConnection;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Eminov
 */
@Entity
@Table(name = "user")

public class User implements Serializable {

    @OneToMany(mappedBy = "doctorId")
    private List<Appointment> appointmentList;
    @OneToMany(mappedBy = "patientId")
    private List<Appointment> appointmentList1;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;

//    DBConnection conn = new DBConnection();
    
    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }
    
    public User(Integer id , String name) {
        this.id = id;
        this.name=name;
    }

    public User(Integer id, String username, String password,String name ,String type) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name=name;
        this.type=type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.model.User[ id=" + id + " ]";
    }

    @XmlTransient
    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    @XmlTransient
    public List<Appointment> getAppointmentList1() {
        return appointmentList1;
    }

    public void setAppointmentList1(List<Appointment> appointmentList1) {
        this.appointmentList1 = appointmentList1;
    }
    
}
