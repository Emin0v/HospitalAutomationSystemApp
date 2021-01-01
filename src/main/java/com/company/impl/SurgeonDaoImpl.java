package com.company.impl;

import com.company.helper.DBConnection;
import com.company.inter.SurgeonDaoInter;
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
public class SurgeonDaoImpl implements SurgeonDaoInter {

    DBConnection conn = DBConnection.instance();
    Connection c = conn.dbConn();
    Statement stmt = null;
    PreparedStatement prstmt = null;
    ResultSet rs = null;

    @Override
    public ArrayList<User> getDoctorList() {
        ArrayList<User> list = new ArrayList<>();
        User user;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `user` WHERE type='doctor';");
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("type"));
                list.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public ArrayList<User> getClinicDoctorList(int clinic_id) {
        ArrayList<User> list = new ArrayList<>();
        User user;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT u.id , u.username , u.type , u.password , u.`name` FROM `worker` w LEFT JOIN `user` u ON w.user_id=u.id WHERE clinic_id= "+clinic_id);
            while (rs.next()) {
                user = new User(rs.getInt("u.id"), rs.getString("u.username"), rs.getString("u.password"), rs.getString("u.name"), rs.getString("u.type"));
                list.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addDoctor(String username, String password, String name) {
        String query = "insert into user (username,password,name,type) values(?,?,?,?)";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, username);
            prstmt.setString(2, password);
            prstmt.setString(3, name);
            prstmt.setString(4, "doctor");
            prstmt.executeUpdate();
            key = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        String query = "delete from user where id=?";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setInt(1, id);
            prstmt.executeUpdate();
            key = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean updateDoctor(Integer id, String username, String password, String name) {
        String query = "update user set name=? , username=? , password=?  where id=?";
        boolean key = false;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, name);
            prstmt.setString(2, username);
            prstmt.setString(3, password);
            prstmt.setInt(4, id);
            prstmt.executeUpdate();
            key = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return key;
    }

    @Override
    public boolean addWorker(int user_id, int clinic_id) {
        String query = "insert into worker (user_id , clinic_id) values(?,?)";
        boolean key = false;
        int count = 0;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from worker where user_id=" + user_id + " and clinic_id=" + clinic_id);
            while (rs.next()) {
                count++;
            }
            if (count == 0) {
                prstmt = c.prepareStatement(query);
                prstmt.setInt(1, user_id);
                prstmt.setInt(2, clinic_id);
                prstmt.executeUpdate();
            }
            key = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return key;
    }
}
