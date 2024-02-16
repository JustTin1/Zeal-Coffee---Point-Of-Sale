package Models;

public class KeranjangModel {
    private int ID_User;
    private int ID_Produk;
    private String Nama_Produk;
    private int Harga;
    private int Jumlah;
    private String Jenis;
    private int Total;

    public KeranjangModel() {
    }

    public KeranjangModel(int ID_User, int ID_Produk,String Nama_Produk, int Jumlah, int Harga,String Jenis, int Total) {
        this.ID_User = ID_User;
        this.ID_Produk = ID_Produk;
        this.Nama_Produk = Nama_Produk;
        this.Jumlah = Jumlah;
        this.Harga = Harga;
        this.Jenis = Jenis;
        this.Total = Total;
    }

    public KeranjangModel(int ID_Produk, String Nama_Produk, String Jenis ,int Jumlah ) {
       this.ID_Produk = ID_Produk;
       this.Nama_Produk = Nama_Produk;
       this.Jenis = Jenis;
       this.Jumlah = Jumlah;
    }

    public int getID_User() {
        return this.ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public int getID_Produk() {
        return this.ID_Produk;
    }

    public void setID_Produk(int ID_Produk) {
        this.ID_Produk = ID_Produk;
    }

    public String getNama_Produk() {
        return this.Nama_Produk;
    }

    public void setNama_Produk(String Nama_Produk) {
        this.Nama_Produk = Nama_Produk;
    }

    public int getHarga() {
        return this.Harga;
    }

    public void setHarga(int Harga) {
        this.Harga = Harga;
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
    
    public String getJenis() {
        return this.Jenis;
    }
    
    public void setJenis(String Jenis) {
        this.Jenis = Jenis;
    }
    

    @Override
    public String toString() {
        return "{" +
                " ID_User='" + getID_User() + "'" +
                ", ID_Barang='" + getID_Produk() + "'" +
                ", Nama_Nama_Produk='" + getNama_Produk() + "'" +
                ", Jumlah='" + getJumlah() + "'" +
                ", Jenis='" + getJumlah() + "'" +
                ", Harga='" + getHarga() + "'" +
                "}";
    }

}
