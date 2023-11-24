package com.example.lesson0402.obj;

import java.util.List;

public class SinhVien {
    private int MaSv;
    private String TenSv;

    public List<MonHoc> getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(List<MonHoc> monHoc) {
        this.monHoc = monHoc;
    }

    public SinhVien(List<MonHoc> monHoc) {
        this.monHoc = monHoc;
    }

    private List<MonHoc> monHoc;
    public SinhVien(int maSv, String tenSv, MonHoc[] monHocArray) {
        MaSv = maSv;
        TenSv = tenSv;
    }

    public int getMaSv() {
        return MaSv;
    }

    public void setMaSv(int maSv) {
        MaSv = maSv;
    }

    public String getTenSv() {
        return TenSv;
    }

    public void setTenSv(String tenSv) {
        TenSv = tenSv;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "MaSv=" + MaSv +
                ", TenSv='" + TenSv + '\'' +
                ", monHoc=" + monHoc +
                '}';
    }

    public SinhVien() {
    }
}
