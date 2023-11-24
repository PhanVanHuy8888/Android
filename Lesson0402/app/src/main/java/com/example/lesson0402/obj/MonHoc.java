package com.example.lesson0402.obj;

public class MonHoc {
    private int maMonHoc;
    private  String tenMonHoc;
    private float soTienChi;

    public MonHoc(int maMonHoc, String tenMonHoc, float soTienChi) {
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTienChi = soTienChi;
    }

    public int getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(int maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public float getSoTienChi() {
        return soTienChi;
    }

    public void setSoTienChi(float soTienChi) {
        this.soTienChi = soTienChi;
    }

    public MonHoc() {
    }
}
