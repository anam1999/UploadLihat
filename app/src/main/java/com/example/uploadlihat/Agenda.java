package com.example.uploadlihat;

public class Agenda {
    private int id;
    private String gambar, nama_agenda, keterangan;

    public Agenda(int id, String nama_agenda, String keterangan, String gambar) {
        this.id = id;
        this.gambar = gambar;
        this.nama_agenda = nama_agenda;
        this.keterangan = keterangan;
    }

    public int getId() {
        return id;
    }

    public String getGambar() {
        return gambar;
    }

    public String getNama_agenda() {
        return nama_agenda;
    }

    public String getKeterangan() {
        return keterangan;
    }

}
