package com.nht.apktestapp.Model;

import java.util.List;

public class Phim {

    private int maPhim;
    private String tenPhim;
    private String moTa;
    private byte[] imgPhim;
    private double giaPhim;
    private int thoiLuongPhim;
    private String tacGia;
    private String theLoai;
    private String quocGia;
    private double diemPhim;

    public Phim(int maPhim, String tenPhim, String moTa, byte[] imgPhim, double giaPhim, int thoiLuongPhim, String tacGia, String theLoai, String quocGia, double diemPhim) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.moTa = moTa;
        this.imgPhim = imgPhim;
        this.giaPhim = giaPhim;
        this.thoiLuongPhim = thoiLuongPhim;
        this.tacGia = tacGia;
        this.theLoai = theLoai;
        this.quocGia = quocGia;
        this.diemPhim = diemPhim;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public int getThoiLuongPhim() {
        return thoiLuongPhim;
    }

    public void setThoiLuongPhim(int thoiLuongPhim) {
        this.thoiLuongPhim = thoiLuongPhim;
    }

    public Phim(int maPhim, String tenPhim, String moTa, byte[] imgPhim, double giaPhim, int thoiLuongPhim) {
        this.maPhim = maPhim;
        this.tenPhim = tenPhim;
        this.moTa = moTa;
        this.imgPhim = imgPhim;
        this.giaPhim = giaPhim;
        this.thoiLuongPhim = thoiLuongPhim;
        this.diemPhim = diemPhim;
    }

    public double getDiemPhim() {
        return diemPhim;
    }

    public void setDiemPhim(double diemPhim) {
        this.diemPhim = diemPhim;
    }




    public double getGiaPhim() {
        return giaPhim;
    }

    public void setGiaPhim(double giaPhim) {
        this.giaPhim = giaPhim;
    }

    public Phim(int maPhim, String tenPhim, String moTa, byte[] imgPhim, double giaPhim) {
        this.tenPhim = tenPhim;
        this.moTa = moTa;
        this.imgPhim = imgPhim;
        this.maPhim = maPhim;
        this.giaPhim= giaPhim;
    }


    public byte[] getImgPhim() {
        return imgPhim;
    }

    public void setImgPhim(byte[] imgPhim) {
        this.imgPhim = imgPhim;
    }


    public Phim() {
    }

    public int getMaPhim() {
        return maPhim;
    }

    public void setMaPhim(int maPhim) {
        this.maPhim = maPhim;
    }

    public String getTenPhim() {
        return tenPhim;
    }

    public void setTenPhim(String tenPhim) {
        this.tenPhim = tenPhim;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }


}
