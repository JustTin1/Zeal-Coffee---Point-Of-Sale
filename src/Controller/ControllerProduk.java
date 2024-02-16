/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Models.ProdukModel;
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
public class ControllerProduk {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public int saveBrg(ProdukModel brg) {
        int hasil = 0;
        String checkdata, sql;

        checkdata = "SELECT * FROM produk WHERE Nama_Produk LIKE '%" + brg.getNama_Produk() + "%'";
        sql = "INSERT INTO produk(ID_Produk, Nama_Produk, Harga, Jenis)" + "VALUES ('"
                + brg.getID_Produk() + "','" + brg.getNama_Produk() + "','"
                + brg.getHarga() + "','" + brg.getJenis() + "')";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(checkdata);

            if (rs.next() == true) {
                hasil = -1;
            } else {
                hasil = st.executeUpdate(sql);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerProduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public List<ProdukModel> getBrg() {
        List<ProdukModel> lsBrg = new ArrayList<ProdukModel>();
        String sql;

        sql = "SELECT * FROM produk";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                System.out.println(rs.getString("Jenis"));
                ProdukModel bm = new ProdukModel();
                bm.setID_Produk(rs.getInt("ID_Produk"));
                bm.setNama_Produk(rs.getString("Nama_Produk"));
                bm.setHarga(rs.getInt("Harga"));
                bm.setJenis(rs.getString("Jenis"));
                lsBrg.add(bm);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerProduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lsBrg;
    }

    public int updateBrg(ProdukModel brg) {
        int hasil = 0;
        String sql = "UPDATE produk SET Nama_Produk='" + brg.getNama_Produk()
                + "',Harga='" + brg.getHarga() + "',Jenis='" + brg.getJenis()
                + "' WHERE ID_Produk='" + brg.getID_Produk() + "'";
        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerProduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public int deleteBrg(ProdukModel brg) {
        int hasil = 0;
        String sql = "DELETE FROM produk WHERE ID_Produk = '" + brg.getID_Produk() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerProduk.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}