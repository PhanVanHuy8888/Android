package com.example.a2110900026_phanvanhuy;

public class SinhVien {
    private int id;
    private String hoTen;
    private String image;
    private String monHoc;
    private float diemCC;
    private float diemKT;
    private float diemThi;

    public SinhVien() {
    }

    public SinhVien( String hoTen, String image, String monHoc, float diemCC, float diemKT, float diemThi) {
        this.hoTen = hoTen;
        this.image = image;
        this.monHoc = monHoc;
        this.diemCC = diemCC;
        this.diemKT = diemKT;
        this.diemThi = diemThi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(String monHoc) {
        this.monHoc = monHoc;
    }

    public float getDiemCC() {
        return diemCC;
    }

    public void setDiemCC(float diemCC) {
        this.diemCC = diemCC;
    }

    public float getDiemKT() {
        return diemKT;
    }

    public void setDiemKT(float diemKT) {
        this.diemKT = diemKT;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

    public void getDiemKT(float aFloat) {
    }

    public void getDiemCC(float aFloat) {
    }

    public void getDiemThi(float aFloat) {
    }

    public void getId(int anInt) {
    }
}
