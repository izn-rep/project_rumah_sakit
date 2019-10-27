/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.dao;

import com.rumahsakit.bayar.utilities.koneksi;
import com.rumahsakit.bayar.model.PoliModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PoliDAO {
    
    private Connection m_connection;
    private static final Logger logger = Logger.getLogger(PoliModel.class.getName());
    
    private static final String CREATE_STATEMENT = "";
    private static final String LIST_STATEMENT = "select kodepoli, namapoli from poli";
    
    private static PoliDAO INSTANCE;
    private static Connection CONNECTION;
    
    public PoliDAO(Connection connection) {
        m_connection = connection;
    }
    
    private PoliDAO() throws SQLException {
        try {
            
            if(CONNECTION == null) {
                CONNECTION = koneksi.bukakoneksi();
            }
            
        }
        catch (SQLException ex) {
            
            Logger.getLogger(PoliDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
    public static PoliDAO getInstance() {
        
        if(INSTANCE == null) {
            
            try {
                
                INSTANCE = new PoliDAO();
                
            }
            
            catch(SQLException ex) {
                Logger.getLogger(PoliDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
        return INSTANCE;
        
    }
    
    public List getListPoliModel() throws DataException {
        
        List _result = new ArrayList();
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        
        try {
            
            _ps = m_connection.prepareStatement(LIST_STATEMENT);
            _rs = _ps.executeQuery();
            
            while (_rs.next()) {
                PoliModel _PoliModel = new PoliModel();
                _PoliModel.setKodepoli(_rs.getString("kodepoli"));
                _PoliModel.setNamapoli(_rs.getString("namapoli"));
                
                _result.add(_PoliModel);
            }
            
        }
        
        catch(SQLException e) {
            
            throw new DataException(e);
            
        }
        
        finally {
            
            try {
                
                _rs.close();
                _ps.close();
                
            }
            
            catch (SQLException ex) {
                
            }
        }
        
        return _result;
        
    }
    
    public List<PoliModel> findAllPoli() {
        
        PreparedStatement _psmt = null;
        
        ResultSet _rs = null;
        PoliModel _result = null;
        
        List<PoliModel> result = new ArrayList<PoliModel>();
        
        try {
            
            _psmt = CONNECTION.prepareStatement(LIST_STATEMENT);
            _rs = _psmt.executeQuery();
            while (_rs.next());
            
        }
        
        catch(Exception e) {
            
            e.printStackTrace();
            
        }
        
        finally {
            
            try {
                
                _psmt = CONNECTION.prepareStatement(LIST_STATEMENT);
                _rs = null;
                _psmt = null;
                
            }
            
            catch (SQLException e) {
                
            }
            
        }
        
       return result; 
        
    }
    
    private PoliModel getData_Poli(ResultSet resultSet) throws SQLException {
        
        PoliModel _result = new PoliModel();
        _result.setKodepoli(resultSet.getString(1));
        _result.setNamapoli(resultSet.getString(2));
        
        return _result;
        
    }
    
}
