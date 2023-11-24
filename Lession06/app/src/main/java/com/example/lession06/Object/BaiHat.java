package com.example.lession06.Object;

public class BaiHat {
    private int maBH;
    private String tenBH;
    private String tenCS;
    private float thoiLuong;

    public BaiHat() {
    }
    public BaiHat(int maBH, String tenBH, String tenCS, float thoiLuong) {
        this.maBH = maBH;
        this.tenBH = tenBH;
        this.tenCS = tenCS;
        this.thoiLuong = thoiLuong;
    }

    public int getMaBH() {
        return maBH;
    }

    public void setMaBH(int maBH) {
        this.maBH = maBH;
    }

    public String getTenBH() {
        return tenBH;
    }

    public void setTenBH(String tenBH) {
        this.tenBH = tenBH;
    }

    public String getTenCS() {
        return tenCS;
    }

    public void setTenCS(String tenCS) {
        this.tenCS = tenCS;
    }

    public float getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(float thoiLuong) {
        this.thoiLuong = thoiLuong;
    }
}
