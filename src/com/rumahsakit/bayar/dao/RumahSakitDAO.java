/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rumahsakit.bayar.dao;


import com.rumahsakit.bayar.model.RumahSakitModel;
import com.rumahsakit.bayar.utilities.koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author General Bassamtiano
 */
public class RumahSakitDAO {
    
    private Connection m_connection;
    
    private static final Logger logger = Logger.getLogger(RumahSakitDAO.class.getName());
    
    private static final String CREATE_STATEMENT = "insert into bayar (no_pasien, nama, jkelamin, kodepoli, kodebayar, tarif, nama_kamar, kelas, lama, biayaperawatan, totalbayar) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String LIST_STATEMENT = "select no_pasien, nama, jkelamin, kodepoli, kodebayar, tarif, nama_kamar, kelas, lama, biayaperawatan, total_bayar from bayar ";
    private static final String UPDATE_STATEMENT = "update bayar set no_pasien = ?, nama = ?, jkelamin = ?, kodepoli = ?, kodebayar = ?, lama = ?, biayaperawatan = ?";
    private static final String DELETE_STATEMENT = "delete from bayar where no_pasien = ?";
    
    private static RumahSakitDAO INSTANCE;
    private static Connection CONNECTION;
    
    public RumahSakitDAO(Connection connection) {
        
        m_connection = connection;
        
    }
    
    private RumahSakitDAO() throws SQLException {
        
        try {
            
            if(CONNECTION == null) {
                CONNECTION = koneksi.bukakoneksi();
            }
            
        }
        
        catch (SQLException ex) {
            
            Logger.getLogger(RumahSakitDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
    public static RumahSakitDAO getInstance() {
        
        try {
            if(INSTANCE == null) {
            
                INSTANCE = new RumahSakitDAO();
            
            }
        }
        
        catch(SQLException ex) {
            Logger.getLogger(RumahSakitDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return INSTANCE;
        
    }
    
    public RumahSakitModel createRumahSakit(RumahSakitModel value) throws DataException {
        
        PreparedStatement _ps = null;
        
        try {
            
            _ps = m_connection.prepareStatement(CREATE_STATEMENT);
            _ps.setString(1, value.getNo_pasien());
            _ps.setString(2, value.getNama());
            _ps.setString(3, value.getJkelamin());
            _ps.setString(4, value.getKodepoli());
            _ps.setString(5, value.getKodebayar());
            _ps.setDouble(6, value.getTarif());
            _ps.setString(7, value.getNama_kamar());
            _ps.setString(8, value.getKelas());
            _ps.setInt(9, value.getLama());
            _ps.setDouble(10, value.getBiayaperawatan());
            _ps.setDouble(11, value.getTotalbayar());
            
            if(_ps.executeUpdate() > 0)
                return value;
            
        }
        
        catch(SQLException e) {
            e.printStackTrace();
            throw new DataException(e);
        }
        
        finally {
            try {
                _ps.close();
            }
            catch(SQLException ex) {
                
            }
            
        }
        
        return value;
        
    }
    
    private RumahSakitModel populateRumahSakit(ResultSet _rs) throws SQLException {
        RumahSakitModel _invoice = new RumahSakitModel();
        _invoice.setNo_pasien(_rs.getString("no_pasien"));
        _invoice.setNama(_rs.getString("nama"));
        _invoice.setJkelamin(_rs.getString("jkelamin"));
        _invoice.setKodepol(_rs.getString("kodepoli"));
        _invoice.setKodebayar(_rs.getString("kodebayar"));
        _invoice.setLama(_rs.getInt("lama"));
        _invoice.setBiayaperawatan(_rs.getDouble("biayaperawatan"));
        
        return _invoice;
        
    }
    
     public List findRumahSakitByNoPasien(String no_pasien) {
        
        List _result = new ArrayList();
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        
        
        try {
            
            _ps = m_connection.prepareStatement(LIST_STATEMENT + "where no_pasien = ?");
            _ps.setString(1, no_pasien);
            
            _rs = _ps.executeQuery();
            while(_rs.next());
            
            _result.add(getObject(_rs));
            
        }
        
        catch(Exception e) {
            
        }
        
        return _result;
    }
    
    public RumahSakitModel getObject(String no_pasien) {
        PreparedStatement _pstmt = null;
        ResultSet _rs = null;
        try {
            _pstmt = m_connection.prepareStatement(LIST_STATEMENT);
            _pstmt.setString(1, no_pasien);
            _rs = _pstmt.executeQuery();
            
            if (_rs.next()){
                return getObject(_rs);
            }
        }
        
        catch(SQLException e) {
            e.printStackTrace();
        }
        
        finally {
            try {
                _rs.close();
                _pstmt.close();
            }
            
            catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public List<RumahSakitModel> findAllRumahSakit() {
        PreparedStatement _pstmt = null;
        ResultSet _rs = null;
        
        List<RumahSakitModel> result = new ArrayList<RumahSakitModel>();
        
        try {
            _pstmt = CONNECTION.prepareStatement(LIST_STATEMENT + "order by nama");
            _rs = _pstmt.executeQuery();
            while(_rs.next()){
                result.add(getObject(_rs));
                logger.log(Level.FINE, "data found");
            }
        }
        
        catch(Exception e) {
            e.printStackTrace();
        }
        
        finally {
            try {
                _rs.close();
                _pstmt.close();
                _rs = null;
                _pstmt = null;
            }
            
            catch(SQLException e) {
                
            }
        }
        
        return result;
    }
    
    private RumahSakitModel getObject(ResultSet _rs) throws SQLException {
        RumahSakitModel _detail = new RumahSakitModel();
        _detail.setNo_pasien(_rs.getString(1));
        _detail.setNama(_rs.getString(2));
        _detail.setJkelamin(_rs.getString(3));
        _detail.setKodepol(_rs.getString(4));
        _detail.setKodebayar(_rs.getString(5));
        _detail.setTarif(_rs.getInt(6));
        _detail.setNama_kamar(_rs.getString(7));
        _detail.setKelas(_rs.getString(8));
        _detail.setLama(_rs.getInt(9));
        _detail.setBiayaperawatan(_rs.getDouble(10));
        _detail.setTotalbayar(_rs.getDouble(11));
        
        return _detail;
        
    }
    
    public void delete(String _no_pasien) {
        PreparedStatement _pstmt = null;
        
        try {
            _pstmt = m_connection.prepareStatement(DELETE_STATEMENT);
            _pstmt.setString(1, _no_pasien);
            _pstmt.executeUpdate();
        }
        
        catch(SQLException e) {
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
        
        finally {
            try {
                _pstmt.close();
                _pstmt = null;
            }
            
            catch(SQLException e) {
                
            }
        }
    }
    
    public RumahSakitModel Update(RumahSakitModel value) throws DataException {
        PreparedStatement _ps = null;
        
        try {
            _ps = m_connection.prepareStatement(UPDATE_STATEMENT + "where no_pasien = '" + value.getNo_pasien() + "'");
            _ps.setString(1, value.getNo_pasien()); // change to No_pasien
            _ps.setString(2, value.getNama());
            _ps.setString(3, value.getJkelamin());
            _ps.setString(4, value.getKodepoli());
            _ps.setString(5, value.getKodebayar());
            _ps.setInt(6, value.getLama());
            _ps.setDouble(7, value.getBiayaperawatan());
            
            if(_ps.executeUpdate() > 0)
                return value;
        }
        
        catch(SQLException e) {
            e.printStackTrace();
            throw new DataException(e);
        }
        
        finally {
            try {
                _ps.close();
            }
            catch(SQLException ex) {
                
            }
        }
        
        return value;
    }
    
}
