package com.company.impl;

import com.company.helper.DBConnection;
import com.company.inter.DoctorDaoInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Eminov
 */
public class DoctorDaoImpl implements DoctorDaoInter {

    DBConnection conn = DBConnection.instance();
    Connection c = conn.dbConn();
    Statement stmt = null;
    PreparedStatement prstmt = null;

    @Override
    public boolean addWhour(int doctor_id, String doctor_name, String wdate) {
        int count = 0;

        String query = "Insert into workhour (doctor_id , doctor_name , work_date) values (?,?,?)";
        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from workhour where status='a' AND doctor_id=" + doctor_id + " AND work_date='" + wdate + "'");
            while (rs.next()) {
                count++;
                break;
            }
            if (count == 0) {
                prstmt = c.prepareStatement(query);
                prstmt.setInt(1, doctor_id);
                prstmt.setString(2, doctor_name);
                prstmt.setString(3, wdate);
                prstmt.executeUpdate();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteWhour(Integer id) {
        String query = "delete from workhour where id=?";
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
}
