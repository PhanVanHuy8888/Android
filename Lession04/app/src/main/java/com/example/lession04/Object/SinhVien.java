package com.example.lession04.Object;

public class SinhVien {
    private int maSV;
    private String tenSV;
    private float point;

    public SinhVien() {

    }
    public SinhVien(int maSV, String tenSV, float point) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.point = point;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }
}
