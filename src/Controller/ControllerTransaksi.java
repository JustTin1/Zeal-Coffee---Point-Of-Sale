/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Models.TransaksiModel;
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
public class ControllerTransaksi {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<TransaksiModel> getTrx() {
        List<TransaksiModel> lsTrx = new ArrayList<TransaksiModel>();
        String sql;

        sql = "SELECT * FROM transaksi ORDER BY ID_TRANSAKSI";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                TransaksiModel trxa = new TransaksiModel();
                trxa.setID_Transaksi(rs.getInt("ID_Transaksi"));
                trxa.setID_Produk(rs.getInt("ID_Produk"));
                trxa.setID_User(rs.getInt("ID_User"));
                trxa.setJumlah(rs.getInt("Jumlah"));
                trxa.setTotal(rs.getInt("Total"));

                lsTrx.add(trxa);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsTrx;
    }

    public int saveTrx(TransaksiModel trx) {
        int hasil = 0;
        String sql = null;

        sql = "INSERT INTO transaksi(ID_Produk, ID_User, Jumlah, Total) VALUES('" + trx.getID_Produk()
                + "','" + trx.getID_User() + "','" + trx.getJumlah() + "','"
                + trx.getTotal() + "')";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerTransaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}

