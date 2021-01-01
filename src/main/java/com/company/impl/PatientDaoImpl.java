package com.company.impl;

import com.company.helper.DBConnection;
import com.company.helper.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.company.inter.PatientDaoInter;

/**
 *
 * @author Eminov
 */
public class PatientDaoImpl implements PatientDaoInter {

    DBConnection conn = DBConnection.instance();
    Connection c = conn.dbConn();
    Statement stmt = null;
    PreparedStatement prstmt = null;
    ResultSet rs = null;

    @Override
    public boolean register(String name, String username, String password) {
        boolean duplicate = false;
        String query = "Insert into user (name , username , password  ) values (?,?,?)";

        try {
            stmt = c.createStatement();
            rs = stmt.executeQuery("select * from user where username='" + username + "'");
            while (rs.next()) {
                duplicate = true;
                Helper.showMsg(" this username already exists ");
                return false;
            }
            if (!duplicate) {
                prstmt = c.prepareStatement(query);
                prstmt.setString(1, name);
                prstmt.setString(2, username);
                prstmt.setString(3, password);
                prstmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
