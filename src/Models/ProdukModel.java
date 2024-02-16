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
public class ProdukModel {
    private int ID_Produk;
    private String Nama_Produk;
    private int Harga;
    private String Jenis;

    public ProdukModel() {
    }

    public ProdukModel(String Nama_Produk, int Harga, String Warna) {
        this.Nama_Produk = Nama_Produk;
        this.Harga = Harga;
        this.Jenis = Warna;
    }

    public ProdukModel(int ID_Produk, String Nama_Produk, int Harga, String Warna) {
        this.ID_Produk = ID_Produk;
        this.Nama_Produk = Nama_Produk;
        this.Harga = Harga;
        this.Jenis = Warna;
        
    }

    public int getID_Produk() {
        return ID_Produk;
    }   

    public void setID_Produk(int ID_Produk) {
        this.ID_Produk = ID_Produk;
    }

    public int getHarga() {
        return Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
    }

    public String getJenis() {
        return Jenis;
    }

    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }

    public String getNama_Produk() {
        return Nama_Produk;
    }

    public void setNama_Produk(String Nama_Produk) {
        this.Nama_Produk = Nama_Produk;
    }

    @Override
    public String toString() {
        return Jenis + "ProdukModel{" + "ID_Produk=" + ID_Produk + ", Nama_Produk=" + Nama_Produk + ", Harga=" + Harga
                + ", Jenis=" + '}';
    }

}
