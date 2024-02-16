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
public class TransaksiModel {
    private int ID_Transaksi;
    private int ID_Produk;
    private int ID_User;
    private int Jumlah;
    private int Total;

    public TransaksiModel() {
    }

    public TransaksiModel(int ID_Transaksi, int ID_Produk, int ID_User, int Jumlah, int Total) {
        this.ID_Transaksi = ID_Transaksi;
        this.ID_Produk = ID_Produk;
        this.ID_User = ID_User;
        this.Jumlah = Jumlah;
        this.Total = Total;
    }

    public TransaksiModel(int ID_Produk, int ID_User, int Jumlah, int Total) {

        this.ID_Produk = ID_Produk;
        this.ID_User = ID_User;
        this.Jumlah = Jumlah;
        this.Total = Total;
    }

    public int getID_Transaksi() {
        return this.ID_Transaksi;
    }

    public void setID_Transaksi(int ID_Transaksi) {
        this.ID_Transaksi = ID_Transaksi;
    }

    public int getID_Produk() {
        return this.ID_Produk;
    }

    public void setID_Produk(int ID_Produk) {
        this.ID_Produk = ID_Produk;
    }

    public int getID_User() {
        return this.ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }


    public int getJumlah() {
        return this.Jumlah;
    }

    public void setJumlah(int Jumlah) {
        this.Jumlah = Jumlah;
    }

    public int getTotal() {
        return this.Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "{" +
                " ID_Transaksi='" + getID_Transaksi() + "'" +
                ", ID_Barang='" + getID_Produk() + "'" +
                ", ID_User='" + getID_User() + "'" +
                ", Jumlah='" + getJumlah() + "'" +
                ", Total='" + getTotal() + "'" +
                "}";
    }

}

