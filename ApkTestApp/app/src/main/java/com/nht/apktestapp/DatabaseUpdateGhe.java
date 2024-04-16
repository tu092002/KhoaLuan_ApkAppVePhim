package com.nht.apktestapp;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.TimerTask;

public class DatabaseUpdateGhe extends TimerTask {
    private LocalDateTime timeEndPhim; // Set this to your end time

    public DatabaseUpdateGhe(LocalDateTime timeEndPhim) {
        this.timeEndPhim = timeEndPhim;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        if (Duration.between(now, timeEndPhim).toMillis() < 1000*60) {
            // Assuming MainActivity.database.Querydata is a method to execute SQL queries
            MainActivity.database.Querydata("UPDATE Ghe SET empty = 'true'");
        }
    }
}
