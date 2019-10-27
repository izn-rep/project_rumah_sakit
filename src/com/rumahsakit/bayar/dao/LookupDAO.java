/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.dao;

import com.rumahsakit.bayar.utilities.koneksi;
import com.rumahsakit.bayar.model.Lookup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;

public class LookupDAO {
    
    private static final String FIND_QUERY = "select Lookup_group, value, status,kode_character from lookup where Lookup_group = ? and status = 1";
    private static final String FIND_QUERY_KODE_PLUS_VALUE = "SELECT LOOKUP_GROUP, KODE, KODE || ' - ' || VALUE AS DESCRIPSI, STATUS FROM LOOKUP WHERE LOOKUP_GROUP=? AND STATUS = 1 ORDER BY CAST(KODE AS NUMERIC)";
    private static final String SELECT_ALL_STATEMENT = "select Lookup_group, value, status, kode_character from lookup";
    
    private static LookupDAO INSTANCE;
    private static Connection CONNECTION;
    
    public static LookupDAO getInstance() throws OperationNotSupportedException {
        if(INSTANCE == null) {
            INSTANCE = new LookupDAO();
        }
        return INSTANCE;
    }
    
    public List find(String lookupGroup) {
        List _result = new ArrayList();
        try {
            Connection _c = getConnection();
            PreparedStatement _ps = _c.prepareStatement(FIND_QUERY + "order by cast(kode_character as numeric)");
            _ps.setString(1, lookupGroup);
            
            ResultSet _rs = _ps.executeQuery();
            while(_rs.next()) {
                Lookup _eval = new Lookup();
                _eval.setLookup_group(_rs.getString(1));
                _eval.setValue(_rs.getString(2));
                _eval.setStatus(_rs.getInt(3));
                _eval.setKode_character(_rs.getString(4));
                
                _result.add(_eval);
            }
            
            _rs.close();
            _ps.close();
            
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return _result;
    }
    
    public Lookup[] findAll() {
        List _result = new ArrayList();
        
        try {
            Connection _c = getConnection();
            PreparedStatement _ps = _c.prepareStatement(SELECT_ALL_STATEMENT);
            
            ResultSet _rs = _ps.executeQuery();
            while(_rs.next()) {
                Lookup _eval = new Lookup();
                _eval.setLookup_group(_rs.getString(1));
                _eval.setValue(_rs.getString(2));
                _eval.setValue(_rs.getString(3));
                _eval.setKode_character(_rs.getString(4));
                
                _result.add(_eval);
                
            }
            
            _rs.close();
            _ps.close();
            
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        return (Lookup[]) _result.toArray(new Lookup[0]);
    }
    
    private Connection getConnection() throws ClassNotFoundException, SQLException{
        return koneksi.bukakoneksi();
    }
    
}
