package com.example.quesomeesse;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;

public class Reload extends Service {

    private long tempo;
    SharedPreferences prefs;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public void onCreate() {

    }
    @Override
    public void onDestroy() {
        stopService(new Intent(this, Reload.class));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        prefs = getSharedPreferences("data", MODE_PRIVATE);

        // Reload the lives until it is 10
        new Thread(() -> {
            while(true)
            {
                try {
                    if (prefs.getInt("lives", 0) < 10) {
                        Thread.sleep(5000);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("lives", prefs.getInt("lives", 0) + 1);
                        editor.apply();
                    }

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }).start();

        return START_STICKY;
    }
}