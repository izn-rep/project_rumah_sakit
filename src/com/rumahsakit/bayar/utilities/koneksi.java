package com.rumahsakit.bayar.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    
    private static Connection m_connection;
    
    public koneksi() {
        
    }
    
    public static Connection bukakoneksi() throws SQLException {
        
        Connection conn = null;
        
        String loginUser = "postgresql";
        String loginPassword = "admin";
        String loginUrl = "jdbc:postgresql://localhost:5432/rsakit";
        
        try {
            
            return bukakoneksi("org.postgresql.Driver","jdbc:postgresql://localhost:5432/rsakit", "postgres", "admin");
            
        }
            
        catch (SQLException se) {
            
            System.err.println("No Connection Open");
            return null;
            
        }
        
        catch (Exception ex) {
            
            System.err.println("Could Not open connection");
            return null;

        }
        
    }
    
    public static Connection bukakoneksi(String driverName, String url, String userName, String password) throws Exception{
        try {
            if (m_connection == null) {
                
                Class.forName(driverName);
                m_connection = DriverManager.getConnection(url, userName, password);
                
            }
        }
        
        catch(Exception e ) {
            
            throw e;
            
        }
        
        return m_connection;

    }

}
