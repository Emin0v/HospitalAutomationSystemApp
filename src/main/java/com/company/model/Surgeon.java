/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.model;

/**
 *
 * @author Eminov
 */
public class Surgeon extends User {

//    Connection c = conn.dbConn();
//    Statement stmt = null;
//    PreparedStatement prstmt=null;
//    ResultSet rs = null;

    public Surgeon() {
    }

    public Surgeon(Integer id, String username, String password, String name, String type) {
        super(id, username, password, name, type);
    }

//    public ArrayList<User> getDoctorList() throws SQLException {
//        
//        ArrayList<User> list = new ArrayList<>();
//        User user;
//        try {
//            stmt = c.createStatement();
//            rs = stmt.executeQuery("SELECT * FROM `user` WHERE type='doctor';");
//            while (rs.next()) {
//                user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getString("type"));
//                list.add(user);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return list;
//    }
//    
//    public boolean addDoctor(String username , String password , String name ) throws SQLException{
//        String query = "insert into user (username,password,name,type) values(?,?,?,?)";
//        boolean key=false;
//        try{
//        prstmt = c.prepareStatement(query);
//        prstmt.setString(1, username);
//        prstmt.setString(2, password);
//        prstmt.setString(3, name);
//        prstmt.setString(4, "doctor");
//        prstmt.executeUpdate();
//        key=true;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return key;
//    }
//    
//    public boolean deleteDoctor(Integer id) throws SQLException{
//        String query = "delete from user where id=?";
//        boolean key=false;
//        try{
//        prstmt = c.prepareStatement(query);
//        prstmt.setInt(1, id);
//        prstmt.executeUpdate();
//        key=true;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return key;
//    }
//    
//     public boolean updateDoctor(Integer id , String username , String password , String name ) throws SQLException{
//        String query = "update user set name=? , username=? , password=?  where id=?";
//        boolean key=false;
//        try{
//        prstmt = c.prepareStatement(query);
//        prstmt.setString(1, name);
//        prstmt.setString(2, username);
//        prstmt.setString(3, password);
//        prstmt.setInt(4, id);
//        prstmt.executeUpdate();
//        key=true;
//        }catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return key;
//    }

}
