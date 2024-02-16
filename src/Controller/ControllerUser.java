/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Connection.ConnectionManager;
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
public class ControllerUser {
    private ConnectionManager conMan;
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public int saveUser(UserModel user) {
        int hasil = 0;
        String checkdata, sql;

        checkdata = "SELECT * FROM user WHERE Username LIKE '%" + user.getUsername() + "%'";
        sql = "INSERT INTO user(ID_User, Username, Password, Nama )"
                + "VALUES ('" + user.getID_User() + "','" + user.getUsername() + "','" + user.getPassword() + "','"
                + user.getNama() + "')";

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
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public List<UserModel> getUser() {
        List<UserModel> lsUser = new ArrayList<UserModel>();
        String sql;

        sql = "SELECT * FROM user";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                UserModel um = new UserModel();
                um.setID_User(rs.getInt("ID_User"));
                um.setUsername(rs.getString("Username"));
                um.setPassword(rs.getString("Password"));
                um.setNama(rs.getString("Nama"));

                lsUser.add(um);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        conMan.logOff();
        return lsUser;
    }

    public int deleteUser(UserModel user) {
        int hasil = 0;
        String sql = "DELETE FROM user WHERE ID_User = '" + user.getID_User() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            hasil = st.executeUpdate(sql);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error : " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }

    public int Login(UserModel usr) {
        int hasil = 0;
        String sql = "SELECT * FROM user WHERE Username = '" + usr.getUsername() + "'";

        conMan = new ConnectionManager();
        con = conMan.logOn();

        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                if (!rs.getString("Password").equals(usr.getPassword())) {
                    hasil = -1;
                } else if (rs.getString("password").equals(usr.getPassword())) {
                    usr.setID_User(rs.getInt("ID_User"));
                    usr.setUsername(rs.getString("Username"));
                    usr.setNama(rs.getString("Nama"));

                    hasil = 1;
                } else {
                    hasil = 0;
                }
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ControllerUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMan.logOff();
        return hasil;
    }
}
