/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
import Models.KeranjangModel;
import Models.UserModel;
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
public class ControllerKeranjang {

    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public List<KeranjangModel> getCart(UserModel usr) {
        List<KeranjangModel> lsCart = new ArrayList<KeranjangModel>();
        String sql;

        sql = "SELECT * FROM keranjang WHERE ID_User = '" + usr.getID_User() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                KeranjangModel Carta = new KeranjangModel();
                Carta.setID_User(rs.getInt("ID_User"));
                Carta.setID_Produk(rs.getInt("ID_Produk"));
                Carta.setNama_Produk(rs.getString("Nama_Produk"));
                Carta.setJenis(rs.getString("Jenis"));
                Carta.setHarga(rs.getInt("Harga"));
                Carta.setJumlah(rs.getInt("Jumlah"));
                Carta.setTotal(rs.getInt("Total"));

                lsCart.add(Carta);
            }

        } catch (java.sql.SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerKeranjang.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsCart;
    }

    public int saveCart(KeranjangModel Cart) {
        int hasil = 0;
        String sql = null;

        sql = "INSERT INTO keranjang(ID_User, ID_Produk, Nama_Produk, Jenis, Harga, Jumlah, Total) VALUES('"
                + Cart.getID_User() + "','" + Cart.getID_Produk() + "','" + Cart.getNama_Produk() + "','" + Cart.getJenis()  + "','"
                + Cart.getHarga() + "','" + Cart.getJumlah() + "','"
                + Cart.getTotal() + "')";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerKeranjang.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return hasil;
    }

    public int deleteCart(UserModel usr) {
        int hasil = 0;
        String sql = null;
        sql = "DELETE FROM keranjang WHERE ID_User = '" + usr.getID_User() + "'";

        try {
            conMan = new ConnectionManager();
            con = conMan.logOn();

            st = con.createStatement();
            hasil = st.executeUpdate(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerKeranjang.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return hasil;
    }
}
