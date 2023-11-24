package com.example.lession04_2.Object;

public class MonHoc {
    private int ma;
    private String tenMon;

    private int soTin;

    public MonHoc() {
    }

    public MonHoc(int ma, String tenMon, int soTin) {
        this.ma = ma;
        this.tenMon = tenMon;
        this.soTin = soTin;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }

    public int getSoTin() {
        return soTin;
    }

    public void setSoTin(int soTin) {
        this.soTin = soTin;
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ma=" + ma +
                ", tenMon='" + tenMon + '\'' +
                ", soTin=" + soTin +
                '}';
    }
}
