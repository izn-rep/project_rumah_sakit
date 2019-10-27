
package com.rumahsakit.bayar.dao;


import com.rumahsakit.bayar.utilities.koneksi;
import com.rumahsakit.bayar.model.TarifBayarModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.OperationNotSupportedException;
import javax.swing.JOptionPane;


public class TarifBayarDAO {
 
    private static final Logger logger = Logger.getLogger(TarifBayarDAO.class.getName());
    private static final String SELECT_STATEMENT = "select kodebayar, nama_kamar, tarif, kelas from tarifbayar ";
    private static Connection CONNECTION;
    private static TarifBayarDAO INSTANCE;

    private TarifBayarDAO() {
        try {
            CONNECTION = koneksi.bukakoneksi();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Tidak dapat koneksi pada database" + e);
        }
    }

    public static TarifBayarDAO getInstance() throws OperationNotSupportedException {
        if (INSTANCE == null) {
            INSTANCE = new TarifBayarDAO();
        }
        return INSTANCE;
    }

    public List<TarifBayarModel> findAll() {
        PreparedStatement _pstmt = null;
        ResultSet _rs = null;
        TarifBayarModel _result = null;
        List<TarifBayarModel> result = new ArrayList<TarifBayarModel>();
        try {
            _pstmt = CONNECTION.prepareStatement(SELECT_STATEMENT);
            _rs = _pstmt.executeQuery();
            while (_rs.next()) {

                result.add(getData(_rs));

                logger.log(Level.FINE, "data found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                _rs.close();
                _pstmt.close();
                _rs = null;
                _pstmt = null;
            } catch (SQLException e) {
                // ignored
            }
        }
        return result;
    }

    private TarifBayarModel getData(ResultSet resultSet) throws SQLException {
        //kode, nama, cabang, alamat, kota, persentasedisc, pemakai, tglsimpan
        TarifBayarModel _result = new TarifBayarModel();
        _result.setKodebayar(resultSet.getString(1));
        _result.setNama_kamar(resultSet.getString(2));
        _result.setTarif(resultSet.getDouble(3));
        _result.setKelas(resultSet.getString(4));

        return _result;
    }

    public List findKeteranganByKode(String kode_bayar){
         List _result = new ArrayList();

         PreparedStatement _ps = null;
         ResultSet _rs = null;
         try{
             _ps  = CONNECTION.prepareStatement(SELECT_STATEMENT + "where kodebayar = ?");
             _ps.setString(1, kode_bayar);

             _rs = _ps.executeQuery();
             while(_rs.next())

                 _result.add(getData(_rs));

         }catch (Exception e){

         }

         return _result;

     }
    
}
