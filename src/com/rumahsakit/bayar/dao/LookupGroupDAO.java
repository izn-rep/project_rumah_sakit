/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.dao;

import com.rumahsakit.bayar.utilities.koneksi;
import com.rumahsakit.bayar.model.Lookup_group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;

/**
 *
 * @author General Bassamtiano
 */
public class LookupGroupDAO {
    
    private static final Logger logger = Logger.getLogger(LookupGroupDAO.class.getName());
    private static LookupGroupDAO INSTANCE;
    private static Connection CONNECTION;
    private static final String SELECT_ALL_STATEMENT = "select Lookup_group from lookup_group";
    
    private LookupGroupDAO() {
        try {
            CONNECTION = koneksi.bukakoneksi();
            
        }
        catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
    public static LookupGroupDAO getInstance() throws OperationNotSupportedException {
        if(INSTANCE == null) {
            INSTANCE = new LookupGroupDAO();
        }
        return INSTANCE;
    }
    
    public Lookup_group[] findAll() {
        PreparedStatement _psmt = null;
        ResultSet _rs = null;
        
        List<Lookup_group> _result = new ArrayList<Lookup_group>();
        
        try {
            _psmt = CONNECTION.prepareStatement(SELECT_ALL_STATEMENT);
            _rs = _psmt.executeQuery();
            
            while (_rs.next()) { //(_rs.getString(1));
                Lookup_group _eval = new Lookup_group(_rs.getString(1));
                _result.add(_eval);
                
                logger.log(Level.FINE, "data found");
            }
            
        }
        
        catch (Exception e) {
            e.printStackTrace();;
        }
        
        finally {
            try {
                _rs.close();
                _psmt.close();
                _rs = null;
                _psmt = null;
            }
            catch (SQLException e) {
                
            }
        }
        
        return _result.toArray(new Lookup_group[0]);
    }
    
}
