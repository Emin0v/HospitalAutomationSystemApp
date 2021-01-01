/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

import com.company.helper.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Eminov
 */
@Entity
@Table(name = "clinic")

public class Clinic implements Serializable {

//    DBConnection conn = new DBConnection();
//    Statement stmt = null;
//    PreparedStatement prstmt = null;
//    ResultSet rs = null;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

//    public ArrayList<Clinic> getList() throws SQLException {
//        ArrayList<Clinic> list = new ArrayList<>();
//        Connection c = conn.dbConn();
//        Clinic cl;
//        try {
//            stmt = c.createStatement();
//            rs = stmt.executeQuery("SELECT * FROM clinic");
//            while (rs.next()) {
//                cl = new Clinic();
//                cl.setId(rs.getInt("id"));
//                cl.setName(rs.getString("name"));
//                list.add(cl);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            c.close();
//        }
//        return list;
//    }
//    
//    public Clinic getFetch(Integer id) throws Exception{
//        Connection c = conn.dbConn();
//        Clinic cl=null;
//        try{
//            stmt = c.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM clinic WHERE id="+id);
//            while(rs.next()){
//                cl = new Clinic(rs.getInt("id"), rs.getString("name"));
//                break;
//            }
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return cl;
//    }
//
//    public boolean addClinic(String name) throws SQLException {
//        Connection c = conn.dbConn();
//        String query = "insert into clinic (name) values(?)";
//        boolean key = false;
//        try {
//            prstmt = c.prepareStatement(query);
//            prstmt.setString(1, name);
//            prstmt.executeUpdate();
//            key = true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            c.close();
//        }
//        return key;
//    }
//
//    public boolean deleteClinic(Integer id) throws SQLException {
//        Connection c = conn.dbConn();
//        String query = "delete from clinic where id=?";
//        boolean key = false;
//        try {
//            prstmt = c.prepareStatement(query);
//            prstmt.setInt(1, id);
//            prstmt.executeUpdate();
//            key = true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }finally{
//            c.close();
//        }
//        return key;
//    }
//    
//    public boolean updateClinic(Integer id , String name ) throws SQLException{
//        Connection c = conn.dbConn();
//        String query = "update clinic set name=? where id=?";
//        boolean key=false;
//        try{
//        prstmt = c.prepareStatement(query);
//        prstmt.setString(1, name);
//        prstmt.setInt(2, id);
//        prstmt.executeUpdate();
//        key=true;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return key;
//    }

    public Clinic() {
    }

    public Clinic(Integer id) {
        this.id = id;
    }

    public Clinic(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Clinic)) {
            return false;
        }
        Clinic other = (Clinic) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.company.model.Clinic[ id=" + id + " ]";
    }

}
