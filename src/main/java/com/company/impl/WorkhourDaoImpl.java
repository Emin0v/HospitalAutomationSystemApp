package com.company.impl;

import com.company.helper.DBConnection;
import com.company.inter.WorkhourDaoInter;
import com.company.model.User;
import com.company.model.Workhour;
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
public class WorkhourDaoImpl implements WorkhourDaoInter {

    DBConnection conn = DBConnection.instance();
    Connection c = conn.dbConn();
    Statement stmt = null;
    PreparedStatement prstmt = null;
    ResultSet rs = null;

    @Override
    public ArrayList<Workhour> getWorkhourList(int doctor_id) {
        ArrayList<Workhour> list = new ArrayList<>();
        Workhour whour;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM `workhour` WHERE status='a' AND doctor_id=" + doctor_id);
            while (rs.next()) {
                whour = new Workhour();
                whour.setId(rs.getInt("id"));
                whour.setDoctorId(rs.getInt("doctor_id"));
                whour.setDoctorName(rs.getString("doctor_name"));
                whour.setStatus(rs.getString("status"));
                whour.setWorkDate(rs.getString("work_date"));
                list.add(whour);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updatePassiveWorkhourStatus(int doctor_id, String date) {
        String query = "update workhour set status=? where doctor_id=? AND work_date=? ";
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, "p");
            prstmt.setInt(2, doctor_id);
            prstmt.setString(3, date);
            prstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateActiveWorkhourStatus(int doctor_id, String date) {
        String query = "update workhour set status=? where doctor_id=? AND work_date=? ";
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setString(1, "a");
            prstmt.setInt(2, doctor_id);
            prstmt.setString(3, date);
            prstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
