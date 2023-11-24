package com.example.lession08;

public class SinhVien {
    private int sdb;
    private String name;
    private float toan;
    private float ly;
    private float hoa;

    public SinhVien() {
    }

    public SinhVien(int sdb, String name, float toan, float ly, float hoa) {
        this.sdb = sdb;
        this.name = name;
        this.toan = toan;
        this.ly = ly;
        this.hoa = hoa;
    }

    public int getSdb() {
        return sdb;
    }

    public void setSdb(int sdb) {
        this.sdb = sdb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getToan() {
        return toan;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public float getLy() {
        return ly;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public float getHoa() {
        return hoa;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    @Override
    public String toString() {
        float sum = getToan() + getHoa() + getLy();
        return sdb + "\n'" + name + "\n'" + sum;
    }

}
