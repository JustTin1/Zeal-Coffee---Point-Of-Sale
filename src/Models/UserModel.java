/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author marti
 */
public class UserModel {
    private int ID_User;
    private String Username;
    private String Password;
    private String Nama;

    public UserModel() {
    }

    public UserModel(String Username, String Password, String Nama) {
        this.Username = Username;
        this.Password = Password;
        this.Nama = Nama;
   
    }

    public int getID_User() {
        return this.ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public String getUsername() {
        return this.Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getNama() {
        return this.Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }



    @Override
    public String toString() {
        return "{" +
                " ID_User='" + getID_User() + "'" +
                ", Username='" + getUsername() + "'" +
                ", Password='" + getPassword() + "'" +
                ", Nama='" + getNama() + "'" +
                "}";
    }
}
