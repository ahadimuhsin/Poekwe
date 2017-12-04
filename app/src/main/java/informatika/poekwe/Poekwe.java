package informatika.poekwe;

/**
 * Created by Muhsin Ahadi on 12/4/2017.
 */

public class Poekwe {

    private int id_warung;
    private String nama,alamat,gambar, longitude, latitude;

    public Poekwe(int id_warung, String nama, String alamat, String gambar) {
        this.id_warung = id_warung;
        this.nama = nama;
        this.alamat = alamat;
        this.gambar = gambar;
    }

    public Poekwe(int id_warung, String nama, String alamat, String gambar,
                  String longitude, String latitude) {
        this.id_warung = id_warung;
        this.nama = nama;
        this.alamat = alamat;
        this.gambar = gambar;
        this.longitude = longitude;
        this.latitude = latitude;

    }

    public int getId_warung() {
        return id_warung;
    }

    public void setId_warung(int id_warung) {
        this.id_warung = id_warung;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAlamat() {

        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getgambar() {
        return gambar;
    }

    public void gambar(String gambar) {
        this.gambar = gambar;
    }
}
