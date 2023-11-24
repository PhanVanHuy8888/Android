package com.example.baitap;

public class Contact {
    private int ma;
    private String name;
    private String number;

    public Contact() {
    }

    public Contact(int ma, String name, String number) {
        this.ma = ma;
        this.name = name;
        this.number = number;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return
                ma + "  " + name + '\'' + number;
    }
}
