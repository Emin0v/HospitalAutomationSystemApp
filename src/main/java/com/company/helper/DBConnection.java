package com.company.helper;

import java.sql.* ;
/**
 *
 * @author Eminov
 */
public class DBConnection {
    
    private static DBConnection conn = null;
    
    private DBConnection(){
        
    }
    
    public static DBConnection instance(){
        if(conn==null){
            conn=new DBConnection();
        }
        return conn;
    }
    
    public Connection dbConn() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            String url = "jdbc:mysql://localhost:3306/hospital?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Baku";
            String username = "root";
            String password = "12345";
            
            Connection c = DriverManager.getConnection(url,username,password);
        
            return c;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
