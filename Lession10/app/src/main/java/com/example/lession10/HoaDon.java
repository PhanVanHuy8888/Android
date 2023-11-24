package com.example.lession10;

public class HoaDon {
    private String hoTen;
    private int soPhong;
    private float donGia;
    private int soNgayLuuTru;
    public HoaDon() {
    }

    public HoaDon(String hoTen, int soPhong, float donGia, int soNgayLuuTru) {
        this.hoTen = hoTen;
        this.soPhong = soPhong;
        this.donGia = donGia;
        this.soNgayLuuTru = soNgayLuuTru;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getSoNgayLuuTru() {
        return soNgayLuuTru;
    }

    public void setSoNgayLuuTru(int soNgayLuuTru) {
        this.soNgayLuuTru = soNgayLuuTru;
    }
}
