package com.nht.apktestapp.Model;

public class PhimXuat {
    private int MaPhimXuat;
    private int MaPhim;
    private int MaXuatChieu;

    public PhimXuat(int maPhimXuat, int maPhim, int maXuatChieu) {
        MaPhimXuat = maPhimXuat;
        MaPhim = maPhim;
        MaXuatChieu = maXuatChieu;
    }
    public PhimXuat(){

    }

    public int getMaPhimXuat() {
        return MaPhimXuat;
    }

    public void setMaPhimXuat(int maPhimXuat) {
        MaPhimXuat = maPhimXuat;
    }

    public int getMaPhim() {
        return MaPhim;
    }

    public void setMaPhim(int maPhim) {
        MaPhim = maPhim;
    }

    public int getMaXuatChieu() {
        return MaXuatChieu;
    }

    public void setMaXuatChieu(int maXuatChieu) {
        MaXuatChieu = maXuatChieu;
    }
}
