package com.company.impl;

import com.company.helper.DBConnection;
import com.company.inter.AppointmentDaoInter;
import com.company.inter.Context;
import com.company.model.Appointment;
import com.company.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.company.inter.PatientDaoInter;
import com.company.inter.WorkhourDaoInter;

/**
 *
 * @author Eminov
 */
public class AppointmentDaoImpl implements AppointmentDaoInter {

    WorkhourDaoInter workhour = Context.instanceWorkhourDao();
    DBConnection conn = DBConnection.instance();
    Connection c = conn.dbConn();
    Statement stmt = null;
    PreparedStatement prstmt = null;
    ResultSet rs = null;

    @Override
    public ArrayList<Appointment> getPatientList(int patient_id) {
        ArrayList<Appointment> list = new ArrayList<>();
        Appointment obj;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery(" SELECT "
                    + "	 ap.* , "
                    + "  u1.NAME as doctor_name , "
                    + "  u2.NAME as patient_name "
                    + "  FROM  "
                    + "	 appointment ap  "
                    + "	 LEFT JOIN USER u1 ON ap.doctor_id = u1.id "
                    + "	 LEFT JOIN USER u2 ON ap.patient_id= u2.id WHERE patient_id= " + patient_id);
            while (rs.next()) {
                obj = new Appointment();
                obj.setId(rs.getInt("id"));
                obj.setDoctorId(new User(rs.getInt("doctor_id"), rs.getString("doctor_name")));
                obj.setPatientId(new User(rs.getInt("patient_id"), rs.getString("patient_name")));
                obj.setAppDate(rs.getString("app_date"));
                list.add(obj);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
    
    @Override
    public ArrayList<Appointment> getDoctorList(int doctor_id) {
        ArrayList<Appointment> list = new ArrayList<>();
        Appointment obj;

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery(" SELECT "
                    + "	 ap.* , "
                    + "  u1.NAME as doctor_name , "
                    + "  u2.NAME as patient_name "
                    + "  FROM  "
                    + "	 appointment ap  "
                    + "	 LEFT JOIN USER u1 ON ap.doctor_id = u1.id "
                    + "	 LEFT JOIN USER u2 ON ap.patient_id= u2.id WHERE doctor_id= " + doctor_id);
            while (rs.next()) {
                obj = new Appointment();
                obj.setId(rs.getInt("id"));
                obj.setDoctorId(new User(rs.getInt("doctor_id"), rs.getString("doctor_name")));
                obj.setPatientId(new User(rs.getInt("patient_id"), rs.getString("patient_name")));
                obj.setAppDate(rs.getString("app_date"));
                list.add(obj);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public Appointment getList(int id) {
        Appointment obj = null;
        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from appointment where id= " + id);
            while (rs.next()) {
                obj = new Appointment();
                obj.setId(rs.getInt("id"));
                obj.setDoctorId(new User(rs.getInt("doctor_id")));
                obj.setPatientId(new User(rs.getInt("patient_id")));
                obj.setAppDate(rs.getString("app_date"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    @Override
    public boolean addAppointment(int doctor_id, int patient_id, String app_date) {
        String query = "Insert into appointment (doctor_id , patient_id , app_date ) values (?,?,?)";
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setInt(1, doctor_id);
            prstmt.setInt(2, patient_id);
            prstmt.setString(3, app_date);
            prstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAppointment(int id) {
        String query = "delete from appointment where id=? " ;
        try {
            prstmt = c.prepareStatement(query);
            prstmt.setInt(1, id);
            Appointment appoint = getList(id);
            workhour.updateActiveWorkhourStatus(appoint.getDoctorId().getId(), appoint.getAppDate());
            prstmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
