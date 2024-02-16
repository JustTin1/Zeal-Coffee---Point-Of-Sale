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
public class JenisBarangModel {
    private int ID_Jenis_Barang;
    private String Nama_Jenis_Barang;

    public JenisBarangModel() {
    }

    public JenisBarangModel(int ID_Jenis_Barang, String Nama_Jenis_Barang) {
        this.ID_Jenis_Barang = ID_Jenis_Barang;
        this.Nama_Jenis_Barang = Nama_Jenis_Barang;
    }

    public int getID_Jenis_Barang() {
        return this.ID_Jenis_Barang;
    }

    public void setID_Jenis_Barang(int ID_Jenis_Barang) {
        this.ID_Jenis_Barang = ID_Jenis_Barang;
    }

    public String getNama_Jenis_Barang() {
        return this.Nama_Jenis_Barang;
    }

    public void setNama_Jenis_Barang(String Nama_Jenis_Barang) {
        this.Nama_Jenis_Barang = Nama_Jenis_Barang;
    }

    @Override
    public String toString() {
        return "{" +
                " ID_Jenis_Barang='" + getID_Jenis_Barang() + "'" +
                ", Nama_Jenis_Barang='" + getNama_Jenis_Barang() + "'" +
                "}";
    }

}
