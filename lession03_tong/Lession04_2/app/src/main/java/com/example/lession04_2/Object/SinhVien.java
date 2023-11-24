package com.example.lession04_2.Object;

import java.util.ArrayList;

public class SinhVien {
    private int ma;
    private String ten;
    private ArrayList<MonHoc> monHocs = new ArrayList<>();
    private int tongTien; // Thêm thuộc tính tổng tiền

    public SinhVien() {
    }

    public SinhVien(int ma, String ten, ArrayList<MonHoc> monHocs, int tongTien) {
        this.ma = ma;
        this.ten = ten;
        this.monHocs = monHocs;
        this.tongTien = tongTien;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ArrayList<MonHoc> getMonHocs() {
        return monHocs;
    }

    public void setMonHocs(ArrayList<MonHoc> monHocs) {
        this.monHocs = monHocs;
    }

    public int getTongTien() {
        return tongTien;
    }

    public void setTongTien(int tongTien) {
        this.tongTien = tongTien;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "ma=" + ma +
                ", ten='" + ten + '\'' +
                ", monHocs=" + monHocs +
                ", tongTien=" + tongTien +
                '}';
    }
}
