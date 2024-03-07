package com.nht.apktestapp.Model;

import java.time.LocalDateTime;
import java.time.LocalDateTime;

public class XuatChieu {
    private int maXuatChieu;
    private LocalDateTime timeXuatChieu;

    public XuatChieu(int maXuatChieu, LocalDateTime timeXuatChieu) {
        this.maXuatChieu = maXuatChieu;
        this.timeXuatChieu = timeXuatChieu;
    }
    public XuatChieu(){

    }
    public int getMaXuatChieu() {
        return maXuatChieu;
    }

    public void setMaXuatChieu(int maXuatChieu) {
        this.maXuatChieu = maXuatChieu;
    }

    public LocalDateTime getTimeXuatChieu() {
        return timeXuatChieu;
    }

    public void setTimeXuatChieu(LocalDateTime timeXuatChieu) {
        this.timeXuatChieu = timeXuatChieu;
    }
}
