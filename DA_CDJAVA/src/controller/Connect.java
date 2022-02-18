/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mr Trung
 */
public class Connect {
    public static Connection conn = null;
    public static String userID  = "";
    public static String name = "";
    public static String getConnection(){
        String connString ="jdbc:sqlserver://LAPTOP-G0I3AISP\\SQLEXPRESS01;databaseName=GAME;user=ChiTrung;password=180000";
        String kq = "";
        try{
            conn = (Connection) DriverManager.getConnection(connString);
            
        }catch(SQLException ex){
            kq = "Lỗi kết nối SQL" +ex;
        }
        return kq;
    }

    CallableStatement prepareCall(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
