package com.example.quesomeesse;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.HandlerThread;
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
        HandlerThread thread = new HandlerThread("ServiceStartArguments");
        thread.start();
    }
    @Override
    public void onDestroy() {
        stopService(new Intent(this, Reload.class));
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        prefs = getSharedPreferences("data", MODE_PRIVATE);
        if (prefs.getInt("lives", 0) == 10) {
            stopService(new Intent(this, Reload.class));
        } else {
            new CountDownTimer(5000, 1000) {
                public void onTick(long millisUntilFinished) {
                    tempo = millisUntilFinished;
                }

                public void onFinish() {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("lives", prefs.getInt("lives", 0) + 1);
                    editor.apply();
                }
            }.start();
        }
        return START_STICKY;
    }
}