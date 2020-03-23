package com.example.uploadlihat;

public class Feedback {
    private int id;
    private String gambar, nama, komentar;

    public Feedback(int id, String nama, String komentar, String gambar) {
        this.id = id;
        this.gambar = gambar;
        this.nama = nama;
        this.komentar = komentar;
    }

    public int getId() {
        return id;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama() {
        return nama;
    }

    public String getKomentar() {
        return komentar;
    }

}
