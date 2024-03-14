package com.nht.apktestapp.Dao;

import android.database.Cursor;

import com.nht.apktestapp.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class XuatChieuDao {
    public static List<Integer>  getListMaXuatChieu (){
        List<Integer> list = new ArrayList<>();
        Cursor c = MainActivity.database.GetData("SELECT XuatChieu.MaXuatChieu " +
                "FROM XuatChieu");
        list.clear();
        if (c.moveToFirst()) {
            do {
                int p = c.getInt(0);
                list.add(p);
            } while (c.moveToNext());
        }
        c.close();
        return list;

    }
}
