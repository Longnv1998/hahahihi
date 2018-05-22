/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connect;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author admin
 */
public class DButilities {
    public static Connection openConnection(){
        Connection con = null;
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=Manager_conversation","sa","1234$");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    public static void main(String[] args) {
        System.out.println(openConnection());
    }
    public static void AllClose( Connection con, PreparedStatement pstmt,CallableStatement cstmt, ResultSet rs){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(pstmt!=null){
            try {
                pstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(cstmt!=null){
            try {
                cstmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(DButilities.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
}

