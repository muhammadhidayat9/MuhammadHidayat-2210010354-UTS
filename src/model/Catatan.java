package model;
public class Catatan {

    private int id;
    private String judul;
    private String tanggal;
    private String isi;

    public Catatan(int id, String judul, String tanggal, String isi) {
        this.id = id;
        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    // Getter dan Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }
}
