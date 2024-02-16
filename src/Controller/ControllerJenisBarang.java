/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Models.JenisBarangModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class ControllerJenisBarang {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<JenisBarangModel> getJenisBrg() {
        List<JenisBarangModel> lsJBrg = new ArrayList<JenisBarangModel>();
        String sql;

        sql = "SELECT * FROM jenis_barang ORDER BY ID_Jenis_Barang";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                JenisBarangModel jbm = new JenisBarangModel();
                jbm.setID_Jenis_Barang(rs.getInt("ID_Jenis_Barang"));
                jbm.setNama_Jenis_Barang(rs.getString("Nama_Jenis_Barang"));

                lsJBrg.add(jbm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerJenisBarang.class.getName()).log(Level.SEVERE, null, ex);
        }

        return lsJBrg;
    }
}

