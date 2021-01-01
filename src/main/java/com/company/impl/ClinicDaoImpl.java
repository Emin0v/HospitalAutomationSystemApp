package com.company.impl;

import com.company.helper.DBConnection;
import com.company.inter.ClinicDaoInter;
import com.company.model.Clinic;
import com.company.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Eminov
 */
public class ClinicDaoImpl implements ClinicDaoInter {

    DBConnection conn = DBConnection.instance();
    Statement stmt = null;
    PreparedStatement prstmt = null;
    ResultSet rs = null;

    @Override
    public ArrayList<Clinic> getList() {
        ArrayList<Clinic> list = new ArrayList<>();
        Connection c = conn.dbConn();
        Clinic cl;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM clinic");
            while (rs.next()) {
                cl = new Clinic();
                cl.setId(rs.getInt("id"));
                cl.setName(rs.getString("name"));
                list.add(cl);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<User> getClinicDoctorList(int clinic_id) {
        ArrayList<User> list = new ArrayList<>();
        User user;
        try {
            Connection c = conn.dbConn();
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT u.id , u.username , u.type , u.password , u.`name` FROM `worker` w LEFT JOIN `user` u ON w.user_id=u.id WHERE clinic_id= " + clinic_id);
            while (rs.next()) {
                user = new User(rs.getInt("u.id"), rs.getString("u.username"), rs.getString("u.password"), rs.getString("u.name"), rs.getString("u.type"));
                list.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public Clinic getFetch(Integer id) {
        Connection c = conn.dbConn();
        Clinic cl = null;
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM clinic WHERE id=" + id);
            while (rs.next()) {
                cl = new Clinic(rs.getInt("id"), rs.getString("name"));
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cl;
    }

    public boolean addClinic(String name) {
        Connection c = conn.dbConn();
        String query = "insert into clinic (name) values(?)";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, name);
            prstmt.executeUpdate();
            key = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean deleteClinic(Integer id) {
        Connection c = conn.dbConn();
        String query = "delete from clinic where id=?";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setInt(1, id);
            prstmt.executeUpdate();
            key = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean updateClinic(Integer id, String name) {
        Connection c = conn.dbConn();
        String query = "update clinic set name=? where id=?";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, name);
            prstmt.setInt(2, id);
            prstmt.executeUpdate();
            key = true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return key;
    }
}
