package com.nht.apktestapp.Dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import com.nht.apktestapp.MainActivity;
import com.nht.apktestapp.Model.Phim;
import com.nht.apktestapp.Model.PhimXuat;

import java.util.ArrayList;
import java.util.List;

public  class PhimXuatDao {
    public static int insertPhimXuat(PhimXuat px){
        try {
            MainActivity.database.Querydata("INSERT INTO PhimXuat(MaPhimXuat,MaPhim,MaXuatChieu) VALUES (null,"+px.getMaPhim()+", "+px.getMaXuatChieu()+")");
            return 1; // thành công
        } catch (Exception ex) {
            return -1;// fail
        }
    }
    public static List<String> getListPhimXuatByMaPhim(int maPhim) {
        List<String> list = new ArrayList<>();
        Cursor c = MainActivity.database.GetData("SELECT XuatChieu.TimeXuatChieu FROM PhimXuat " +
                " INNER JOIN XuatChieu ON XuatChieu.MaXuatChieu = PhimXuat.MaXuatChieu "
                + " WHERE PhimXuat.MaPhim = '" + maPhim + "'");
        list.clear();
        c.moveToFirst();
        while (c.isAfterLast() == false) {

           String p = c.getString(0);

            list.add(p);
            c.moveToNext();
        }
        c.close();

        return list;
    }}
